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

    @Property
    private String fieldName;
    @Property
    private String descritbe;

    public Keyword(Long id, String fieldName, String descritbe) {
        this.id = id;
        this.fieldName = fieldName;
        this.descritbe = descritbe;
    }

    public Keyword() {
    }

    public Long getId() {
        return id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDescritbe() {
        return descritbe;
    }

    public void setDescritbe(String descritbe) {
        this.descritbe = descritbe;
    }
}
