package com.krystiancwioro.learn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {
    private String login;
    private String password;
    private String email;
    private int phone;
}
