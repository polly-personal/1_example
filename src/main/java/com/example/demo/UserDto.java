package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    public static UserDto of(Long id, String name, String email) {
        return new UserDto(id, name, email);
    }
}
