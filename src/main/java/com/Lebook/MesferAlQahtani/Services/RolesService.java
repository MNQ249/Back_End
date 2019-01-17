package com.Lebook.MesferAlQahtani.Services;

import com.Lebook.MesferAlQahtani.Entity.RolesEntity;

import java.util.List;
import java.util.Optional;

public interface RolesService {


    List<RolesEntity> getAllRoles();


    Optional<RolesEntity> findById(String rolename);

     void  addRoles(RolesEntity rolesEntity);

    void updateRoles (RolesEntity rolesEntity, String rolename);



    void deleteById(String rolename);









}
