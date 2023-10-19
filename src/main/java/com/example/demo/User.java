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
@Table(name = "authors")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public User() {
    }

    //    public User(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
}
