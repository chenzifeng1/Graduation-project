package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Field;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.BookRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.BookService;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {


    final private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @Override
    public Object createBookNode(String book,String author) {
        Book booknode = new Book(book,author);
        return bookRepository.save(booknode);
    }

    @Override
    public Book findFirstByName(String bookName) {
        return bookRepository.findFirstByName(bookName);
    }

    @Override
    public Object findByAuthor(String author) {
        return findByAuthor(author);
    }

    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    public Collection<Book> getBookFromField(String bookName){
        Book book = bookRepository.findFirstByName(bookName);
        Collection<Field> fields = bookRepository.getBookField(bookName);
        Collection<Book> books = null;
        for(Field field:fields){
            System.out.println(field.getFieldName());
            books.addAll(bookRepository.getBookFromField(field.getFieldName()));
        }
        return books;
    }
}
