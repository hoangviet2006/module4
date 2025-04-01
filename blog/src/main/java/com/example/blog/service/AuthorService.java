package com.example.blog.service;

import com.example.blog.model.Author;
import com.example.blog.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements IAuthorService{
    @Autowired
    private IAuthorRepository authorRepository;
    @Override
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthor(long id) {
        return authorRepository.findAuthorsById(id);
    }

    @Override
    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }
}
