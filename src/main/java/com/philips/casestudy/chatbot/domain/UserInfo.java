/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.domain;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  @Column(name="name")
  String name;
  @Column(name = "contact_no")
  BigInteger contactno;
  @Column(name="email")
  String email;
  @Column(name="city")
  String city;

  public UserInfo() {
    super();
  }
  public UserInfo(String name, BigInteger contactno, String email, String city) {
    super();
    this.name = name;
    this.contactno = contactno;
    this.email = email;
    this.city = city;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public BigInteger getcontactno() {
    return contactno;
  }
  public void setcontactno(BigInteger contactno) {
    this.contactno = contactno;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }




}

