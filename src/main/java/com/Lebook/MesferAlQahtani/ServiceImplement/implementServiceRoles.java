package com.Lebook.MesferAlQahtani.ServiceImplement;

import com.Lebook.MesferAlQahtani.Entity.RolesEntity;
import com.Lebook.MesferAlQahtani.Repoistory.RolesRepository;
import com.Lebook.MesferAlQahtani.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class implementServiceRoles implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<RolesEntity> getAllRoles() {
        return (List<RolesEntity>) rolesRepository.findAll();
    }

    @Override
    public Optional<RolesEntity> findById(String rolename) {
        return rolesRepository.findById(rolename);
    }

    @Override
    public void addRoles(RolesEntity rolesEntity) {
    rolesRepository.save(rolesEntity);
    }

    @Override
    public void updateRoles(RolesEntity rolesEntity, String rolename) {
    rolesRepository.save(rolesEntity);
    }

    @Override
    public void deleteById(String rolename) {
    rolesRepository.deleteById(rolename);
    }
}
