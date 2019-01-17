package com.Lebook.MesferAlQahtani.ServiceImplement;

import com.Lebook.MesferAlQahtani.Entity.ReviewEventEntity;
import com.Lebook.MesferAlQahtani.Entity.TicketEntity;
import com.Lebook.MesferAlQahtani.Repoistory.ReviewEventRepository;
import com.Lebook.MesferAlQahtani.Repoistory.TicketsRepository;
import com.Lebook.MesferAlQahtani.Services.ReviewEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class implementServiceReviewEvent implements ReviewEventService {

    @Autowired
    private ReviewEventRepository reviewEventRepository;

    @Autowired
    private TicketsRepository ticketsRepository;


    @Override
    public List<ReviewEventEntity> getAllReviewEvent() {
        return (List<ReviewEventEntity>) reviewEventRepository.findAll();
    }

    @Override
    public Optional<ReviewEventEntity> findById(long reviewEventid) {
        return reviewEventRepository.findById(reviewEventid);
    }

    @Override
    public void addReviewEventid(ReviewEventEntity reviewEventEntity, long ticketID) {
        TicketEntity ticketEntity = ticketsRepository.findById(ticketID).get();
        if (ticketsRepository.findById(ticketID).isPresent())
        {
            ticketEntity.setRated(true);
            ticketEntity.setRate(reviewEventEntity.getRate());
            ticketEntity.setComment(reviewEventEntity.getComments());
            reviewEventEntity.setReviewTicket(ticketEntity);
            reviewEventRepository.save(reviewEventEntity);
        }
    }

    @Override
    public void updateReviewEventid(ReviewEventEntity reviewEventEntity, long reviewEventid) {


        reviewEventRepository.save(reviewEventEntity);
    }
}
