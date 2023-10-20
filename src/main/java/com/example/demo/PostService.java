package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> findAllWithAuthors() {
        return postRepository.findAllWithAuthors();
    }
}
