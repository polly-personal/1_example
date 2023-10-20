package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostShortDto {
    private Long id;
    private String title;
    private String authorName;

    public static PostShortDto of(Long id, String title, String authorName) {
        return new PostShortDto(id, title, authorName);
    }
}
