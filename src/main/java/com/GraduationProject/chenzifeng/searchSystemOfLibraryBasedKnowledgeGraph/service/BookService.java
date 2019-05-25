package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service;

import org.springframework.data.repository.query.Param;

public interface BookService {
    Object createBookNode(String book,String author);

    /**
     * 根据书名查找书
     * @param bookName
     * @return
     */
    Object findFirstByName(@Param("bookName") String bookName);
    Object findByAuthor(String author);
    Object findAll();

}
