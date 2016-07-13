package com.example.service;

import java.util.Optional;

import com.example.model.Document;

public interface DocumentService {
	Iterable<Document> getDocuments();

	void addDocument(Document doc);

	void updateDocument(long id, Document document);

	void deleteDocument(long id);

	Optional<Document> findById(long id);
}
