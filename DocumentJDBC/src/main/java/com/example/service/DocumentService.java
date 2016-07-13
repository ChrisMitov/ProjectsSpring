package com.example.service;

import java.util.Optional;

import com.example.model.Document;

public interface DocumentService {
	Iterable<Document> getDocuments();

	void addDocument(Document doc);
	
	Optional<Document> findById(long id);
}
