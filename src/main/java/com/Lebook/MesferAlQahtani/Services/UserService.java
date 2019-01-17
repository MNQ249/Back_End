package com.Lebook.MesferAlQahtani.Services;

import com.Lebook.MesferAlQahtani.DTO.EntityDTO.UserDTO;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;


public interface UserService {


    //method that call all users.
     List<UserEntity> getAllUser();

    List<UserEntity> getAllEnableUser();

    List<UserEntity> getAllNotEnableUser();

    List<UserEntity>isUserpresent();

      UserEntity findById(long id );

   //method that add object from userEntity entity
//     void addUser(UserEntity userEntity, long roleID);
    UserEntity addUser(UserDTO userDTO);

//    //method that call user by his/her id
//     Optional<UserEntity> getUser(long id);



    //method that call reference by id.
//     void updateUser(UserEntity userEntity, long id);
    ResponseEntity<UserEntity> updateUser(long id, UserDTO userDTO);

    //method that call object form user entity by id.
//     void deleteById (long id);

    void enable(long id);
    void disable(long id);
    void delete(long id);


    UserEntity findByUserName(String userName);












}
