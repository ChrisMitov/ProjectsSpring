package com.example.service;

import com.example.exception.PersonException;
import com.example.model.Person;

public interface PersonService {
	void addPerson(Person person) throws PersonException;
}
