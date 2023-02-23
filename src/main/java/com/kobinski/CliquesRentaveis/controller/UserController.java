package com.kobinski.CliquesRentaveis.controller;

import com.kobinski.CliquesRentaveis.models.User;
import com.kobinski.CliquesRentaveis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<Object> getUserByCpf(@RequestBody User user) {
        boolean authenticated = userService.getUserByCpf(user.getCpf(), user.getSenha());

        if(authenticated)  {
            return ResponseEntity.ok("ok");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

}

