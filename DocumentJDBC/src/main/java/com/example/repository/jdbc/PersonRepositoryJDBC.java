package com.example.repository.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Document;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.utils.RowMap;

@Repository
public class PersonRepositoryJDBC implements PersonRepository{
	private NamedParameterJdbcTemplate temp;

	@Autowired
	public PersonRepositoryJDBC(NamedParameterJdbcTemplate temp) {
		this.temp = temp;
	}

	@Override
	public void addPerson(Person person) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into person (PERSON_ID, PERSON_NAME, AGE, PASSWORD) values ");
		sb.append("(offerdocs_seq.nextval, :name, :age, :password)");

		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", person.getName());
		personMap.put("age", person.getAge());
		personMap.put("password", person.getPassword());
		temp.update(sb.toString(), personMap);
	}

	@Override
	public boolean isExistingUser(String name) {
		boolean result = false;
		String sql = "SELECT COUNT(*) FROM PERSON WHERE PERSON_NAME = :name";
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		int count = temp.queryForObject(sql, personMap, Integer.class);
		if (count > 0) {
			result = true;
		}
		return result;
	}

}
