package com.example.luyen_tap_blog.service;

import com.example.luyen_tap_blog.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAlLAuthor();
    Author findById(int id);
    Author findByNameFalse(String name);
    void addAuthor(Author author);
    List<Author> findByName(String name);
}
