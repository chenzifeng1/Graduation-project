package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;

import java.util.Collection;

public interface TagService {
    Object findTagByBook(String book);

    Tag findOneByName(String tag);
}
