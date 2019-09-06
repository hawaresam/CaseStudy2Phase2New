/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.service;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
=======
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
<<<<<<< HEAD
import org.mockito.Mockito;
import com.philips.casestudy.chatbot.dal.QuestionDAO;
import com.philips.casestudy.chatbot.dal.QuestionDAOInterface;
import com.philips.casestudy.chatbot.domain.Question;
=======
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48

public class QuestionServiceTest {

  @Test
  public void validateOptions_OptionId_Present() throws IOException
  {

<<<<<<< HEAD
    final QuestionServiceInterface service=new QuestionService();
=======
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
    final Map<String, String> options = Stream.of(new String[][] {
      { "1", "touch" },
      { "2", "nontouch" },
      { "3", "does"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

<<<<<<< HEAD
    assertFalse(service.validate(options, "1"));
=======
    final QuestionServiceInterface dummyQuestionService=new QuestionService();
    assertFalse(dummyQuestionService.validate(options, "1"));
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48


  }

<<<<<<< HEAD
  @Test
  public void returnQuestion_When_Question_Present() throws IOException
  {
    final QuestionService service=new QuestionService();



    final QuestionDAOInterface mockdao=Mockito.mock(QuestionDAO.class);

    service.setQuesDao(mockdao);

    final Map<String, String> options = Stream.of(new String[][] {
      { "1", "good" },
      { "2", "fine" },
      { "3", "excellent"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    final Question que=new Question(1,"How are you",options);

    Mockito.when(mockdao.getQuestionByIndex(Mockito.anyInt())).thenReturn(que);

    final Question required=service.returnQuestion(que.getQuestionId());

    assertEquals(que, required);


  }


  @Test
  public void returnQuestion_When_Question_Not_Present() throws IOException
  {
    final QuestionService service=new QuestionService();



    final QuestionDAOInterface mockdao=Mockito.mock(QuestionDAO.class);

    service.setQuesDao(mockdao);

    final Map<String, String> options = Stream.of(new String[][] {
      { "1", "good" },
      { "2", "fine" },
      { "3", "excellent"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    final Question que=new Question(1,"How are you",options);

    Mockito.when(mockdao.getQuestionByIndex(Mockito.anyInt())).thenReturn(null);

    final Question required=service.returnQuestion(que.getQuestionId());

    assertEquals(null, required);

  }
=======

>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
}
