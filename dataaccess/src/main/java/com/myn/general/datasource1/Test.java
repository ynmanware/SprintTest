package com.myn.general.datasource1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myn.general.oldstyle.domain.Contact;
import com.myn.general.oldstyle.domain.ContactTelDetail;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("com/myn/general/datasource1/app.xml");
		ContactDao contactDao = (ContactDao) context.getBean("contactDao");

		System.out.println("success: " + contactDao.findFirstNameById(1L));
		System.out.println("success: " + contactDao.findFirstNameById(2L));

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

		// Find and list all contacts
		List<Contact> contactsWithDetail = contactDao.findAllWithDetail();
		for (Contact contact : contactsWithDetail) {
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