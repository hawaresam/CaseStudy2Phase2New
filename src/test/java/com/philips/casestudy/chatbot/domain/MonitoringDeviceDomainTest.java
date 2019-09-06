/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mockito;
import com.philips.casestudy.chatbot.dal.MonitoringDeviceInterface;

public class MonitoringDeviceDomainTest {

  @Test
  public void addNewMonitoringDevice(){

    final MonitoringDevice newDevice=new MonitoringDevice("GoldmanWay40E","touch",12);
    final MonitoringDeviceInterface dummyInterface=Mockito.mock(MonitoringDeviceInterface.class);

    final MonitoringDevice savedDevice=new  MonitoringDevice("GoldmanWay40E","touch",12);
    savedDevice.setId(1);

    Mockito.when(dummyInterface.save(newDevice)).thenReturn(savedDevice);

    final int id=dummyInterface.save(newDevice).getId();

    assertTrue(id>0);

  }



}
