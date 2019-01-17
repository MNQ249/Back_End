package com.Lebook.MesferAlQahtani.Controller;

import com.Lebook.MesferAlQahtani.Entity.RolesEntity;
import com.Lebook.MesferAlQahtani.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping("/AdminAccess/view")
    public List<RolesEntity>getAllRoles(){return rolesService.getAllRoles();}


    @GetMapping("/view/{roleID}")
    public Optional<RolesEntity> findById(String rolename){

        return rolesService.findById(rolename);
    }

    @PostMapping("/add")
    public void addRoles(@RequestBody RolesEntity rolesEntity){
         rolesService.addRoles(rolesEntity);
    }

    @PutMapping("/edit/{roleID}")
    public void updateRoles(@RequestBody RolesEntity rolesEntity, @PathVariable String rolename){

        rolesService.updateRoles(rolesEntity, rolename);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/roles/{roleID}")
    public void deleteById(String rolename){ rolesService.deleteById(rolename);}

}
