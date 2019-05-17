package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.dto;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends Neo4jRepository<Book,Integer> {

    @Query("MATCH (n:book) RETURN n")
    Iterable<Book> getBookList();

    Iterable<Book> findBookByAuthor(String author);
    Iterable<Book> findBooksByField(String field);
    Book findFirstByName(String name);

    @Query("MATCH (n:book) RETURN n LIMIT 25")
    Iterable<Book> getBookSimple();
}
