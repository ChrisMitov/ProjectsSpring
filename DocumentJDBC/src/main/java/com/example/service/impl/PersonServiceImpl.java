package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.PersonException;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	private PersonRepository repo;

	@Autowired
	public PersonServiceImpl(PersonRepository repo) {
		this.repo = repo;
	}

	@Override
	public void addPerson(Person person) throws PersonException {
		registerUser(person);
//		person.setAge((int) (Math.random() * 80 + 18));
		repo.addPerson(person);

	}

	private void registerUser(Person person) throws PersonException {
		if (!usernameCheck(person.getName())) {
			throw new PersonException("Username not correct");
		}
		if (repo.isExistingUser(person.getName())) {
			throw new PersonException("User exists");
		}
		if (!passwordCheck(person.getPassword())) {
			throw new PersonException("Incorrect password");
		}
	}

	private boolean passwordCheck(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,10}$";
		return check(password, regex);
	}

	private boolean check(String string, String regex) {
		boolean result = true;
		if (!string.matches(regex)) {
			result = false;
		}
		return result;
	}

	private boolean usernameCheck(String name) {
		String regex = "^[a-z0-9_-]{3,15}$";
		return check(name, regex);
	}

}
