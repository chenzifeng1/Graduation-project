package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Publish;
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
}
