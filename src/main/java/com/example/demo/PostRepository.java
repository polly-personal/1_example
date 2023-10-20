package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p " +
            "from Post p " +
            "JOIN FETCH p.author")
    List<Post> findAllWithAuthors();
}
