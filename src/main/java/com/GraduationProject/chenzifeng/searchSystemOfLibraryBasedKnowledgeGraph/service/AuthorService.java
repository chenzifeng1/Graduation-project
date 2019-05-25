package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Author;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AuthorService {

    Object findAll();

    Author findOne(long id);

    /**
     * 通过作者姓名查找作者
     * @param name
     * @return
     */
    Author findAuthorByName(@Param("name") String name);

    /**
     * 通过国籍寻找作者
     * @param country
     * @return
     */
    Collection<Author> findAuthorByNation(@Param("country") String country);

    /**
     *查找书籍的作者
     * @param book
     * @return
     */
    Author findAuthorByBook(@Param("book") String book);
}
