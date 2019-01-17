package com.Lebook.MesferAlQahtani.Controller;

import com.Lebook.MesferAlQahtani.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/userData")
    public ResponseEntity login(Principal principal){
        Map<String, String> map = new HashMap<>();
        map.put("userID", String.valueOf(userService.findByUserName(principal.getName()).getId()));
        map.put("rolename", userService.findByUserName(principal.getName()).getUserroles().getRolename());
        return ResponseEntity.ok(map);
    }

}
