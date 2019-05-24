package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service;


import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Keyword;

import java.util.Collection;

public interface KeywordService {

    Keyword findByFieldName(String fieldName);
    Collection<Keyword> findAll();

}
