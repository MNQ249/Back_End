package com.Lebook.MesferAlQahtani.Repoistory;

import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import com.Lebook.MesferAlQahtani.Entity.TicketEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TicketsRepository extends JpaRepository<TicketEntity, Long> {


        List<TicketEntity> findByEventEntityAndCancelTicketFalse(EventEntity eventEntity);

        Long countByEventEntityAndCancelTicketFalse(EventEntity eventEntity);

        Long countByUserEntityAndEventEntity(UserEntity userEntity, EventEntity eventEntity);

        Long countByUserEntityAndTDate(UserEntity userEntity, LocalDate date);

        List<TicketEntity> findByUserEntityAndCancelTicketIsFalse(UserEntity userEntity);

        List<TicketEntity>findByUserEntityAndAttendedIsTrue(UserEntity userEntity);

        List<TicketEntity>findByEventEntityAndCancelTicketIsFalse(EventEntity eventEntity);

}