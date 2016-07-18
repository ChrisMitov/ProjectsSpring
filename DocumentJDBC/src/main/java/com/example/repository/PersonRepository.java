package com.example.repository;

import com.example.model.Person;

public interface PersonRepository {
	void addPerson(Person person);
	
	boolean isExistingUser(String name);
	
}
