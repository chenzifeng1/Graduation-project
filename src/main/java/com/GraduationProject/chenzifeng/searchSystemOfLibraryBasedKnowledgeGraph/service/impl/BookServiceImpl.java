package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Author;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Publish;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.AuthorRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.BookRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.PublishRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.TagRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.BookService;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.LogDescribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@Service
public class BookServiceImpl implements BookService {

   protected final Logger logger = LoggerFactory.getLogger(LogDescribe.Book_S);

   @Autowired
   private PublishRepository publishRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BookRepository bookRepository;


    public BookServiceImpl() {
    }

    @Override
    public Object createBookNode(String book,String author) {
        Book booknode = new Book(book,author);
        return bookRepository.save(booknode);
    }

    @Override
    public Collection<Book> findFirstByName(String bookName) {
        Collection<Book> books =new ArrayList<>();
        Book book = bookRepository.findBookByName(bookName);
        ((ArrayList<Book>) books).add(addProperty(book));
        return books;

    }

    @Override
    public Object findByAuthor(String bookName) {
        boolean isExit = false;
        Author author = authorRepository.findAuthorByBook(bookName);
        System.out.println(author.getName());

        Collection<Book> books = new ArrayList<>();
        for(Book book:bookRepository.getBookByAuthor(author.getName())){
            if("该图书未添加描述".compareTo(book.getDesc())!=0)
                ((ArrayList<Book>) books).add(addProperty(book));
            if(book.getName()==bookName)
                isExit = true;
        }
        if(!isExit)
            ((ArrayList<Book>) books).add(
                    addProperty(bookRepository.findBookByName(bookName))
            );
        return books;
    }

    @Override
    public Collection<Book> findAll() {
        Collection<Book> books = new ArrayList<>();
        for (Book book : bookRepository.findAll()){
            if(book.getDesc()!="该图书未添加描述")
            ((ArrayList<Book>) books).add(addProperty(book));
        }
        return books;
    }

    @Override
    public Object findBookByPublisher(String bookName) {
        Publish publish = publishRepository.getBookPublisher(bookName);

        Collection<Book> books =new ArrayList<Book>();
        //将搜索书籍加入
        ((ArrayList<Book>) books)
                .add(addProperty(bookRepository.findBookByName(bookName)));
        for(Book book:bookRepository.getBookByPublisher(publish.getName())){
            if("该图书未添加描述".compareTo(book.getDesc())!=0)
                books.add(addProperty(book)) ;
        }
        return books;

    }

    /**
     * 从某一领域中获取书籍信息
     * @param bookName
     * @return
     */
    public Collection<Book> getBookFromField(@Param("field") String bookName){
        Collection<Tag> tags = tagRepository.getByBook(bookName);
        Collection<Book> books = new ArrayList<>();
        //将搜索书籍加入
        ((ArrayList<Book>) books)
                .add(addProperty(bookRepository.findBookByName(bookName)));
        int i=0,j=0;
        for (Tag tag : tags){
            String k = tag.getName();
            Collection<Book> sub_book = bookRepository.getBookFromField(tag.getName());
            System.out.println("book tag:"+k);
            for (Book book:sub_book){
                 book=addProperty(book);
                 books.add(book);
            }
            System.out.println("i:"+i);
            System.out.println("j:"+j);
        }
        return books;
    }

    /**
     * 通过书名获取此书关联的领域
     * @param bookName
     * @return
     */
    public Collection<Tag> getBookField(@Param("bookName") String bookName){
        logger.info("the book is:"+bookName);
        Collection<Tag> keywords =  bookRepository.getBookField(bookName);
        for (Tag keyword : keywords){
            System.out.println(keyword.getName());
        }
        return keywords;
    }

    public Collection<Book> getBookByAuthorAndTag(String bookname){
        Book book1 = bookRepository.findBookByName(bookname);
        Book book2 = addProperty(book1);

        Collection<Book> books = new ArrayList<>();

        for(Tag tag :book2.getBookTags())
            for(Book book :bookRepository.getBookByAuthorAndTag(tag.getName(),book2.getAuthor())) {
                books.add(addProperty(book));
            }
         return books;
    }


    public Book addProperty(Book book){
        System.out.println(book.getName());
        if(book.getAuthor()==null){
            Author author= authorRepository.findAuthorByBook(book.getName());
            if (author!=null){
                System.out.println(author.getName());
                book.setAuthor(author.getName());
            }else
                book.setAuthor("佚名");
        }
        if(book.getPublisher()==null){
            Publish publish = publishRepository.getBookPublisher(book.getName());
            System.out.println(publish.getName());
            book.setPublisher(publish.getName());
        }

        Collection<Tag> tags = tagRepository.getByBook(book.getName());

        for(Tag tag:tags){
            if (!book.getBookTags().contains(tag)) {
                book.addFieldTag(tag);
                logger.info(tag.getName());
            }
        }
        return book;
    }
}
