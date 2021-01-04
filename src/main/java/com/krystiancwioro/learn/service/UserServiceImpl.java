package com.krystiancwioro.learn.service;

import com.krystiancwioro.learn.component.CsvOperationsComponent;
import com.krystiancwioro.learn.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private ArrayList<UserDto> users;

    final CsvOperationsComponent csvOperationsComponent;

    public UserServiceImpl(CsvOperationsComponent csvOperationsComponent){
        this.csvOperationsComponent = csvOperationsComponent;
        users = new ArrayList<>();
        readCsv();
    }

    @Override
    public ArrayList<UserDto> showUsers() {
        return users;
    }

    @Override
    public boolean addUser(UserDto userDto) {
        users.add(userDto);
        return true;
    }

    @Override
    public void readCsv() {
        users = (ArrayList<UserDto>) csvOperationsComponent.readCsvFile().stream()
                .map(line -> UserDto.builder()
                .login(line.split(";")[0])
                                .password(line.split(";")[1])
                                .email(line.split(";")[2])
                                .phone(Integer.parseInt(line.split(";")[3]))
                        .build()
                ).collect(Collectors.toList());
    }


}
