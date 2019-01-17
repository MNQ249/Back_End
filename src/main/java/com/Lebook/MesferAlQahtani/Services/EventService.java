package com.Lebook.MesferAlQahtani.Services;

import com.Lebook.MesferAlQahtani.DTO.EntityDTO.EventDTO;
import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EventService {

    List<EventEntity> getAllEvent();

    List<EventEntity> getMyEvent(long id);

    ResponseEntity<EventEntity> findById(long eventId);

    ResponseEntity addEvent(EventDTO eventDTO, long orgid);

    ResponseEntity updateEvent (EventDTO eventDTO, long eventId);

     void isDeleted(long eventId);

     void ApproveEvent(long eventId);

     void DisApproveEvent(long eventId);

    List<EventEntity> ApproveEvent();
    List<EventEntity> NotApproveEvent();

     List<EventEntity> SearchByCity(String eventCity);

     List<EventEntity> SearchByDate(LocalDate eventDate);


}
