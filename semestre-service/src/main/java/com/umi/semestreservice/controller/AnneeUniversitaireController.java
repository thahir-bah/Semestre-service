package com.umi.semestreservice.controller;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.service.AnneeUniversitaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/annees-universitaires")
@AllArgsConstructor
public class AnneeUniversitaireController {
    private AnneeUniversitaireService anneeUniversitaireService;

    @PostMapping
    public ResponseEntity<AnneeUniversitaireDto> createAnneeUniversitaire(@RequestBody AnneeUniversitaireDto anneeUniversitaireDto) {
        AnneeUniversitaireDto savedAnnee = anneeUniversitaireService.createAnneeUniversitaire(anneeUniversitaireDto);
        return new ResponseEntity<>(savedAnnee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnneeUniversitaireDto> getAnneeUniversitaireById(@PathVariable("id") Long id){
        AnneeUniversitaireDto anneeUniversitaireDto = anneeUniversitaireService.getAnneeUniversitaireById(id);
        return ResponseEntity.ok(anneeUniversitaireDto);
    }

}
