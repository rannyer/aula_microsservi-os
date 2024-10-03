package com.aula.micreoservice01.MicroService01.controllers;

import com.aula.micreoservice01.MicroService01.dtos.UserRedordDTO;
import com.aula.micreoservice01.MicroService01.models.UserModel;
import com.aula.micreoservice01.MicroService01.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> addUser(@RequestBody @Valid UserRedordDTO userRedordDTO){
        var userModel =  new UserModel();
        BeanUtils.copyProperties(userRedordDTO, userModel);
        System.out.println(userModel.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
