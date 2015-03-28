package com.myn.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {

  private Log log = LogFactory.getLog(ContactDaoImpl.class);
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  @Resource(name = "sessionFactory")
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional(readOnly = true)
  public List<Contact> findAll() {
    return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
  }

  @Transactional(readOnly = true)
  public List<Contact> findAllWithDetail() {
    return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
  }

  @Transactional
  public Contact save(Contact contact) {
    sessionFactory.getCurrentSession().saveOrUpdate(contact);
    log.info("Contact saved with id: " + contact.getId());
    return contact;
  }
}
