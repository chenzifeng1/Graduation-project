package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.controller;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Book;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.TagRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.BookService;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl.BookServiceImpl;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl.TagServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagServiceImpl tagService;
    @Autowired
    private TagRepository tagRepository;


    @GetMapping("/findBookTag")
    @ApiOperation(value = "根据书籍查找领域标签",notes = "返回标签信息")
    @ApiImplicitParam(name = "book",value = "书名",required = true,dataType = "string",paramType = "query")
    public Object getBookTag(String book){
        System.out.println(book);
        System.out.println(tagService.findTagByBook(book));

        return tagService.findTagByBook(book);
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value = "查找领域标签",notes = "返回标签信息")
    @ApiImplicitParam(name = "tag",value = "领域名词",required = true,dataType = "string",paramType = "query")
    public Object getOneByName(String tag){
        System.out.println(tag);
        return tagService.findOneByName(tag);
    }

    @GetMapping("/findBookByTag")
    @ApiOperation(value = "根据领域查找书籍",notes = "返回书籍信息")
    @ApiImplicitParam(name = "tag",value = "领域名词",required = true,dataType = "string",paramType = "query")
    public Object findBookByTag(@Param("tag")String tag){
        Collection<Book> books = new ArrayList<>();
        System.out.println(tag);
        BookServiceImpl bookService = new BookServiceImpl();
        for(Book book:tagRepository.findBookByTag(tag) ){

            ((ArrayList<Book>) books).add(bookService.addProperty(book));
        }
        return books;
    }

}
