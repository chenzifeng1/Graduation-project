package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;



@SpringBootApplication
@EnableNeo4jRepositories
public class SearchSystemOfLibraryBasedKnowledgeGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchSystemOfLibraryBasedKnowledgeGraphApplication.class, args);
	}

}

