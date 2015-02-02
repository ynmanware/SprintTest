package com.myn.properties;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yogesh.Manware
 *
 *         Properties file test
 *
 */
public class App {
	public static void main(String[] args) {
		// loading the definitions from the given XML file
		System.out.println("getting context...");
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

		testI18n2(context);
	}

	public static void testI18n(ApplicationContext context) {
		MessageSource d = (MessageSource) context.getBean("rest-common-messages");
		I18n(d, "reporting.title");
		I18n(d, "reporting.title.param1", "A");
		I18n(d, "reporting.title.param2", "A", "B");
	}

	public static void I18n(MessageSource d, String key, String... params) {
		System.out.println(d.getMessage(key, params, new Locale("en")));
	}
	
	/**
	 * @param context
	 */
	public static void testI18n2(ApplicationContext context){
		RestCommon d = (RestCommon) context.getBean("restCommon");
		I18n(d, "reporting.title");
		I18n(d, "reporting.title.param1", "A");
		I18n(d, "reporting.title.param2", "A", "B");
		System.out.println(d.getAllProp());
	}
}
