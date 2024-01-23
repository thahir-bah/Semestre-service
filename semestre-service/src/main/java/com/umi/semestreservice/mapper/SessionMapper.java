package com.umi.semestreservice.mapper;
import com.umi.semestreservice.dto.SessionDto;
import com.umi.semestreservice.entity.Session;
public class SessionMapper {
    public static SessionDto mapToSessionDto(Session session) {
        return new SessionDto(session.getId(), session.getType(), session.getNom(), session.getSemestres(), session.getAcademicYear());
    }

    public static Session mapToSession(SessionDto sessionDto) {
        return new Session(sessionDto.getId(), sessionDto.getType(), sessionDto.getNom(), sessionDto.getSemestres(), sessionDto.getAcademicYear());
    }
}
