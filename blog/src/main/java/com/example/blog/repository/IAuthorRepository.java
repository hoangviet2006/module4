package com.example.blog.repository;

import com.example.blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Integer> {
    Author findAuthorsById(long id);

    Author findFirstByNameAuthorContaining(String nameAuthor);

    List<Author> findAll();

}
