package com.teste.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.projeto.model.UserModel;
import com.teste.projeto.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

@PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserModel user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
    }
@DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody @Valid UserModel user) {
        userService.deleteUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!");
    }
@PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserModel user) {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully!");
    }
@GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        UserModel user = userService.getUserById(id);
     
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

}
