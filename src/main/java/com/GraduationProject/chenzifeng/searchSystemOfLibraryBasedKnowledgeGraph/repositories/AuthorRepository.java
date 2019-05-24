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


    Collection<Author> findAuthorByNation(@Param("nation") String nation);

    @Query("MATCH (b:book)-[:belong to]->(a:author) " +
            "WHERE a.name = {author} " +
            "RETURN b")
    Collection<Book> findBookByAuthor(@Param("author")String author);



}
