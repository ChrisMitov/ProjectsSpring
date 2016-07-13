package com.example.repository;

import java.util.Optional;

import com.example.model.Document;


public interface DocumentRepository {
	Iterable<Document> getDocuments();
	
	void addDocument(Document doc);

	Optional<Document> findById(long id);
}
