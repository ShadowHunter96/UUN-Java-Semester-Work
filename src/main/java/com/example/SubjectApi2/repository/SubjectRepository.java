package com.example.SubjectApi2.repository;

import com.example.SubjectApi2.subject.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 11:39
 */
@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long>, JpaSpecificationExecutor<SubjectEntity> {
    boolean existsByIco(String ico);

}
