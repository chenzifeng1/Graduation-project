package com.GraduationProject.chenzifeng.searchSystemOfLibraryBasedKnowledgeGraph;

import org.neo4j.driver.v1.AuthToken;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SearchSystemOfLibraryBasedKnowledgeGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchSystemOfLibraryBasedKnowledgeGraphApplication.class, args);
	}

}

