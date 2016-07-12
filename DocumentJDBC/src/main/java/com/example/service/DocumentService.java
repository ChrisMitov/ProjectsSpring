package com.example.service;

import com.example.model.Document;

public interface DocumentService {
	Iterable<Document> getDocuments();

	void addDocument(Document doc);
}
