package com.example.service.impl;

import java.util.Optional;

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

	@Override
	public Optional<Document> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public void updateDocument(long id, Document document) {
		repo.updateDocument(id, document);
		
	}

	@Override
	public void deleteDocument(long id) {
		repo.deleteDocument(id);
	}

}
