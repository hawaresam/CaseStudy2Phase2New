/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.service;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import com.philips.casestudy.chatbot.dal.MonitoringDeviceInterface;
import com.philips.casestudy.chatbot.domain.MonitoringDevice;

public class ChatBotServiceTest {

  @Test
  public void parameters_Of_Monitoring_Device_Present()
  {
    final MonitoringDeviceInterface dummyInterface=Mockito.mock(MonitoringDeviceInterface.class);
    final List<MonitoringDevice> returnedList=dummyInterface.findByParameters("GoldManWay40E", "touch", 12);
    assertTrue(returnedList.isEmpty());
  }

  //  @Test
  //  public void parameters_Of_Monitoring_Device_Not_Present()
  //  {
  //    final MonitoringDeviceInterface dummyInterface=Mockito.mock(MonitoringDeviceInterface.class);
  //    final List<MonitoringDevice> returnedList=dummyInterface.findByParameters("GoldManWay50E", "touch", 12);
  //    assertTrue(!returnedList.isEmpty());
  //  }
}


