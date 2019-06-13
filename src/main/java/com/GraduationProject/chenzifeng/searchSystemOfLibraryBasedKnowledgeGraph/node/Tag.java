package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "tag")
public class Tag {
    @Id
    @GeneratedValue
    private long id;

    @Property(name = "name")
    private String name;
    @Property(name = "page")
    private int page;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, int page) {
        this.name = name;
        this.page = page;
    }

    public Tag() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
