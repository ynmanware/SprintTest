package com.myn.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {
  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("com/myn/hibernate/app.xml");
    ctx.refresh();
    ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
    // List<Contact> contacts = contactDao.findAll();

    // create
    Contact c = newContact();
    contactDao.save(c);

    List<Contact> contacts = contactDao.findAllWithDetail();
    listContactsWithDetail(contacts);
  }

  private static Contact newContact() {
    Contact contact = new Contact();
    contact.setFirstName("Yogesh");
    contact.setLastName("Manware");
    contact.setBirthDate(new Date());
    ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "912045706059");
    contact.addContactTelDetail(contactTelDetail);
    contactTelDetail = new ContactTelDetail("Mobile", "9730621038");
    contact.addContactTelDetail(contactTelDetail);
    return contact;
  }

  private static void listContacts(List<Contact> contacts) {
    System.out.println("");
    System.out.println("Listing contacts without details:");
    for (Contact contact : contacts) {
      System.out.println(contact);
      System.out.println();
    }
  }

  private static void listContactsWithDetail(List<Contact> contacts) {
    System.out.println("");
    System.out.println("Listing contacts with details:");
    for (Contact contact : contacts) {
      System.out.println(contact);
      if (contact.getContactTelDetails() != null) {
        for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
          System.out.println(contactTelDetail);
        }
      }
      if (contact.getHobbies() != null) {
        for (Hobby hobby : contact.getHobbies()) {
          System.out.println(hobby);
        }
      }
      System.out.println();
    }
  }
}
