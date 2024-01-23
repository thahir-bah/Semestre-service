package com.umi.semestreservice.dto;

import com.umi.semestreservice.entity.AnneeUniversitaire;
import com.umi.semestreservice.entity.Semestre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {
    private Long id;
    private String type;
    private String nom;
    private List<Semestre> semestres;
    private AnneeUniversitaire academicYear;

}
