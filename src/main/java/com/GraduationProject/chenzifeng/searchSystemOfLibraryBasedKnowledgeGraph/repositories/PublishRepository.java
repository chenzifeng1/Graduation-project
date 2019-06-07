package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Publish;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishRepository extends Neo4jRepository<Publish,Long> {

    /**
     * 根据出版社名称查找
     * @param publisher
     * @return
     */
    Publish findFirstByName(@Param("publisher")String publisher);

    /**
     * 查找书籍的出版社
     * @param book
     * @return
     */
    @Query("MATCH (b:book)-[r:`is_published_by`]->(p:publisher) RETURN p ")
    Publish getBookPublisher(@Param("book") String book);
}
