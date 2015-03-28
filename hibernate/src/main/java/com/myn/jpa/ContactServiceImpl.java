package com.myn.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

  private Log log = LogFactory.getLog(ContactServiceImpl.class);

  @PersistenceContext
  EntityManager em;

  @Transactional(readOnly = true)
  public List<Contact> findAll() {
    List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    return contacts;
  }

  @Transactional(readOnly = true)
  public void displayAllContactSummary() {
    List result =
        em.createQuery(
            "select c.firstName, c.lastName, t.telNumber "
                + "from Contact c left join c.contactTelDetails t " + " where t.telType='Home'")
            .getResultList();
    int count = 0;
    for (Iterator i = result.iterator(); i.hasNext();) {
      Object[] values = (Object[]) i.next();
      System.out.println(++count + ": " + values[0] + ", " + values[1] + ", " + values[2]);
    }
  }

  @Transactional
  public Contact save(Contact contact) {
    if (contact.getId() == null) { // Insert Contact
      log.info("Inserting new contact");
      em.persist(contact);
    } else { // Update Contact
      em.merge(contact);
      log.info("Updating existing contact");
    }
    log.info("Contact saved with id: " + contact.getId());
    return contact;
  }
}