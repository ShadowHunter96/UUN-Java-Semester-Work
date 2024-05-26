package com.example.SubjectApi2.factory;

import com.example.SubjectApi2.subject.SubjectDto;
import com.example.SubjectApi2.subject.SubjectEntity;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 11:43
 */
public class SubjectFactory {

    public SubjectFactory(){}

    public static SubjectDto fromEntity(SubjectEntity entity){
        SubjectDto dto = new SubjectDto();
        dto.setId(entity.getId());
        dto.setIco(entity.getIco());
        dto.setObchodniJmeno(entity.getObchodniJmeno());
        dto.setAcronym(entity.getAcronym());
        dto.setDescription(entity.getDescription());
        dto.setDeleted(entity.isDeleted());
        return dto;
        }

        public static void fillEntity(SubjectEntity entity,SubjectDto dto){
        entity.setId(dto.getId());
        entity.setIco(dto.getIco());
        entity.setAcronym(dto.getAcronym());
        entity.setObchodniJmeno(dto.getObchodniJmeno());
        entity.setDescription(dto.getDescription());
        entity.setDeleted(dto.isDeleted());

        }

}
