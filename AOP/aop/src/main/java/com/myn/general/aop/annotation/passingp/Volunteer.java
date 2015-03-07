package com.myn.general.aop.annotation.passingp;

import org.springframework.stereotype.Component;

@Component
public class Volunteer implements Thinker {
	private String thoughts;
	private Person person;

	public void thinkOfSomething(String thoughts, Person person) {
		this.thoughts = thoughts;
		this.person = person;
		
		System.out.println("person.id in Volunteer: " + person.getId());
		
		person.setId(100);
	}

	public String getThoughts() {
		return thoughts;
	}

	public Person getPerson() {
		return person;
	}
}