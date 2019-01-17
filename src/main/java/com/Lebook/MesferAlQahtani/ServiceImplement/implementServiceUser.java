package com.Lebook.MesferAlQahtani.ServiceImplement;

import com.Lebook.MesferAlQahtani.DTO.EntityDTO.UserDTO;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import com.Lebook.MesferAlQahtani.Repoistory.RolesRepository;
import com.Lebook.MesferAlQahtani.Repoistory.UserRepository;
import com.Lebook.MesferAlQahtani.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;


@Service
public class implementServiceUser implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<UserEntity> getAllUser() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public List<UserEntity> getAllEnableUser() {
        return userRepository.findByEnableIsTrue();
    }

    @Override
    public List<UserEntity> getAllNotEnableUser() {
        return userRepository.findAllByEnableIsFalse();
    }


    @Override
    public List<UserEntity> isUserpresent() {
        return userRepository.findByEnableIsTrue();
    }

    @Override
    public  UserEntity findById(long id){
        UserEntity userEntity = new UserEntity();
        if(userRepository.findById(id).isPresent()){

            return userRepository.findById(id).get();
        }
        return null;

    }

    @Override
    public UserEntity addUser(UserDTO userDTO) {
        userDTO.setUserroles(rolesRepository.findByRolename(userDTO.getRole()));
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        //return ResponseEntity.ok(userRepository.save(userEntity));**this return the object of the update user **
        String encoded=new BCryptPasswordEncoder().encode(userEntity.getPassword());
        userEntity.setPassword(encoded);
        return userRepository.save(userEntity);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(long id, UserDTO userDTO) {
        if(userRepository.findById(id).isPresent()) {
            UserEntity tempEntity = userRepository.findById(id).get();
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            userEntity.setUserroles(tempEntity.getUserroles());
            userEntity.setId(id);
            String encoded = new BCryptPasswordEncoder().encode(userEntity.getPassword());
            userEntity.setPassword(encoded);
            userEntity.setEnable(true);
            userRepository.save(userEntity);
//           return ResponseEntity.ok(userRepository.save(userEntity));**this return the object of the update user **

           return  ResponseEntity.ok().build();//** this return only message **

        }
        //message to show you Respond errors
        return new ResponseEntity("user number is not found.....", HttpStatus.NOT_FOUND);
    }

    @Override
    public void enable(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
       userEntity.setEnable(true);
         userRepository.save(userEntity);
    }

    @Override
    public void disable(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setEnable(false);
        userRepository.save(userEntity);
    }

    @Override
    public void delete(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setEnable(false);
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }



//    @Override
//    public void deleteById(long id) {
//    UserEntity userEntity = userRepository.findById(id).get();
//    userEntity.setDeleted(true);
//    userRepository.save(userEntity);
//    }


}
