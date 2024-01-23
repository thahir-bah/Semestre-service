package com.umi.semestreservice.mapper;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.entity.AnneeUniversitaire;

public class AnneeUniversitaireMapper {
    public static AnneeUniversitaireDto mapToAnneeUniversitaireDto(AnneeUniversitaire anneeUniversitaire) {
        return new AnneeUniversitaireDto(anneeUniversitaire.getId(), anneeUniversitaire.getCourante(), anneeUniversitaire.getStartYear(), anneeUniversitaire.getEndYear(), anneeUniversitaire.getSessions(), anneeUniversitaire.getCreatedAt(), anneeUniversitaire.getUpdatedAt());
    }

    public static AnneeUniversitaire mapToAnneeUniversitaire(AnneeUniversitaireDto anneeUniversitaireDto) {
        return new AnneeUniversitaire(anneeUniversitaireDto.getId(), anneeUniversitaireDto.getCourante(), anneeUniversitaireDto.getStartYear(), anneeUniversitaireDto.getEndYear(), anneeUniversitaireDto.getSessions(), anneeUniversitaireDto.getCreatedAt(), anneeUniversitaireDto.getUpdatedAt());
    }
}
