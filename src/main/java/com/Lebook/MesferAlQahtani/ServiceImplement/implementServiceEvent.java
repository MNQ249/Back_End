package com.Lebook.MesferAlQahtani.ServiceImplement;


import com.Lebook.MesferAlQahtani.DTO.EntityDTO.EventDTO;
import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import com.Lebook.MesferAlQahtani.Entity.TicketEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import com.Lebook.MesferAlQahtani.ObjectMapperUtils;
import com.Lebook.MesferAlQahtani.Repoistory.EventRepository;
import com.Lebook.MesferAlQahtani.Repoistory.TicketsRepository;
import com.Lebook.MesferAlQahtani.Repoistory.UserRepository;
import com.Lebook.MesferAlQahtani.Services.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class implementServiceEvent implements EventService {


    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private EmailServiceImplement emailServiceImplement;

    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity addEvent(EventDTO eventDTO, long orginzerid){
        if (userRepository.findById(orginzerid).isPresent()) {
            LocalDate localDate = LocalDate.now().minusDays(1);
            EventEntity eventEntity=modelMapper.map(eventDTO, EventEntity.class);
            if (eventEntity.getEventDate().isAfter(localDate)){
                eventEntity.setOrginzer(userRepository.findById(orginzerid).get());
                return ResponseEntity.ok(eventRepository.save(eventEntity));
            }
            return new ResponseEntity("you must enter valid event date",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Orginzer id not found",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateEvent(EventDTO eventDTO, long eventId) {
        if (eventRepository.findById(eventId).isPresent()) {
            EventEntity tempEntity = eventRepository.findById(eventId).get();
            EventEntity eventEntity = modelMapper.map(eventDTO, EventEntity.class);
            eventEntity.setOrginzer(tempEntity.getOrginzer());
            eventEntity.setEventId(eventId);
            eventRepository.save(eventEntity);
            return ResponseEntity.ok().build();
        }
        return null;
    }


    @Override
    public void isDeleted(long eventId) {
    EventEntity eventEntity = eventRepository.findById(eventId).get();
    eventEntity.setDeleted(true);
    eventRepository.save(eventEntity);
    }

    @Override
    public void ApproveEvent(long eventId) {
    EventEntity eventEntity = eventRepository.findById(eventId).get();
    eventEntity.setApproved(true);
    eventRepository.save(eventEntity);
    }

    @Override
    public void DisApproveEvent(long eventId) {
        EventEntity eventEntity = eventRepository.findById(eventId).get();
        eventEntity.setApproved(false);
        eventRepository.save(eventEntity);
    }

    @Override
    public List<EventEntity> ApproveEvent() {
        LocalDate localDate = LocalDate.now().minusDays(1);
        List<EventEntity> eventEntity = eventRepository.findByDeletedFalseAndApprovedTrueAndEventDateAfter(localDate);
    return eventEntity;
    }

    @Override
    public List<EventEntity> NotApproveEvent() {
        LocalDate localDate = LocalDate.now().minusDays(1);
        List<EventEntity> eventEntities = eventRepository.findByDeletedFalseAndApprovedFalseAndEventDateAfter(localDate);
        return eventEntities;
    }

    @Override
    public ResponseEntity<EventEntity> findById(long eventId) {
        if(eventRepository.findById(eventId).isPresent()){
            return ResponseEntity.ok(eventRepository.findById(eventId).get());
        }
        return new ResponseEntity(" the event id is not found in database ", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<EventEntity> getAllEvent() {
       return eventRepository.findAll();
    }

    @Override
    public List<EventEntity> getMyEvent(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        List<EventEntity> eventEntitis = eventRepository.findByOrginzerAndDeletedIsFalse(userEntity);
        return eventEntitis;
    }

    @Override
    public List<EventEntity> SearchByCity(String eventCity) {
        return eventRepository.findAllByEventCityLike(eventCity);
    }

    @Override
    public List<EventEntity> SearchByDate(LocalDate eventDate) {
        return eventRepository.findByEventDate(eventDate);
    }

}
