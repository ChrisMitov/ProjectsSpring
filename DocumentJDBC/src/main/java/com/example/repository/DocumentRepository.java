package com.example.repository;

import com.example.model.Document;


public interface DocumentRepository {
	Iterable<Document> getDocuments();
	
	void addDocument(Document doc);
}
