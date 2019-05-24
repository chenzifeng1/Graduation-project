package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Keyword;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.BookRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.KeywordRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.BookService;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.LogDescribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceImpl implements BookService {

   protected final Logger logger = LoggerFactory.getLogger(LogDescribe.Book_S);

    @Autowired
    private KeywordRepository keywordRepository;

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

    /**
     * 从某一领域中获取书籍信息
     * @param bookName
     * @return
     */
    public Collection<Book> getBookFromField(@Param("field") String bookName){
        Collection<Keyword> keywords = bookRepository.getBookField(bookName);
        Collection<Book> books = null;
        for (Keyword keyword : keywords){
            books.addAll(bookRepository.getBookFromField(keyword.getFieldName()));
            logger.info(keyword.getFieldName()+':'+ keyword.getId());
        }

        return books;
    }

    /**
     * 通过书名获取此书关联的领域
     * @param bookName
     * @return
     */
    public Collection<Keyword> getBookField(@Param("bookName") String bookName){
        logger.info("the book is:"+bookName);
        Collection<Keyword> keywords =  bookRepository.getBookField(bookName);
        for (Keyword keyword : keywords){
            System.out.println(keyword.getFieldName());
        }
        return keywords;
    }
}
