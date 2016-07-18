package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.PersonException;
import com.example.model.Person;
import com.example.service.PersonService;

@RestController
public class PersonController {
	private PersonService service;

	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> registerUser(@RequestBody Person person) {
		try {
			service.addPerson(person);
		} catch (PersonException name) {
			System.out.println(name.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

}
