/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.domain;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;
import org.mockito.Mockito;
import com.philips.casestudy.chatbot.dal.UserInfoInterface;

public class UserInfoDomainTest {

  @Test
  public void addNewUser(){

    final UserInfo newUser=new UserInfo("aashna",new BigInteger("9080706050"),"aashna@yahoo.com","delhi");
    final UserInfoInterface dummyInterface=Mockito.mock(UserInfoInterface.class);

    final UserInfo savedUser=new  UserInfo("aashna",new BigInteger("9080706050"),"aashna@yahoo.com","delhi");
    savedUser.setId(1);

    Mockito.when(dummyInterface.save(newUser)).thenReturn(savedUser);

    final int id=dummyInterface.save(newUser).getId();

    assertEquals(true,id>0);
  }



}
