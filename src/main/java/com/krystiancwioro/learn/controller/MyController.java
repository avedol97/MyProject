package com.krystiancwioro.learn.controller;

import com.krystiancwioro.learn.dto.UserDto;
import com.krystiancwioro.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MyController {

    final UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "Hello World!";
    }

    @GetMapping("/test/{login}")
    public void setLogin(@PathVariable("login") String login) {
        System.out.println(login);
    }

    @GetMapping("/users")
    public ArrayList<UserDto> showUsers() {
        return userService.showUsers();
    }


    @PostMapping("/register")
    public void register(@RequestBody UserDto newUser) {
        UserDto userDto = UserDto.builder()
                .login(newUser.getLogin())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .phone(newUser.getPhone())
                .build();

        userService.addUser(newUser);
        System.out.println(userDto.toString());
    }

}
