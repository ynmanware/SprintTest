package com.myn.general.datasource2;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myn.general.oldstyle.domain.Contact;
import com.myn.general.oldstyle.domain.ContactTelDetail;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("com/myn/general/datasource2/app.xml");
		ContactDao contactDao = (ContactDao) context.getBean("contactDao");

		// Find and list all contacts
		// Find and list all contacts
		List<Contact> contacts = contactDao.findAll();
		listContacts(contacts);

		// Update contact
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Clarence");
		contact.setLastName("Peter");
		contact.setBirthDate(new Date((new GregorianCalendar(1977, 10, 1)).getTime().getTime()));
		contactDao.update(contact);
		contacts = contactDao.findAll();
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {
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