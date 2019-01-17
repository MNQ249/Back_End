package com.Lebook.MesferAlQahtani.Repoistory;

import com.Lebook.MesferAlQahtani.Entity.CommentsEntity;
import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CommentsRepository extends CrudRepository<CommentsEntity, Long> {

//Long countByAttenderIdAndeventIdAndLocalDateTimeAfter(UserEntity attenderId, EventEntity eventEntityId, CommentsEntity localDateTime);
    Long countByEventEntityAndUserEntityAndCommentstimeAfter(UserEntity userEntity, EventEntity eventEntity, LocalDateTime localDateTime);
}
