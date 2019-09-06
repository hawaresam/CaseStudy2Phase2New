/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.dal;

import java.io.IOException;
<<<<<<< HEAD
import java.nio.file.Files;
import java.nio.file.Paths;
=======
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.databind.SerializationFeature;
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
import com.philips.casestudy.chatbot.domain.Question;

@Repository
public class QuestionDAO implements QuestionDAOInterface {

  private static String path;
  static
  {
<<<<<<< HEAD
    staticInit();
  }

  protected static void staticInit()
  {
=======
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
    try {
      final ResourceBundle props=ResourceBundle.getBundle("questionpath");
      path=props.getString("path");
    }
    catch(final Exception e)
    {
      e.getMessage();
    }
  }
  @Override
  public byte[] readJSONForQuestions(String path) throws IOException
  {
    return Files.readAllBytes(Paths.get(path));
  }


  @Override
  public Question getQuestionByIndex(int index) throws IOException {

    final ObjectMapper objectMapper = new ObjectMapper();
    final byte[] jsonData =readJSONForQuestions(path);
    final List<Question> questionList = objectMapper.readValue(jsonData, new TypeReference<List<Question>>(){});
    return getRequiredQuestion(questionList,index);
  }


  @Override
<<<<<<< HEAD
=======
  public void createQuestion() throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();

    final Question newQue = new Question();
    newQue.setQuestionString("New Question");
    newQue.setQuestionId(4);

    final Map<String, String> options = new HashMap<>();
    options.put("1", "Option 1");
    options.put("2", "Option 2");
    newQue.setOptions(options);
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    final StringWriter stringQuestion = new StringWriter();
    objectMapper.writeValue(stringQuestion, newQue);


  }

  @Override
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
  public Question getRequiredQuestion(List<Question> questionList,int index)
  {
    final List<Question> requiredQuestionList=questionList.stream().filter(item -> item.getQuestionId()==index).collect(Collectors.toList());
    if(!requiredQuestionList.isEmpty()) {
      return requiredQuestionList.get(0);
    }
    else {
      return null;
    }

  }

  @Override
  public Map<String,String> getOptions(int index,String answer) throws IOException
  {
    final Question que=getQuestionByIndex(index);
    return que.getOptions();
  }


}
