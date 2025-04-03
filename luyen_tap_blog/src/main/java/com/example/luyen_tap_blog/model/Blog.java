package com.example.luyen_tap_blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code" ,unique = true, nullable = false)
    private String code;
    @Column(name = "name" , nullable = false)
    private String nameBlog;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "deleted")
    private Boolean deleted=false;
    @ManyToOne()
    @JoinColumn(name = "id_author", nullable = false)
    private Author idAuthor;
}
