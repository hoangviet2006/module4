package com.example.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name" , nullable = false)
    private String nameAuthor;
    @Column(name = "birth_day" , nullable = false)
    private Date birthDate;
    @OneToMany(mappedBy = "idAuthor")
    private List<Blog> idBlog;
}
