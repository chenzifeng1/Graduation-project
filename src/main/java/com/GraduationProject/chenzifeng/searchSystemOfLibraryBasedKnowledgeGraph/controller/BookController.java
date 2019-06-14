package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.controller;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.LogDescribe;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl.BookServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    protected final Logger logger = LoggerFactory.getLogger(LogDescribe.Book_C);


    @GetMapping(path = "/getBook")
    @ApiOperation(value="获取书籍节点信息")
    public Object getBook(){
        return bookService.findAll();
    }

    @ApiOperation(value = "根据书名获取书籍",notes = "返回从此节点出发的关系的所有书籍，仅一层关系")
    @ApiImplicitParam(name = "bookName", value = "书名", required = true, dataType = "String", paramType = "query")
    @GetMapping(path = "/getBookByName")
    public Object getBookByName(String bookName){
        System.out.println(bookName);
        return bookService.findFirstByName(bookName);
    }

    @ApiOperation(value = "创建图书节点",notes = "图书节点信息：书名，作者，领域")
    @ApiImplicitParams(
            {
                @ApiImplicitParam(name = "bookName", value = "书名", required = true, dataType = "String", paramType = "query"),
                @ApiImplicitParam(name = "author", value = "作者", required = true, dataType = "String", paramType = "query"),
                @ApiImplicitParam(name = "field", value = "领域", required = true, dataType = "String", paramType = "query")
            }
    )
    @PostMapping(path = "/createBookNode")
    public Object createBookNode(String bookName,String author){

        return bookService.createBookNode(bookName,author);
    }

    @GetMapping(path = "/getBookFromField")
    @ApiOperation(value = "查找与传入书籍属于同一领域的其他书籍",notes = "限定五本")
    @ApiImplicitParam(name = "bookName",value = "书名",required = true,dataType = "String",paramType = "query")
    public Collection<Book> getBookFromField(String bookName){
        return bookService.getBookFromField(bookName);
    }


    /**
     * @param bookName
     * @return
     */
    @GetMapping(path = "/getBookField")
    @ApiOperation(value = "查找参数书籍所关联的领域",notes = "直接关联")
    @ApiImplicitParam(name = "bookName",value = "书名",required = true,dataType = "string",paramType = "query")
    public Collection<Tag> getBookField(String bookName){
        logger.info("the book is:"+bookName);
        return bookService.getBookField(bookName);
    }

    @GetMapping(path = "/getBookByPublisher")
    @ApiOperation(value = "根据出版社查找书籍",notes = "返回书籍信息")
    @ApiImplicitParam(name = "book",value = "书名",required = true,dataType = "string",paramType = "query")
    public Object getBookByPublisher(String book){
        return bookService.findBookByPublisher(book);
    }


    @GetMapping(path = "/getBookByAuthor")
    @ApiOperation(value = "根据作者查找书籍",notes = "返回书籍信息")
    @ApiImplicitParam(name = "book",value = "书名",required = true,dataType = "string",paramType = "query")
    public Object getBookByAuthor(String book){
        System.out.println(book);
        return bookService.findByAuthor(book);
    }

    @GetMapping(path = "/getBookByAuthorAndTag")
    @ApiOperation(value = "根据作者和领域查找书籍",notes = "返回书籍信息")
    @ApiImplicitParam(name = "book",value = "书名",required = true,dataType = "string",paramType = "query")
    public Object getBookByAuthorAndTag(String book){
        return bookService.getBookByAuthorAndTag(book);
    }

    @GetMapping(path = "/getBookByTag")
    @ApiOperation(value = "根据领域查找书籍",notes = "返回书籍信息")
    @ApiImplicitParam(name = "tag",value = "领域",required = true,dataType = "string",paramType = "query")
    public Object getBookByTag(String tag){
        return bookService.findBookByTag(tag);
    }


}
