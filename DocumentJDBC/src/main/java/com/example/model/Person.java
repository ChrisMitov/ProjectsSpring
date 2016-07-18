package com.example.model;

public class Person {
	private long id;
	private String name;
	private int age;
	private String password;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Person(String name, int age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
