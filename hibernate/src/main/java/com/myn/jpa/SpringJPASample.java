package com.myn.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJPASample {
  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("com/myn/jpa/app.xml");
    ctx.refresh();
    ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

    contactService.save(newContact("Yogesh"));
    contactService.save(newContact("Sayuri"));

    // List contacts without details
    List<Contact> contacts = contactService.findAll();
    listContacts(contacts);

    // custom query data
    // contactService.displayAllContactSummary();
  }

  private static Contact newContact(String name) {
    Contact contact = new Contact();
    contact.setFirstName(name);
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
