package com.Lebook.MesferAlQahtani.Services;



import com.Lebook.MesferAlQahtani.Entity.ReviewEventEntity;

import java.util.List;
import java.util.Optional;

public interface ReviewEventService {


//     ReviewEventEntity addReviewEvent(ReviewEventEntity reviewEventEntity);
//     void deleteReviewEvent(long reviewEventid);
//     void updateReviewEvent (ReviewEventEntity reviewEventEntity, long reviewEventid );
//     ReviewEventEntity getReviewEvent(long reviewEventid);
//     List<ReviewEventEntity> getAll();
//     ResponseEntity RatingEvent(long ticketID, int rating, String comments);


    List<ReviewEventEntity>getAllReviewEvent();

    Optional<ReviewEventEntity> findById(long reviewEventid);

    void addReviewEventid(ReviewEventEntity reviewEventEntity, long ticketID);

    void updateReviewEventid(ReviewEventEntity reviewEventEntity, long reviewEventid);

}
