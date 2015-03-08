package com.myn.dataaccess.dbcp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myn.general.oldstyle.domain.Contact;
import com.myn.general.oldstyle.domain.ContactTelDetail;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("com/myn/dataaccess/dbcp/app.xml");
		ContactDao contactDao = (ContactDao) context.getBean("contactDao");

		// Find and list all contacts
		List<Contact> contacts = contactDao.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
			System.out.println();
		}

	}

}