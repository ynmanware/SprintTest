package com.myn.general.aop.before;

public class MessageWriter {
	public void writeMessage(Person s1) {
		System.out.print(s1.getName());
	}

	public void writeMessage2(Person s1) {
		System.out.print(s1.getName());
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
