package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;


import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Nation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NationRepository extends Neo4jRepository<Nation,Long> {

    /**
     * 查找国家接口
     * @param country
     * @return
     */
    Nation findFirstByName(@Param("country")String country);

    /**
     * 查找作者的国籍
     * @param author
     * @return
     */
    @Query("MATCH p=(a:author)-[r:nationality_is]->(n:nation) " +
            "where a.name ={author} " +
            "RETURN n")
    Nation getAuthorNation(@Param("author") String author);
}
