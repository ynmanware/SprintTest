package com.myn.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Snippet {

	public static void main(String[] args) {
		printMetadata(TheClass.class);
		System.out.println("======================================");
		printMetadata(MyObject.class);

	}

	public static void printMetadata(Class clazz) {

		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			System.out.println("method = " + method.getName());
			System.out.println("Annotation = "
					+ Arrays.toString(method.getAnnotations()));
		}

		System.out
				.println("--------------------------fields ---------------------");

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			System.out.println("Field =" + field.getName());
			Annotation[] annotations = field.getDeclaredAnnotations();

			for (Annotation annotation : annotations) {
				if (annotation instanceof MyAnnotation) {
					MyAnnotation myAnnotation = (MyAnnotation) annotation;
					System.out.println("name: " + myAnnotation.name());
					System.out.println("value: " + myAnnotation.value());
				}
				
				if (annotation instanceof Name) {
					Name myAnnotation = (Name) annotation;
					System.out.println("name: " + myAnnotation.name());
					System.out.println("value: " + myAnnotation.value());
				}
			}
		}

	}

	public class TheClass {

		@MyAnnotation(name = "someName", value = "Hello World")
		public String myField = null;
	}

	public static class MyObject {
		private String id;
		@Name(name = "name", value = "blah")
		private String name;

		public void setName(String name) {
			this.name = name;
		}
	}
}
