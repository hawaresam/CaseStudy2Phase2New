/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philips.casestudy.chatbot.dal.MonitoringDeviceInterface;
import com.philips.casestudy.chatbot.dal.UserInfoInterface;
import com.philips.casestudy.chatbot.domain.MonitoringDevice;
import com.philips.casestudy.chatbot.dto.MonitoringDeviceDTO;
import com.philips.casestudy.chatbot.dto.UserInfoDTO;

@Service
public class ChatbotService implements ChatBotServiceInterface {

<<<<<<< HEAD

  MonitoringDeviceInterface monitoringDAO;



  public MonitoringDeviceInterface getMonitoringDAO() {
    return monitoringDAO;
  }

  @Autowired
  public void setMonitoringDAO(MonitoringDeviceInterface monitoringDAO) {
    this.monitoringDAO = monitoringDAO;
  }

  public UserInfoInterface getUserInfoDAO() {
    return userInfoDAO;
  }

  @Autowired
  public void setUserInfoDAO(UserInfoInterface userInfoDAO) {
    this.userInfoDAO = userInfoDAO;
  }
=======
  @Autowired
  MonitoringDeviceInterface monitoringDAO;


>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48

  @Autowired
  UserInfoInterface userInfoDAO;

  @Override
  public int save(MonitoringDeviceDTO device) {
    if(monitoringDAO.findByParameters(device.getName(),device.getTouch(),device.getScreenSize()).isEmpty())
    {
      return monitoringDAO.save(device.getName(),device.getTouch(),device.getScreenSize());
    }
    else
    {
      return device.changeDTOToEntity(device).getId();
    }
  }

  @Override
  public List<MonitoringDevice> findAll() {
    return monitoringDAO.findAll();
  }

  @Override
  public List<MonitoringDevice> findByUserChoiceByBothTouchAndScreenSize(String touch, float screenSize) {
    return monitoringDAO.findByUserChoiceByBothTouchAndScreenSize(touch, screenSize);
  }

  @Override
  public List<MonitoringDevice> findByUserChoiceByTouchOnly(String touch) {
    return monitoringDAO.findByUserChoiceOnlyTouch(touch);
  }

  @Override
  public List<MonitoringDevice> findByUserChoiceByScreenSizeOnly(float screenSize) {
    return monitoringDAO.findByUserChoiceOnlyScreenSize(screenSize);
  }

  @Override
  public int saveUsers(UserInfoDTO user) {
    if(userInfoDAO.findByContactno(user.getcontactno()).isEmpty() && userInfoDAO.findByEmail(user.getEmail()).isEmpty())
    {
      return userInfoDAO.save(user.getName(),user.getcontactno(),user.getEmail(),user.getCity());
    }
    else
    {
      return user.changeDTOToEntity(user).getId();
    }
  }


}
