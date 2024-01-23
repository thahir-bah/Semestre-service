package com.umi.semestreservice.dto;

import com.umi.semestreservice.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemestreDto {
    private Long id;
    private String name;
    private Session session;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
