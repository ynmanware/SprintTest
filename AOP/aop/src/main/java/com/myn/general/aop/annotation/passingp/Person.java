package com.myn.general.aop.annotation.passingp;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class Person {
	private String name;
	private int id;

	public Person(String string, int i) {
		this.name = string;
		this.id = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
