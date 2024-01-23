package com.umi.semestreservice.service.impl;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.entity.AnneeUniversitaire;
import com.umi.semestreservice.entity.Semestre;
import com.umi.semestreservice.entity.Session;
import com.umi.semestreservice.exception.ResourceNotFoundException;
import com.umi.semestreservice.mapper.AnneeUniversitaireMapper;
import com.umi.semestreservice.repository.AnneeUniversitaireRepository;
import com.umi.semestreservice.repository.SemestreRepository;
import com.umi.semestreservice.repository.SessionRepository;
import com.umi.semestreservice.service.AnneeUniversitaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class AnneeUniversitaireServiceImpl  implements AnneeUniversitaireService {
    private AnneeUniversitaireRepository anneeUniversitaireRepository;
    private SessionRepository sessionRepository;
    private SemestreRepository semestreRepository;

    @Override
    public AnneeUniversitaireDto createAnneeUniversitaire(AnneeUniversitaireDto anneeUniversitaireDto) {
        AnneeUniversitaire anneeUniversitaire = AnneeUniversitaireMapper.mapToAnneeUniversitaire(anneeUniversitaireDto);
        AnneeUniversitaire savedAnneeUniversitaire = anneeUniversitaireRepository.save(anneeUniversitaire);
        createSessionsForAnneeUniversitaire(savedAnneeUniversitaire);

        return AnneeUniversitaireMapper.mapToAnneeUniversitaireDto(savedAnneeUniversitaire);
    }

    private void createSessionsForAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
        List<String> sessionTypes = Arrays.asList("Automne Normal", "Automne Rattrapage", "Printemps Normal", "Printemps Rattrapage");

        for (String sessionType : sessionTypes) {
            Session session = new Session();
            session.setType(sessionType);
            session.setNom(sessionType + " " + anneeUniversitaire.getStartYear().getValue());
            session.setAcademicYear(anneeUniversitaire);

            // Enregistrez la session
            session = sessionRepository.save(session);

            // Création automatique des semestres pour chaque session
            createSemestresForSession(session);
        }
    }

    private void createSemestresForSession(Session session) {
        List<String> semestreNames = Arrays.asList("s1", "s2", "s3", "s4", "s5", "s6");

        // Choisissez les semestres en fonction du type de session
        List<String> selectedSemestres;
        if (session.getType().equals("Automne Normal") || session.getType().equals("Printemps Normal")) {
            // Sessions normales (Automne Normal, Printemps Normal)
            selectedSemestres = Arrays.asList("s1", "s3", "s5");
        } else {
            // Sessions de rattrapage (Automne Rattrapage, Printemps Rattrapage)
            selectedSemestres = Arrays.asList("s2", "s4", "s6");
        }

        for (String semestreName : selectedSemestres) {
            Semestre semestre = new Semestre();
            semestre.setName(semestreName);
            semestre.setSession(session);

            // Enregistrez le semestre
            semestreRepository.save(semestre);
        }
    }

    @Override
    public AnneeUniversitaireDto getAnneeUniversitaireById(Long id) {
        AnneeUniversitaire anneeUniversitaire = anneeUniversitaireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University Year is not exists with given id : " + id));
        return AnneeUniversitaireMapper.mapToAnneeUniversitaireDto(anneeUniversitaire);
    }

    @Override
    public List<AnneeUniversitaireDto> getAllAnneeUniversitaire() {
        return null;
    }

    @Override
    public AnneeUniversitaireDto updateAnneeUniversitaire(Long id, AnneeUniversitaireDto updatedAnneeUniversitaireDto) {
        return null;
    }

    @Override
    public void deleteAnneeUniversitaire(Long id) {

    }
}
