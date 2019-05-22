package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.controller;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.BookRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl.BookServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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




    @GetMapping(path = "/getBook")
    @ApiOperation(value="获取书籍节点信息")
    public Object getBook(){
        return bookService.findAll();
    }

    @ApiOperation(value = "根据书名获取书籍",notes = "返回从此节点出发的关系的所有书籍，仅一层关系")
    @ApiImplicitParam(name = "bookName", value = "书名", required = true, dataType = "String", paramType = "path")
    @GetMapping(path = "/getBookByName")
    public Book getBookByName(String bookName){

        return bookService.findFirstByName(bookName);
    }

    @ApiOperation(value = "创建图书节点",notes = "图书节点信息：书名，作者，领域")
    @ApiImplicitParams(
            {
                @ApiImplicitParam(name = "bookName", value = "书名", required = true, dataType = "String", paramType = "path"),
                @ApiImplicitParam(name = "author", value = "作者", required = true, dataType = "String", paramType = "path"),
                @ApiImplicitParam(name = "field", value = "领域", required = true, dataType = "String", paramType = "path")
            }
    )
    @PostMapping(path = "/createBookNode")
    public Object createBookNode(String bookName,String author){

        return bookService.createBookNode(bookName,author);
    }

    @GetMapping(path = "/getBookFromField")
    @ApiOperation(value = "查找与传入书籍属于同一领域的其他书籍",notes = "限定五本")
    @ApiImplicitParam(name = "bookName",value = "书名",required = true,dataType = "String",paramType = "path")
    public Collection<Book> getBookFromField(String bookName){
        return null;

    }
}
