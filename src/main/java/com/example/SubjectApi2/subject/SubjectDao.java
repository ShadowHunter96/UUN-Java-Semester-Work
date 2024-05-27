package com.example.SubjectApi2.subject;

import com.example.SubjectApi2.commons.ConvertEntities;
import com.example.SubjectApi2.factory.SubjectFactory;
import com.example.SubjectApi2.repository.SubjectRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 20:38
 */

@Component
public class SubjectDao {

    private final SubjectRepository subjectRepository;

    public SubjectDao(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDto> findSubjects(SubjectFilterDto subjectFilterDto) {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll(getSubjectSpecification(subjectFilterDto),
                Sort.by(subjectFilterDto.getOrderList()));
        return ConvertEntities.fromEntities(subjectEntities, SubjectFactory::fromEntity);
    }

    private Specification<SubjectEntity> getSubjectSpecification(SubjectFilterDto filter) {
        return (Root<SubjectEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                criteriaBuilder.and(getSubjectPredicateList(filter, root, criteriaBuilder).toArray(new Predicate[0]));
    }

    private List<Predicate> getSubjectPredicateList(
            SubjectFilterDto filter, Root<SubjectEntity> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getDescription() != null && !filter.getDescription().isEmpty()){
            String likePattern = "%" + filter.getDescription() + "%";
            predicates.add(criteriaBuilder.like(root.get("description"), likePattern));
        }

        if (filter.getDeleted() != null) {
            predicates.add(criteriaBuilder.equal(root.get("deleted"), filter.getDeleted()));
        }

        if (filter.getIco() != null && !filter.getIco().isEmpty()){
            String likePattern = "%" + filter.getIco() + "%";
            predicates.add(criteriaBuilder.like(root.get("ico"), likePattern));
        }
        return predicates;
    }

    public Page<SubjectDto> findSubjectPage(SubjectFilterDto subjectFilterDto) {
        Page<SubjectEntity> userEntityPage = subjectRepository.findAll(getSubjectSpecification(subjectFilterDto),
                PageRequest.of(subjectFilterDto.getPage(), subjectFilterDto.getSize(),
                        Sort.by(subjectFilterDto.getOrderList())));
        List<SubjectDto> supplierDtoList = ConvertEntities
                .fromEntities(userEntityPage.toList(), SubjectFactory::fromEntity);
        return new PageImpl<>(supplierDtoList, PageRequest.of(subjectFilterDto.getPage(),
                subjectFilterDto.getSize(), Sort.by(subjectFilterDto.getOrderList())),
                userEntityPage.getTotalElements());
    }
}





