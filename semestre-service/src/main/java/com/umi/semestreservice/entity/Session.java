package com.umi.semestreservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "type",
            nullable = false
    )
    private String type;
    @Column(
            name = "nom",
            nullable = false
    )
    private String nom;
    @OneToMany(
            mappedBy = "session",
            cascade = {CascadeType.ALL}
    )
    private List<Semestre> semestres;
    @ManyToOne
    @JoinColumn(
            name = "academicYear"
    )
    private AnneeUniversitaire academicYear;
}
