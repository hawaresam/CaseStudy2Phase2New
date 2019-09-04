/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.dal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import com.philips.casestudy.chatbot.domain.Question;

public class QuestionDAOTest {

  @Test
  public void getRequiredQuestion_QuestionId_Present() throws IOException
  {

    final Question que=new Question();
    que.setQuestionId(1);
    que.setQuestionString("Select anyone of the following options for screen type:");
    final Map<String, String> options = Stream.of(new String[][] {
      { "1", "touch" },
      { "2", "nontouch" },
      { "3", "does"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    que.setOptions(options);

    final List<Question> questionList=new ArrayList<>();
    questionList.add(que);

    final QuestionDAOInterface dummyquestiondao=new QuestionDAO()  ;
    assertNotNull(dummyquestiondao.getRequiredQuestion(questionList,1));


  }


  @Test
  public void getRequiredQuestion_QuestionId_Not_Present() throws IOException
  {


    final Question que=new Question();
    que.setQuestionId(1);
    que.setQuestionString("Select anyone of the following options for screen type:");
    final Map<String, String> options = Stream.of(new String[][] {
      { "1", "touch" },
      { "2", "nontouch" },
      { "3", "does"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    que.setOptions(options);

    final List<Question> questionList=new ArrayList<>();
    questionList.add(que);

    final QuestionDAOInterface dummyQuestionDao=new QuestionDAO()  ;
    assertNull(dummyQuestionDao.getRequiredQuestion(questionList,5));


  }


  @Test
  public void readJSONForQuestions_When_Path_Is_Correct_Read_Success() throws IOException {

    final QuestionDAOInterface dummyQuestionDAO=new QuestionDAO();
    final String path="C:/Users/320065420/BootCamp/ChatBot phase1-4.2(Input validation)/ChatBot/src/main/resources/question.txt";
    final byte[] file=dummyQuestionDAO.readJSONForQuestions(path);
    assertTrue(file.length>0);

  }


}
