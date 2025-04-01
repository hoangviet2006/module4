package com.example.luyen_tap_blog.service;

import com.example.luyen_tap_blog.model.Author;
import com.example.luyen_tap_blog.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AuthorService implements IAuthorService{
    @Autowired
    private IAuthorRepository authorRepository;
    @Override
    public List<Author> findAlLAuthor() {
        return authorRepository.findAll();
    }
}
