/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.chatbot.web;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.philips.casestudy.chatbot.domain.Question;
import com.philips.casestudy.chatbot.service.QuestionServiceInterface;

@RestController
public class QuestionController {

  @Autowired
  QuestionServiceInterface questionService;


  @GetMapping("/api/questions/{index}")
  public ResponseEntity<Question> getQuestionByIndex(@PathVariable("index") int index) throws IOException{
    final Question question=questionService.returnQuestion(index);
    if(question!=null) {
      return new ResponseEntity<>(question,HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

  }

  @GetMapping("/api/questions/{index}/{answer}")
  public ResponseEntity<String> checkIfCorrectOptionIsSelected(@PathVariable("index") int index,@PathVariable("answer") String answer) throws IOException{
<<<<<<< HEAD
    final boolean ifNotOptionPresent=questionService.getOptions(index, answer);
    final HttpHeaders headers=new HttpHeaders();
    headers.add("ErrorMessage","Please enter among the correct options");
    if(!ifNotOptionPresent) {
=======
    final boolean ifOptionPresent=questionService.getOptions(index, answer);
    final HttpHeaders headers=new HttpHeaders();
    headers.add("ErrorMessage","Please enter among the correct options");
    if(!ifOptionPresent) {
>>>>>>> 3be535c0865bb86a4fc0e35f771903a8e94a8f48
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);
  }


}
