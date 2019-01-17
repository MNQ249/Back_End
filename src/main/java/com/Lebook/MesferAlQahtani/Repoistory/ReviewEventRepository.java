package com.Lebook.MesferAlQahtani.Repoistory;

import com.Lebook.MesferAlQahtani.Entity.ReviewEventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReviewEventRepository extends CrudRepository <ReviewEventEntity, Long> {

}
