package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 查询接口
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @GetMapping("/book")
    public Object searchBook(String bookInfor){
        return null;
    }
}
