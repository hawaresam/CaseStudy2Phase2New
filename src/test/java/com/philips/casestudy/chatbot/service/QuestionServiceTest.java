/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.service;

import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class QuestionServiceTest {

  @Test
  public void validateOptions_OptionId_Present() throws IOException
  {

    final Map<String, String> options = Stream.of(new String[][] {
      { "1", "touch" },
      { "2", "nontouch" },
      { "3", "does"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    final QuestionServiceInterface dummyQuestionService=new QuestionService();
    assertFalse(dummyQuestionService.validate(options, "1"));


  }


}
