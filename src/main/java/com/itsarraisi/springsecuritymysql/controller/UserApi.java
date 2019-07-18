package com.itsarraisi.springsecuritymysql.controller;

import com.itsarraisi.springsecuritymysql.entity.User;
import com.itsarraisi.springsecuritymysql.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    UserService service;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody User param){
        User user = service.save(param);
      return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
        Optional<User> user = service.findById(id);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
