package com.example;

import java.sql.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.model.Document;
import com.example.service.DocumentService;

@SpringBootApplication
public class DocumentJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentJdbcApplication.class, args);
//		ConfigurableApplicationContext ctx = SpringApplication.run(DocumentJdbcApplication.class, args);
//		DocumentService service = ctx.getBean(DocumentService.class);
//		service.addDocument(
//				new Document("Application document with service via STS 2", new Date(new java.util.Date().getTime())));
//		Iterable<Document> documents = service.getDocuments();
//		for (Document document : documents) {
//			System.out.println(document.getId() + "\t" + document.getName() + "\t" + document.getCreatedOn());
//
//		}
	}
}
