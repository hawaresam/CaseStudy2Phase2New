/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.dal;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.philips.casestudy.chatbot.domain.Question;


public interface QuestionDAOInterface {

  Question getQuestionByIndex(int index) throws IOException;

<<<<<<< HEAD
=======
  void createQuestion() throws IOException;

>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
  Question getRequiredQuestion(List<Question> questionList,int index);

  public Map<String,String> getOptions(int index,String answer) throws IOException;

<<<<<<< HEAD
=======

>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
  public byte[] readJSONForQuestions(String path) throws IOException;

}
