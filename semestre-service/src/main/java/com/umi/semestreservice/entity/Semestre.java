package com.umi.semestreservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semestre {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "session"
    )
    private Session session;
    @Column(
            name = "Date_Creation",
            columnDefinition = "TIMESTAMP",
            nullable = true,
            updatable = false
    )
    private LocalDateTime createdAt;
    @CreationTimestamp
    @Column(
            name = "Date_Modification",
            columnDefinition = "TIMESTAMP",
            nullable = true
    )
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
