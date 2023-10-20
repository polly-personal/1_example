package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostDto {
    private Long id;

    private String title;

    private String text;

    private User author;

    public PostDto(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public static PostDto of(Long id, String title, String text) {
        return new PostDto(id, title, text);
    }

    public static PostDto of(Long id, String title, String text, UserDto userDto) {
        return new PostDto(id, title, text, new User(userDto.getId(), userDto.getName(), userDto.getEmail()));
    }

}
