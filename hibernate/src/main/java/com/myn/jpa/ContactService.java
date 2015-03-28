package com.myn.jpa;

import java.util.List;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public interface ContactService {
  List<Contact> findAll();

  void displayAllContactSummary();

  Contact save(Contact contact);
}
