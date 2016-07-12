package com.example.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Document;
import com.example.service.DocumentService;

@RestController
public class DocumentController {

	private DocumentService service;

	@Autowired
	public DocumentController(DocumentService service) {
		this.service = service;
	}

	@RequestMapping("/document")
	public Iterable<Document> getDocuments() {
		return service.getDocuments();
	}

	// @RequestMapping(value = "/document", method=RequestMethod.POST)
	// public void addDocument(@RequestParam(value = "name") String
	// name,@RequestParam(value = "createdOn") Date createdOn ){
	// Document document = new Document(name, createdOn);
	// service.addDocument(document);
	// }

	@RequestMapping(value = "/document", method = RequestMethod.POST)
	public void addDocument(@RequestBody Document document) {
		service.addDocument(document);
	}
}
