package com.Lebook.MesferAlQahtani.Repoistory;

import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

List<UserEntity> findByEnableIsTrue();


List<UserEntity> findAllByEnableIsFalse();


UserEntity findByUserName(String userName);





}
