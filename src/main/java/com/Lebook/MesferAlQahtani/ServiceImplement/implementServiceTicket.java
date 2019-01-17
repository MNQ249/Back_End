package com.Lebook.MesferAlQahtani.ServiceImplement;

import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import com.Lebook.MesferAlQahtani.Entity.TicketEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import com.Lebook.MesferAlQahtani.Repoistory.EventRepository;
import com.Lebook.MesferAlQahtani.Repoistory.TicketsRepository;
import com.Lebook.MesferAlQahtani.Repoistory.UserRepository;
import com.Lebook.MesferAlQahtani.Services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class implementServiceTicket implements TicketsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketsRepository ticketsRepository;
//
//    @Autowired
//    private EmailServiceImplement emailServiceImplement;

    @Override
    public List<TicketEntity> getAllTicket() {
        return ticketsRepository.findAll();
    }

    @Override
    public TicketEntity findById(long ticketID) {
        return ticketsRepository.findById(ticketID).get();
    }

    @Override
    public ResponseEntity<Void> addTicket(long eventId, long id) {
        TicketEntity ticketEntity= new TicketEntity();
        Optional<EventEntity> eventEntityOptional =
                eventRepository.findByEventIdAndDeletedFalseAndApprovedTrueAndEventDateAfter(eventId, LocalDate.now());
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (eventEntityOptional.isPresent() && userEntityOptional.isPresent()) {
            EventEntity eventEntity = eventRepository.findByEventIdAndDeletedFalseAndApprovedTrueAndEventDateAfter(eventId,LocalDate.now()).get();
            UserEntity userEntity = userRepository.findById(id).get();
            LocalDate eventDate = eventEntity.getEventDate();
            long counter = ticketsRepository.countByEventEntityAndCancelTicketFalse(eventEntity);
            long overlap = ticketsRepository.countByUserEntityAndTDate(userEntity, eventDate);
            if(eventEntity.getEventMaxCapacity()> counter && overlap == 0){
                ticketEntity.setEventEntity(eventEntity);
                ticketEntity.setUserEntity(userEntity);
                ticketEntity.setEventName(eventEntity.getEventName());
                ticketEntity.settDate(eventEntity.getEventDate());
                ticketsRepository.save(ticketEntity);
//                emailServiceImplement.sendSimpleMessage(ticketEntity.getUsernumber().getEmail(),"hello","thank you" );
                return  ResponseEntity.ok().build(); //** this return only message **
            }
            return new ResponseEntity("The event is full OR you book two ticket in the same day.....", HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity("user number OR event id is not found.....", HttpStatus.NOT_FOUND);

    }


    @Override
    public void updateTicket(TicketEntity ticketEntity, long ticketID) {
        ticketsRepository.save(ticketEntity);
    }

    @Override
    public Long CountEventTicket(long eventId) {
        return ticketsRepository.countByEventEntityAndCancelTicketFalse(eventRepository.findById(eventId).get());
    }

    @Override
    public void CheckinTicket(long ticketID) {
    TicketEntity ticketEntity = ticketsRepository.findById(ticketID).get();
    ticketEntity.setAttended(true);
    ticketsRepository.save(ticketEntity);
    }

    @Override
    public void cancelTicket(long ticketID) {
        TicketEntity ticketEntity = ticketsRepository.findById(ticketID).get();
        ticketEntity.setCancelTicket(true);
        ticketsRepository.save(ticketEntity);
//        emailServiceImplement.sendSimpleMessage(ticketEntity.getUsernumber().getEmail(),"hello","ticket canceled" );


    }

    @Override
    public List<TicketEntity> getMyTickets(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        List<TicketEntity> ticketEntitis = ticketsRepository.findByUserEntityAndCancelTicketIsFalse(userEntity);
        return ticketEntitis;
    }

    @Override
    public List<TicketEntity> getAttendedTickets(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        List<TicketEntity> ticketEntities = ticketsRepository.findByUserEntityAndAttendedIsTrue(userEntity);
        return ticketEntities;
    }

    @Override
    public List<TicketEntity> getEventsTickets(long eventId) {
        EventEntity eventEntity = eventRepository.findById(eventId).get() ;
        List<TicketEntity> ticketEntities = ticketsRepository.findByEventEntityAndCancelTicketFalse(eventEntity);
        return ticketEntities;
    }
}
