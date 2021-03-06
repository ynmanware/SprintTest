package com.myn.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// Import statements omitted
@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -4399744838471104517L;
  private String hobbyId;

  @Id
  @Column(name = "HOBBY_ID")
  public String getHobbyId() {
    return this.hobbyId;
  }

  public void setHobbyId(String hobbyId) {
    this.hobbyId = hobbyId;
  }

  private Set<Contact> contacts = new HashSet<Contact>();

  @ManyToMany
  @JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "HOBBY_ID"),
      inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
  public Set<Contact> getContacts() {
    return this.contacts;
  }

  public void setContacts(Set<Contact> contacts) {
    this.contacts = contacts;
  }

  public String toString() {
    return "Hobby :" + getHobbyId();
  }
}
