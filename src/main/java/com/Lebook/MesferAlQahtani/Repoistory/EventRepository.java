package com.Lebook.MesferAlQahtani.Repoistory;



import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {


    //for or list to defined event place
    List<EventEntity> findAllByEventCityLike(String eventCity);

    //for or list to defined event date
    List<EventEntity>findByEventDate(LocalDate eventDate);

    //for or list to defined is not deleted and the event is approved
    List<EventEntity> findByDeletedFalseAndApprovedTrueAndEventDateAfter(LocalDate eventDate);

    List<EventEntity> findByDeletedFalseAndApprovedFalseAndEventDateAfter(LocalDate eventDate);

    Optional<EventEntity> findByEventIdAndDeletedFalseAndApprovedTrue(long eventId);

    Optional<EventEntity>findByEventIdAndDeletedFalseAndApprovedTrueAndEventDateAfter(long eventId, LocalDate eventDate );

    Long countByApprovedTrue();

    List<EventEntity> findByOrginzerAndDeletedIsFalse(UserEntity userEntity);
}
