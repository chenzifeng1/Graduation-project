package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "keyword")
public class Keyword {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;
    @Property(name = "describe")
    private String describe;

    public Keyword(Long id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public Keyword() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
