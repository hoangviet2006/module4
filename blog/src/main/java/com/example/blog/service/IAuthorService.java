package com.example.blog.service;

import com.example.blog.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAuthor();
    Author findAuthor(long id);
    List<Author> findAllAuthor();
}
