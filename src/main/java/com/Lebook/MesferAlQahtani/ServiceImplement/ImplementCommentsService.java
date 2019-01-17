package com.Lebook.MesferAlQahtani.ServiceImplement;

import com.Lebook.MesferAlQahtani.Entity.CommentsEntity;
import com.Lebook.MesferAlQahtani.Entity.EventEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import com.Lebook.MesferAlQahtani.Repoistory.CommentsRepository;
import com.Lebook.MesferAlQahtani.Repoistory.EventRepository;
import com.Lebook.MesferAlQahtani.Repoistory.UserRepository;
import com.Lebook.MesferAlQahtani.Services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ImplementCommentsService implements CommentsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CommentsRepository commentsRepository;


    @Override
    public ResponseEntity<ResponseEntity> addComments(long id, long eventId,String comment) {
        if (userRepository.findById(id).isPresent()&&eventRepository.findById(eventId).isPresent()){
            EventEntity eventEntity=eventRepository.findById(eventId).get();
            UserEntity userEntity=userRepository.findById(id).get();
            CommentsEntity commentsEntity = new CommentsEntity();
            LocalDateTime dateTime = LocalDateTime.now().minusSeconds(10);
            long counter = commentsRepository.countByEventEntityAndUserEntityAndCommentstimeAfter(userEntity,eventEntity,dateTime);
            if (counter==0){
                commentsEntity.setComments(comment);
                commentsEntity.setUserEntity(userEntity);
                commentsEntity.setEventEntity(eventEntity);
                commentsEntity.setCommentstime(LocalDateTime.now());
                commentsRepository.save(commentsEntity);
                return new ResponseEntity("comment added",HttpStatus.OK);
            }
            return new ResponseEntity("you cannot add comment during 10 seconds",HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity("user number or event id not found",HttpStatus.NOT_FOUND);
    }
}
