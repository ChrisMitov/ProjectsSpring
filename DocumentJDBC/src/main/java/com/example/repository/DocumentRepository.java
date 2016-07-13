package com.example.repository;

import java.util.Optional;

import com.example.model.Document;


public interface DocumentRepository {
	Iterable<Document> getDocuments();
	
	void addDocument(Document doc);
	
	void updateDocument(long id, Document document);
	
	void deleteDocument(long id);

	Optional<Document> findById(long id);
}
