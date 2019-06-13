package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.controller;


import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Publish;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.PublishRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
public class PublishController {

    @Autowired
    private PublishRepository publishRepository;

    @GetMapping("/getPublisher")
    @ApiOperation(value = "根据书名获取出版社",notes = "返回出版社信息")
    @ApiImplicitParam(name = "book", value = "书名", required = true, dataType = "String", paramType = "query")
    public Object getPublisher(String book){
        Publish publish = publishRepository.getBookPublisher(book);
        System.out.println(publish.getName());
        return publish;
    }
}
