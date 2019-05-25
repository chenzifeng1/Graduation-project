package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Author;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.AuthorRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Collection<Author> findAll() {
        Collection<Author> authors = (Collection<Author>) authorRepository.findAll();
        return authors;
    }

    @Override
    public Author findOne(long id) {
        Optional<Author> author = authorRepository.findById( id);
        return author.get();
    }

    @Override
    public Author findAuthorByName(String name) {

        return authorRepository.findFirstByName(name);
    }

    @Override
    public Collection<Author> findAuthorByNation(String country) {
        return authorRepository.findAuthorByNation(country);
    }

    @Override
    public Author findAuthorByBook(String book) {
        return null;
    }
}
