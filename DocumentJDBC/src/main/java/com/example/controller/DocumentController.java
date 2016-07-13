package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addDocument(@RequestBody Document document) {
		try {
			service.addDocument(document);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception name) {
			return new ResponseEntity<>(HttpStatus.LENGTH_REQUIRED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDocument(@PathVariable("id") long id, @RequestBody Document document) {
		System.out.println("HERE Controller");
		try {
			service.updateDocument(id, document);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception name) {
			return new ResponseEntity<>(HttpStatus.LENGTH_REQUIRED);
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Document> getById(@PathVariable("id") long id) {
		Optional<Document> document = service.findById(id);
		if (document.isPresent()) {
			return new ResponseEntity<>(document.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDocument(@PathVariable("id") long id) {
		System.out.println("Delete Controller");
		try {
			service.deleteDocument(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception name) {
			return new ResponseEntity<>(HttpStatus.LENGTH_REQUIRED);
		}
	}

}
