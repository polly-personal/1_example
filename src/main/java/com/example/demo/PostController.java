package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        ResponseEntity<PostDto> response = postService.findById(id)
                // конвертирем пост в DTO
                .map(post -> {
                    log.info("обращаемся к полю author, что должно повлечь выгрузку связанной сущности User");
                  // вариант как в теории (возвращается Post вместе со связанной сущн. User):
                    User author = post.getAuthor();
                    PostDto postDto = PostDto.of(
                            post.getId(), post.getTitle(), post.getText(),
                            UserDto.of(author.getId(), author.getName(), author.getEmail())
                    );

/*
                    // мой вариант без создания UserDto (возвращается Post БЕЗ связанной сущн. User):
                    PostDto postDto = PostDto.of(
                            post.getId(), post.getTitle(), post.getText() // , author == null
                    );
*/

                    return ResponseEntity.ok(postDto);
                })
                // если пост не был найден, то возвращаем ошибку
                .orElseGet(() -> ResponseEntity.notFound().build());

        return response;
    }

    /*
        @GetMapping("/{id}")
        public Post findById(@PathVariable Long id) {
            Post post = postService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Post not found"));
            return post;

        }
    */

/*
    @GetMapping("/digest")
    public Collection<PostShortDto> getPostInfo() {
*/
/* запрос родительской сущности (ПЕРВЫЙ ЗАПРОС) *//*


        List<Post> posts = postService.findAllPosts();

        List<PostShortDto> results = new ArrayList<>(posts.size());
        for (Post post : posts) {
            // на каждой итерации цикла при обращении к связ. сущности
            // будет выполняться еще один запрос (N запросов):
            String authorName = post.getAuthor().getName();

            results.add(
                    PostShortDto.of(post.getId(), post.getTitle(), authorName)

            );
        }

        return results;
    }
*/

    @GetMapping("/digest")
    public Collection<PostShortDto> getPostInfo() {
/* запрос родительской сущности и всех связанных авторов */

        List<Post> posts = postService.findAllWithAuthors();

        List<PostShortDto> results = new ArrayList<>(posts.size());
        for (Post post : posts) {
            // нет лишних запросов, используются данные выгруженные ВНЕ цикла (те в postService.findAllWithAuthors()):
            String authorName = post.getAuthor().getName();

            results.add(
                    PostShortDto.of(post.getId(), post.getTitle(), authorName)
            );
        }

        return results;
    }

}
