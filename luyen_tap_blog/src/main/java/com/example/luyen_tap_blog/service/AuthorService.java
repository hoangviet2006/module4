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

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author  findByNameFalse(String name) {
        return authorRepository.findByNameAuthorContainingIgnoreCase(name);
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findByName(String name) {
        return authorRepository.findByNameAuthor(name);
    }


}
