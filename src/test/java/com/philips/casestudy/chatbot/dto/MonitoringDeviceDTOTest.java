/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.dto;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
=======
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.philips.casestudy.chatbot.domain.MonitoringDevice;

public class MonitoringDeviceDTOTest {

  @Test
  public void when_Convert_MonitoringDto_To_MonitoringEntity_thenCorrect() {

    final MonitoringDeviceDTO monitoringDto = new MonitoringDeviceDTO();

    monitoringDto.setName("GoldwayMan40E");
    monitoringDto.setTouch("touch");
    monitoringDto.setScreenSize(10);
    final MonitoringDevice saveddevice=monitoringDto.changeDTOToEntity(monitoringDto);

    assertTrue(saveddevice.getName().equals(monitoringDto.getName()));
    assertTrue(saveddevice.getTouch().equals(monitoringDto.getTouch()));
<<<<<<< HEAD
    assertEquals(saveddevice.getScreenSize(),monitoringDto.getScreenSize(),0.00);
=======
    assertTrue(saveddevice.getScreenSize()==monitoringDto.getScreenSize());
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48



  }

}
