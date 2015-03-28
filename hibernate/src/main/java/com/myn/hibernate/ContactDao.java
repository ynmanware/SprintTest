package com.myn.hibernate;

import java.util.List;


public interface ContactDao {
  // Find all contacts
  public List<Contact> findAll();

  // Find all contacts with telephone and hobbies
  public List<Contact> findAllWithDetail();

  // Insert or update a contact
  public Contact save(Contact contact);

}
