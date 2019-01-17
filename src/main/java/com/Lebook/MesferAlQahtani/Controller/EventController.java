package com.Lebook.MesferAlQahtani.Controller;


import com.Lebook.MesferAlQahtani.DTO.EntityDTO.EventDTO;
import com.Lebook.MesferAlQahtani.Entity.EventEntity;

import com.Lebook.MesferAlQahtani.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
@Valid
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/list")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<EventEntity> getAllEvent() {
        return eventService.getAllEvent();
    }

    @GetMapping("/myEvent/{id}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public List<EventEntity> getMyEvent(@PathVariable long id) {
        return eventService.getMyEvent(id);
    }


    @GetMapping("/{eventId}")
    public ResponseEntity<EventEntity> findById(@PathVariable long eventId) {
        return eventService.findById(eventId);
    }


    @PostMapping("/add/{orginzerid}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public void addEvent(@RequestBody @Valid EventDTO eventDTO,@PathVariable long orginzerid){
        eventService.addEvent(eventDTO,orginzerid);
    }


    @PutMapping("/edit/{eventId}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public void updateEvent(@RequestBody EventDTO eventDTO, @PathVariable long eventId)
    { eventService.updateEvent(eventDTO, eventId);}


    @PutMapping("/delete/{eventId}")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public void isDeleted(@PathVariable long eventId){ eventService.isDeleted(eventId);}


    @GetMapping("/approve/{eventId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void ApproveEvent(@PathVariable long eventId){ eventService.ApproveEvent(eventId);}

    @GetMapping("/disApprove/{eventId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void DisApproved(@PathVariable long eventId){eventService.DisApproveEvent(eventId);}

    @GetMapping("/listApprove")
    public List<EventEntity> Eapprove(){return eventService.ApproveEvent();}

    @GetMapping("/listNotApprove")
    public List<EventEntity> ENapprove(){return eventService.NotApproveEvent();}

    @GetMapping("/SearchByCity/{eventCity}")
    public List<EventEntity> SearchByCity (@PathVariable String eventCity){return eventService.SearchByCity(eventCity);
    }

    @GetMapping("/SearchByDate/{eventDate}")
    public List<EventEntity> SearchByDate(@PathVariable String eventDate){
        return eventService.SearchByDate(LocalDate.parse(eventDate));
    }

}