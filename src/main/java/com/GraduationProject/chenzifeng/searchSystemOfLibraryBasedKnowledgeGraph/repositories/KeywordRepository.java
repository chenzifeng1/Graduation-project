package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Keyword;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface KeywordRepository extends Neo4jRepository<Keyword,Long> {

    /**
     * 通过领域名词查找某一领域
     * @param fieldName
     * @return
     */
    Collection<Keyword> findByFieldName(@Param("fieldName")String fieldName);




}
