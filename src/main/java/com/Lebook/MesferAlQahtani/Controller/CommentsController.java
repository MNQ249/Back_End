package com.Lebook.MesferAlQahtani.Controller;


import com.Lebook.MesferAlQahtani.Entity.CommentsEntity;
import com.Lebook.MesferAlQahtani.Services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {


    @Autowired
    private CommentsService commentsService;


    @PostMapping("/add/{id}/{eventId}/{comment}")
    public ResponseEntity addComments(@PathVariable long id, @PathVariable long eventId, @PathVariable String comment){
        return commentsService.addComments(id,eventId,comment);
    }



}
