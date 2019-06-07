package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Keyword;
import org.springframework.data.neo4j.annotation.Query;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends Neo4jRepository<Book,Long> {

    @Query("MATCH (n:book) RETURN n")
    Collection<Book> findAll();



    //Iterable<Book> findBookByField(@Param("field") String field);

    /**
     * 根据书名获取节点
     * @param bookName
     * @return
     */
    Book findFirstByName(@Param("bookName") String bookName);


    @Query("MATCH (n:book) RETURN n LIMIT 25")
    Collection<Book> getBookSimple();

    /**
     * 获取某一领域内的书籍信息
     * @param field
     * @return
     */
    @Query("match p=(n:book)-[r:`belong to`]->(k:keyword) " +
            "where k.name ={field} " +
            "return n limit 3")
    Collection<Book> getBookFromField(@Param("field")String field);

    /**
     * 通过书名获取相关的领域信息
     * @param bookName
     * @return
     */
    @Query("MATCH p=(b:book)-[r:`belong to`]->(n:keyword) WHERE b.name ={bookName} RETURN n LIMIT 3")
    Collection<Keyword> getBookField(@Param("bookName") String bookName);

    /**
     * 根据领域标签寻找书籍
     * @param tag
     * @return
     */
    @Query("MATCH p=(b:book)-[r:`belong to`]->(t:tag) where t.name ={tag} RETURN b")
    Collection<Book> getBookByTag(@Param("tag") String tag);



}
