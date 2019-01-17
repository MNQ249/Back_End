package com.Lebook.MesferAlQahtani.Repoistory;

import com.Lebook.MesferAlQahtani.Entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolesRepository extends CrudRepository <RolesEntity, String>{

    RolesEntity findByRolename(String role);


}
