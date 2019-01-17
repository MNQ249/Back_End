package com.Lebook.MesferAlQahtani.Services;

import com.Lebook.MesferAlQahtani.Entity.CommentsEntity;
import org.springframework.http.ResponseEntity;

public interface CommentsService {


    ResponseEntity<ResponseEntity>  addComments(long id, long eventId,String comment);





}
