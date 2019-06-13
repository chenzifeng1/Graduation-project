package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Author;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AuthorRepository extends Neo4jRepository<Author,Long> {

    /**
     * 根据国籍查找作者
     * @param nation
     * @return
     */
    @Query("MATCH (a:author)-[:`nationality_is`]->(n:nation) " +
            "WHERE n.nation = {nation} " +
            "RETURN a")
    Collection<Author> findAuthorByNation(@Param("nation") String nation);

    /**
     * 查找书籍对应的作者
     * @param name  作者姓名
     * @return
     */
    @Query("MATCH (b:book)-[:belong_to]->(a:author) " +
            "WHERE a.name = {name} " +
            "RETURN b")
    Collection<Book> findBookByAuthor(@Param("name")String name);

    /**
     * 根据作者姓名查找作者
     * @param name
     * @return
     */

    Author findFirstByName(@Param("name") String name);

    /**
     * 根据书籍查找作者
     * @param book
     * @return
     */
    @Query("MATCH (b:book)-[:is_written_by]->(a:author) WHERE b.name = {book} RETURN a limit 1")
    Author findAuthorByBook(@Param("book") String book);



}
