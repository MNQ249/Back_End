package com.Lebook.MesferAlQahtani.Services;

import com.Lebook.MesferAlQahtani.Entity.TicketEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TicketsService {

     List<TicketEntity> getAllTicket();

     TicketEntity findById(long ticketID);

     ResponseEntity<Void> addTicket(long eventId, long id);

     void updateTicket(TicketEntity ticketEntity, long ticketID);

     Long CountEventTicket(long eventId);

     void CheckinTicket(long ticketID);

     void cancelTicket(long ticketID);

     List<TicketEntity> getMyTickets(long id);

     List<TicketEntity> getAttendedTickets(long id);

     List<TicketEntity> getEventsTickets(long eventId);
}

