package com.projekat.SR19.controller;

import com.projekat.SR19.model.entity.User;
import com.projekat.SR19.service.UserService;
import com.projekat.SR19.service.implementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/reddit/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> loadAll() {
        return this.userService.findAll();
    }


}
