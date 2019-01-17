package com.Lebook.MesferAlQahtani.Controller;

import com.Lebook.MesferAlQahtani.Entity.TicketEntity;
import com.Lebook.MesferAlQahtani.Services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @GetMapping("/listTickets")
    public List<TicketEntity>getAllTicket(){return ticketsService.getAllTicket();}


    @GetMapping("/myTickets/{id}")
    public List<TicketEntity> getMyTickets(@PathVariable long id){return ticketsService.getMyTickets(id);}

    @GetMapping("/attendedTickets/{id}")
    public List<TicketEntity> getAttendedTickets(@PathVariable long id){return ticketsService.getAttendedTickets(id);}

    @GetMapping("/events/tickets/{eventId}")
    public List<TicketEntity> getEventsTickets(@PathVariable long eventId){return ticketsService.getEventsTickets(eventId);}


    @GetMapping("/{ticketID}")
    public TicketEntity findById(@PathVariable long ticketID){return  ticketsService.findById(ticketID);}

    @GetMapping("/add/{eventId}/{id}")
    public ResponseEntity addTicket(@PathVariable long eventId , @PathVariable long id){
        return ticketsService.addTicket( eventId,id );
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/tickets/{ticketID}")
    public void updateTicket(@RequestBody TicketEntity ticketEntity, @PathVariable long ticketID){ticketsService.updateTicket(ticketEntity,ticketID);}



    @GetMapping("/count/{eventId}")
    public Long CountEventTicket(@PathVariable long eventId ){ return ticketsService.CountEventTicket(eventId);}


    @GetMapping("CheckinTicket/{ticketID}")
    public void CheckinTicket(@PathVariable long ticketID){  ticketsService.CheckinTicket(ticketID);}


    @GetMapping("/cancelTicket/{ticketID}")
    public void cancelTicket(@PathVariable long ticketID){  ticketsService.cancelTicket(ticketID);}
}
