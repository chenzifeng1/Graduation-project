package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node;




import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
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

    @Property(name = "book_id")
    private long book_id;
    @Property(name = "name")
    private String name;
    @Property(name = "author")
    private String author;
    @Property(name ="publisher")
    private String publisher;
    @Property(name ="desc")
    private String desc;
    @Property(name ="img")
    private String img;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;

    }


    public Book(long book_id,String name, String author, String publisher) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(long book_id, String name, String author, String publisher, String desc, String img) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.desc = desc;
        this.img = img;
    }

    public Book() {
    }



    @Relationship(type = "belong_to",direction = Relationship.OUTGOING)
    private Collection<Tag> bookTags;
    /**
     * 添加书籍领域关系
     * @param tag 对应书籍所属于的领域
     */
    public void addFieldTag(Tag tag){
        if (this.bookTags == null)
            this.bookTags = new ArrayList<Tag>();
        this.bookTags.add(tag);
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Collection<Tag> getBookTags() {
        if (this.bookTags==null)
            this.bookTags= new ArrayList<>();
        return bookTags;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Author> getBookAuthors() {
        return bookAuthors;
    }
}
