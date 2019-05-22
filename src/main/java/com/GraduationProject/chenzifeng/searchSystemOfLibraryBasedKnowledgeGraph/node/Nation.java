package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "nation")
public class Nation {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String country;

    public Nation(String country) {
        this.country = country;
    }

    public Nation() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }
}
