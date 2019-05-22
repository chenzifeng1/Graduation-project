package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Field;
import org.springframework.data.neo4j.annotation.Query;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface BookRepository extends Neo4jRepository<Book,Long> {

    @Query("MATCH (n:book) RETURN n")
    Collection<Book> getBookList();

    Collection<Book> findBookByAuthor(@Param("author") String author);
    //Iterable<Book> findBookByField(@Param("field") String field);

    /**
     * 根据书名获取节点
     * @param bookName
     * @return
     */
    @Query("MATCH(n:book) WHERE n.name = bookName return n")
    Book findFirstByName(@Param("bookName") String bookName);
    @Query("MATCH (n:book) RETURN n")
    Collection<Book> findAll();
    @Query("MATCH (n:book) RETURN n LIMIT 25")
    Collection<Book> getBookSimple();

    /**
     * 获取某一领域内的书籍信息
     * @param field
     * @return
     */
    @Query("MATCH p=(n:book)-[r:`belong to`]->(keyword{name:field}) RETURN n LIMIT 5")
    Collection<Book> getBookFromField(@Param("field")String field);

    /**
     * 通过书名获取相关的领域信息
     * @param bookName
     * @return
     */
    @Query("MATCH p=(:book{name:bookName})-[r:`belong to`]->(n:keyword) RETURN n LIMIT 25")
    Collection<Field> getBookField(@Param("bookName") String bookName);


}
