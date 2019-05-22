package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service;

public interface BookService {
    Object createBookNode(String book,String author);
    Object findFirstByName(String bookName);
    Object findByAuthor(String author);
    Object findAll();

}
