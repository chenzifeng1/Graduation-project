package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;

import org.neo4j.ogm.annotation.*;

import javax.annotation.Generated;


@NodeEntity(label = "author")
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;
    @Property(name = "nation")
    private String nation;

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }
    public Author() {
    }

    @Relationship(type = "nation",direction =Relationship.OUTGOING)
    private Nation nationality; //国籍

    public Nation getNationality() {
        return nationality;
    }

    public void setNationality(Nation nationality) {
        this.nationality = nationality;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
