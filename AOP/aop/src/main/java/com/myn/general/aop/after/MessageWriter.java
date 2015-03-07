package com.myn.general.aop.after;

public class MessageWriter {
	public Person writeMessage(Person s1) {
		System.out.println(s1.getName());
		//s1.setName("returning ..." + s1.name);

		return s1;
	}

	public static class Person {
		String name;
		String id;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
