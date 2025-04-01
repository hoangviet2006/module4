package com.example.luyen_tap_blog.repository;

import com.example.luyen_tap_blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAll();
}
