package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Keyword;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface KeywordRepository extends Neo4jRepository<Keyword,Long> {

    /**
     * 通过领域名词查找某一领域
     * @param name
     * @return
     */
    Keyword  findFirstByName(@Param("name")String name);




}
