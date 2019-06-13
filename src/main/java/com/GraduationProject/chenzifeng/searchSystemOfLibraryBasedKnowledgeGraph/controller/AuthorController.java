package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.controller;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.AuthorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/author")
@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @GetMapping("/findOne")
    @ApiOperation(value = "根据姓名查询作者信息",notes = "返回作者信息")
    @ApiImplicitParam(name = "author",value = "作者姓名",required = true,dataType = "string",paramType = "query")
    public Object findAuthor(@Param("author") String author){
        return authorService.findAuthorByName(author);
    }

    @GetMapping("/findByBook")
    @ApiOperation(value = "根据书籍查询作者",notes = "返回作者信息")
    @ApiImplicitParam(name = "bookname",value = "书名",required = true,dataType = "string",paramType = "query")
    public Object findAuthorByBook(@Param("bookname") String bookname){
        return authorService.findAuthorByBook(bookname);
    }

    @GetMapping("/findByNation")
    @ApiOperation(value = "根据国籍查询作者",notes = "返回作者信息")
    @ApiImplicitParam(name = "nation",value = "国籍",required = true,dataType = "string",paramType = "query")
    public Object findAuthorByNation(@Param("nation")String nation){
        return authorService.findAuthorByNation(nation);
    }

}
