package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;


import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TagRepository extends Neo4jRepository<Tag,Long> {

    /**
     * 通过领域名词查找某一领域
     * @param name
     * @return
     */
    Tag findFirstByName(@Param("name")String name);

    /**
     * 查找书籍关联的领域
     * @param book
     * @return
     */
    @Query("MATCH p=(b:book)-[r:belong_to]->(t:tag) where b.name={book} RETURN t")
    Collection<Tag> getByBook(@Param("book")String book);


    @Query("match p=(n:book)-[r:`belong_to`]->(k:tag) " +
            "where k.name ={tag} " +
            "return n limit 10")
    Collection<Book> findBookByTag(String tag);
}
