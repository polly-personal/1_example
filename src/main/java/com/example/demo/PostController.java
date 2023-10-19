package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class PostController {
    private  final PostService postService;

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id) {
        Post post = postService.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return post;

    }

}
