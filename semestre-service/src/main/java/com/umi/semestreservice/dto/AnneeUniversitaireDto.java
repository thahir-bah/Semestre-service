package com.umi.semestreservice.dto;

import com.umi.semestreservice.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnneeUniversitaireDto {
    private Long id;
    private Boolean courante;
    private Year startYear;
    private Year endYear;
    private List<Session> sessions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
