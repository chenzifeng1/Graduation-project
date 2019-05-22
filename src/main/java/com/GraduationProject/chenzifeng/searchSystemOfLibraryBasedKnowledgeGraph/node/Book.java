package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;




import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
@NodeEntity(label = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;
    @Property(name = "author")
    private String author;



    public Book(String name, String author) {
        this.name = name;
        this.author = author;

    }

    public Book() {
    }



    @Relationship(type = "belong to",direction = Relationship.OUTGOING)
    private List<Field> bookFields;
    /**
     * 添加书籍领域关系
     * @param field 对应书籍所属于的领域
     */
    public void addField(Field field){
        if (this.bookFields == null)
            this.bookFields = new ArrayList<Field>();
        this.bookFields.add(field);
    }

    @Relationship(type = "is written by",direction = Relationship.OUTGOING)
    private List<Author> bookAuthors;

    public void addAuthor(Author author){
        if (this.bookAuthors == null)
            this.bookAuthors = new ArrayList<Author>();
        bookAuthors.add(author);
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public List<Field> getBookFields() {
        return bookFields;
    }

    public List<Author> getBookAuthors() {
        return bookAuthors;
    }
}
