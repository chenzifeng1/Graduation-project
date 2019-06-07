package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.repositories;

import com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph.relationship.Book_Author;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Book_AuthorRepository extends Neo4jRepository<Book_Author,Long> {

    /**
     * 添加书籍与作者之间的关系
     * @param book
     * @param author
     * @return
     */
    @Query("match (b:book),(a:author) where b.name = {book} and a.name = {author}" +
            "create(b)-[w:is_written_by]->(a)")
    Book_Author addAuthorForBook(@Param("book") String book,@Param("author") String author);
}
