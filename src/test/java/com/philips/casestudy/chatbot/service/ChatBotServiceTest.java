/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.service;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import com.philips.casestudy.chatbot.dal.MonitoringDeviceInterface;
import com.philips.casestudy.chatbot.dal.UserInfoInterface;
import com.philips.casestudy.chatbot.domain.MonitoringDevice;
import com.philips.casestudy.chatbot.domain.UserInfo;
import com.philips.casestudy.chatbot.dto.MonitoringDeviceDTO;
import com.philips.casestudy.chatbot.dto.UserInfoDTO;

public class ChatBotServiceTest {


  @Test
  public void save_Monitoring_Device_When_Same_Parameters_Not_Present(){

    final ChatbotService service=new ChatbotService();

    final MonitoringDeviceInterface mockDao=Mockito.mock(MonitoringDeviceInterface.class);

    service.setMonitoringDAO(mockDao);

    final MonitoringDeviceDTO mockDeviceDto=new MonitoringDeviceDTO("GoldwayMan40E","touch",10);
    mockDeviceDto.setId(1);

    final List<MonitoringDevice> devices=new ArrayList<>();

    Mockito.when(mockDao.findByParameters(mockDeviceDto.getName(), mockDeviceDto.getTouch(), mockDeviceDto.getScreenSize())).thenReturn(devices);
    Mockito.when(mockDao.save(mockDeviceDto.getName(), mockDeviceDto.getTouch(), mockDeviceDto.getScreenSize())).thenReturn(mockDeviceDto.getId());

    final int id=service.save(mockDeviceDto);

    assertEquals(mockDeviceDto.getId(),id);

  }

  @Test
  public void save_Monitoring_Device_When_Same_Parameters_Present(){
    final ChatbotService service=new ChatbotService();

    final MonitoringDeviceInterface mockDao=Mockito.mock(MonitoringDeviceInterface.class);

    service.setMonitoringDAO(mockDao);

    final MonitoringDeviceDTO mockDeviceDto=new MonitoringDeviceDTO("GoldwayMan40E","touch",10);

    final MonitoringDevice mockDevice=new MonitoringDevice("GoldwayMan40E","touch",10);
    mockDevice.setId(1);

    final List<MonitoringDevice> devices=new ArrayList<>();
    devices.add(mockDevice);

    Mockito.when(mockDao.findByParameters(mockDeviceDto.getName(), mockDeviceDto.getTouch(), mockDeviceDto.getScreenSize())).thenReturn(devices);

    final int id=service.save(mockDeviceDto);

    assertEquals(mockDeviceDto.getId(),id);

  }


  @Test
  public void saveUsers_When_Same_Contact_And_Same_Email(){

    final ChatbotService service=new ChatbotService();

    final UserInfoInterface mockDao=Mockito.mock(UserInfoInterface.class);

    service.setUserInfoDAO(mockDao);

    final UserInfoDTO mockUserDto=new UserInfoDTO("Abc",new BigInteger("1122334455"),"abc@gmail.com","abc");
    mockUserDto.setId(1);

    final UserInfo mockUser=new UserInfo("Abc",new BigInteger("1122334455"),"abc@gmail.com","abc");
    mockUser.setId(1);

    final List<UserInfo> users=new ArrayList<>();
    users.add(mockUser);

    Mockito.when(mockDao.findByContactno(BigInteger.valueOf(Mockito.anyLong()))).thenReturn(users);
    Mockito.when(mockDao.findByEmail(Mockito.anyString())).thenReturn(users);
    //Mockito.when(mockDao.save(Mockito.anyString(),BigInteger.valueOf(Mockito.anyLong()), Mockito.anyString(), Mockito.anyString())).thenReturn(mockUserDto.getId());
    final int id=service.saveUsers(mockUserDto);
    assertEquals(mockUserDto.getId(),id);
  }

  @Test
  public void saveUsers_When_Different_Contact_Or_Different_Email(){

    final ChatbotService service=new ChatbotService();

    final UserInfoInterface mockDao=Mockito.mock(UserInfoInterface.class);

    service.setUserInfoDAO(mockDao);

    final UserInfoDTO mockUserDto=new UserInfoDTO("Abc",new BigInteger("1122334455"),"abc@gmail.com","abc");
    mockUserDto.setId(1);

    //    final UserInfo mockUser=new UserInfo("Abc",new BigInteger("1122334455"),"abc@gmail.com","abc");
    //    mockUser.setId(1);

    final List<UserInfo> users=new ArrayList<>();
    //users.add(mockUser);

    Mockito.when(mockDao.findByContactno(BigInteger.valueOf(Mockito.anyLong()))).thenReturn(users);
    Mockito.when(mockDao.findByEmail(Mockito.anyString())).thenReturn(users);
    Mockito.when(mockDao.save(Mockito.anyString(),BigInteger.valueOf(Mockito.anyLong()), Mockito.anyString(), Mockito.anyString())).thenReturn(mockUserDto.getId());
    final int id=service.saveUsers(mockUserDto);
    assertEquals(mockUserDto.getId(),id);

  }


}


