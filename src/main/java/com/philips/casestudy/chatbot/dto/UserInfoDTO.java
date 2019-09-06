/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.dto;

import java.math.BigInteger;
import org.modelmapper.ModelMapper;
import com.philips.casestudy.chatbot.domain.UserInfo;

public class UserInfoDTO {
  String name;
  BigInteger contactno;
  String email;
  String city;
  int id;

  public UserInfoDTO()
  {

  }

  public UserInfoDTO(UserInfo user)
  {
    this(user.getName(),user.getcontactno(),user.getEmail(),user.getCity());
  }

  public UserInfoDTO(String name,BigInteger contactno,String email, String city)
  {
    this.name = name;
    this.contactno = contactno;
    this.email = email;
    this.city = city;
    //this.id=id;
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

  public UserInfo changeDTOToEntity(UserInfoDTO user)
  {
    final ModelMapper model=new ModelMapper();
    return model.map(user,UserInfo.class);

  }
}
