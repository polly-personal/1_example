package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@ToString
//@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Table(name = "posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

//    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    public Post() {
    }
    //    public Post(Long id, String title, String text, User author) {
//        this.id = id;
//        this.title = title;
//        this.text = text;
//        this.author = author;
//    }

//    public Post(Long id, String title, String text) {
//        this.id = id;
//        this.title = title;
//        this.text = text;
//    }
}
