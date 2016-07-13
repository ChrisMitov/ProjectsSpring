package com.example.controller;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Document;
import com.example.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

	private DocumentService service;

	@Autowired
	public DocumentController(DocumentService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Document> getDocuments() {
		return service.getDocuments();
	}

	// @RequestMapping(value = "/document", method=RequestMethod.POST)
	// public void addDocument(@RequestParam(value = "name") String
	// name,@RequestParam(value = "createdOn") Date createdOn ){
	// Document document = new Document(name, createdOn);
	// service.addDocument(document);
	// }

	@RequestMapping(method = RequestMethod.POST)
	public void addDocument(@RequestBody Document document) {
		service.addDocument(document);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Document> getById(@PathVariable("id") long id) {
		Optional<Document> document = service.findById(id);
		if (document.isPresent()) {
			return new ResponseEntity<>(document.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
