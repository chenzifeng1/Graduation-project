package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;
import org.springframework.data.neo4j.annotation.Query;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends Neo4jRepository<Book,Long> {

    @Query("match p=(n:book)-[r:`belong_to`]->(k:tag) " +
            "where k.name =\"互联网\" " +
            "return n limit 3")
    Collection<Book> findAll();



    //Iterable<Book> findBookByField(@Param("field") String field);

    /**
     * 根据书名获取节点
     * @param bookName
     * @return
     */
    @Query("MATCH (b:book) where b.name={bookName} RETURN b LIMIT 1")
    Book findBookByName(@Param("bookName") String bookName);


    @Query("MATCH (n:book) RETURN n LIMIT 25")
    Collection<Book> getBookSimple();

    /**
     * 获取某一领域内的书籍信息
     * @param field
     * @return
     */
    @Query("match p=(n:book)-[r:`belong_to`]->(k:tag) " +
            "where k.name ={field} " +
            "return n limit 3")
    Collection<Book> getBookFromField(@Param("field")String field);

    /**
     * 通过书名获取相关的领域信息
     * @param bookName
     * @return
     */
    @Query("MATCH p=(b:book)-[r:`belong_to`]->(n:tag) WHERE b.name ={bookName} RETURN n LIMIT 3")
    Collection<Tag> getBookField(@Param("bookName") String bookName);

    /**
     * 根据领域标签寻找书籍
     * @param tag
     * @return
     */
    @Query("MATCH p=(b:book)-[r:belong_to]->(t:tag) where t.name={tag} RETURN b limit 5")
    Collection<Book> getBookByTag(@Param("tag") String tag);

    /**
     * 通过出版机构获取书籍
     * @param publisher
     * @return
     */
    @Query("MATCH p=(b:book)-[r:is_published_by]->(pub:publish) where pub.name ={publisher}  RETURN p LIMIT 10")
    Collection<Book> getBookByPublisher(@Param("publisher") String publisher);

    /**
     * 根据作者寻找书籍
     * @param author
     * @return
     */
    @Query("MATCH p=(b:book)-[r:is_written_by]->(a:author) where a.name={author} return b ")
    Collection<Book> getBookByAuthor(@Param("author")String author);


    /**
     *
     * @param tag
     * @param author
     * @return
     */
    @Query("MATCh p=(b:book)-[r:belong_to]->(t:tag), (b)-[:is_written_by]->(a:author) where t.name={tag} and a.name={author} return b")
    Collection<Book> getBookByAuthorAndTag(@Param("tag") String tag,@Param("author")String author);

}
