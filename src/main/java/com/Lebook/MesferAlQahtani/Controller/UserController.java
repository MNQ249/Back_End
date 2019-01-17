package com.Lebook.MesferAlQahtani.Controller;

import com.Lebook.MesferAlQahtani.DTO.EntityDTO.UserDTO;
import com.Lebook.MesferAlQahtani.Entity.RolesEntity;
import com.Lebook.MesferAlQahtani.Entity.UserEntity;
import com.Lebook.MesferAlQahtani.Repoistory.RolesRepository;
import com.Lebook.MesferAlQahtani.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping("/userPresent/view")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserEntity> isUserpresent() {
        return userService.isUserpresent();
    }

    @GetMapping("/AllUser/view")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserEntity> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/AllUser/Enable")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserEntity> getAllEnableUser() {
        return userService.getAllEnableUser();
    }

    @GetMapping("/AllUser/NotEnable")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserEntity> getAllNotEnable() {
        return userService.getAllNotEnableUser();
    }


    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity findById(@PathVariable long id) {

                UserEntity userEntity = userService.findById(id);
                return ResponseEntity.ok(userEntity);
    }




    @PostMapping("/addAdmin")
    public ResponseEntity addAdmin(@RequestBody @Valid UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        RolesEntity rolesEntity = rolesRepository.findByRolename("ROLE_ADMIN");
        userDTO.setUserroles(rolesEntity);
        return ResponseEntity.ok(userService.addUser(userDTO));
    }


    @PostMapping("/addOrganizer")
    public ResponseEntity addOrganizer(@RequestBody @Valid UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        RolesEntity rolesEntity = rolesRepository.findByRolename("ROLE_ORGANIZER");
        return ResponseEntity.ok(userService.addUser(userDTO));
    }


    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody @Valid UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        RolesEntity rolesEntity = rolesRepository.findByRolename("ROLE_USER");
        return ResponseEntity.ok(userService.addUser(userDTO));
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity updateUser(@PathVariable long id, @RequestBody UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }




    // حذف يوزر
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(@PathVariable long id) {
        userService.delete(id);
    }


    // تفعيل حساب محذوف
    @GetMapping("/enable/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void enableUser(@PathVariable long id) {
        userService.disable(id);
    }

    @GetMapping("/disable/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void disableUser(@PathVariable long id) {
        userService.disable(id);
    }




                                        /*TEST SECURITY FUNCTIONS*/
    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userfunction() {
        return "ACCESSED !";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_AMIN')")
    public String adminfunction() {
        return "ACCESSED !";
    }
    @GetMapping("/org")
    @PreAuthorize("hasRole('ROLE_ORGANIZER')")
    public String orgfunction(){return "ACCESSED !";}
}