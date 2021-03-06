package com.myn.hibernate;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -5727490558479240033L;
  private Long id;
  private int version;
  private String telType;
  private String telNumber;
  private Contact contact;

  public ContactTelDetail() {}

  public ContactTelDetail(String telType, String telNumber) {
    this.telType = telType;
    this.telNumber = telNumber;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID")
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "CONTACT_ID")
  public Contact getContact() {
    return this.contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }


  @Version
  @Column(name = "VERSION")
  public int getVersion() {
    return this.version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @Column(name = "TEL_TYPE")
  public String getTelType() {
    return this.telType;
  }

  public void setTelType(String telType) {
    this.telType = telType;
  }

  @Column(name = "TEL_NUMBER")
  public String getTelNumber() {
    return this.telNumber;
  }

  public void setTelNumber(String telNumber) {
    this.telNumber = telNumber;
  }

  public String toString() {
    return "Contact Tel Detail - Id: " + id + ", Contact id: " + getContact().getId() + ", Type: "
        + telType + ", Number: " + telNumber;
  }
}
