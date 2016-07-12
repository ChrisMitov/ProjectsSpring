package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Document;
import com.example.repository.DocumentRepository;
import com.example.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	private DocumentRepository repo;

	@Autowired
	public DocumentServiceImpl(DocumentRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<Document> getDocuments() {
		return repo.getDocuments();
	}

	@Override
	public void addDocument(Document doc) {
		repo.addDocument(doc);
	}

}
