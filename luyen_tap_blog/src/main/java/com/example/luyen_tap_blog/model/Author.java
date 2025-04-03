package com.example.luyen_tap_blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int id;
    @Column(name = "name" , nullable = false)
    private String nameAuthor;
    @Column(name = "birth_day" , nullable = false)
    private Date birthDate;
    @OneToMany(mappedBy = "idAuthor")
    @JsonIgnore
    private List<Blog> idBlog;
}
