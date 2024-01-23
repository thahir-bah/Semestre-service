package com.umi.semestreservice.mapper;

import com.umi.semestreservice.dto.SemestreDto;
import com.umi.semestreservice.entity.Semestre;

public class SemestreMapper {
    public static SemestreDto mapToSemestreDto(Semestre semestre) {
        return new SemestreDto(semestre.getId(), semestre.getName(), semestre.getSession(), semestre.getCreatedAt(), semestre.getUpdatedAt());
    }

    public static Semestre mapToSemestre(SemestreDto semestreDto) {
        return new Semestre(semestreDto.getId(), semestreDto.getName(), semestreDto.getSession(), semestreDto.getCreatedAt(), semestreDto.getUpdatedAt());
    }
}
