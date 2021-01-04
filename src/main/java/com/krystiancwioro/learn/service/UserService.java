package com.krystiancwioro.learn.service;


import com.krystiancwioro.learn.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    ArrayList<UserDto> showUsers();
    boolean addUser(UserDto userDto);
    void readCsv();
}
