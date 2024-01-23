package com.umi.semestreservice.repository;

import com.umi.semestreservice.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
