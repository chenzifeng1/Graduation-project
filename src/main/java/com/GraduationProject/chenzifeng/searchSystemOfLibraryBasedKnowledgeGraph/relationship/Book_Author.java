package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.relationship;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Author;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "is written by")
public class Book_Author {
    @StartNode
    private Book book;
    @EndNode
    private Author author;

    public Book_Author(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public Book_Author() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
