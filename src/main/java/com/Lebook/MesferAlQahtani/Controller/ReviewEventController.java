package com.Lebook.MesferAlQahtani.Controller;


import com.Lebook.MesferAlQahtani.Entity.ReviewEventEntity;
import com.Lebook.MesferAlQahtani.Services.ReviewEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rating")
public class ReviewEventController {


    @Autowired
    private ReviewEventService reviewEventService;

    @GetMapping("/AdminAccess/view")
    public List<ReviewEventEntity>getAllReviewEvent(){
        return reviewEventService.getAllReviewEvent();
    }

    @GetMapping("/view/{reviewEventid}")
    public Optional<ReviewEventEntity> findById(@PathVariable long reviewEventid){

        return reviewEventService.findById(reviewEventid);
    }

    @PostMapping("/add/{ticketID}")
    public void addReviewEventid(@RequestBody ReviewEventEntity reviewEventEntity,@PathVariable long ticketID){

        reviewEventService.addReviewEventid(reviewEventEntity,ticketID);
    }
    @PutMapping("/edit/{reviewEventid}")
    public void updateReviewEventid(@RequestBody ReviewEventEntity reviewEventEntity,@PathVariable long reviewEventid){
        reviewEventService.updateReviewEventid(reviewEventEntity,reviewEventid);
    }
}
