package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;


import lombok.Data;
import org.neo4j.ogm.annotation.*;


/**
 * @author chenzifeng
 * @version 1.0.0
 * 图数据库neo4j对应的图书节点 BookNode的实体类
 * 包括属性：
 *      自增的唯一:Id
 *      书名:name
 *      作者:author
 *      领域:field
 */
@NodeEntity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Property(name = "name")
    private String name;
    @Property(name = "author")
    private String author;
    @Property(name = "field")
    private String field;

    public Book(String name, String author, String field) {
        this.name = name;
        this.author = author;
        this.field = field;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
