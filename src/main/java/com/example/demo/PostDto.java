package com.example.demo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostDto {
    private Long id;

    private String title;

    private String text;

    private User author;
}
