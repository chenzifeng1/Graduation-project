package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.impl;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.node.Tag;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories.TagRepository;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.LogDescribe;
import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;
    protected final Logger logger = LoggerFactory.getLogger(LogDescribe.Tag_S);


    @Override
    public Object findTagByBook(String book) {
        Collection<Tag> tags = tagRepository.getByBook(book);
        if (tags.isEmpty())
            logger.info("the book:"+book+"'s tag is null");
        System.out.println(tags.size());
        for (Tag tag:tags)
            System.out.println(tag.getName());
        return tags;
    }

    @Override
    public Tag findOneByName(String tag) {
        return null;
    }
}
