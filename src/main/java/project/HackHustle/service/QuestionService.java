package project.HackHustle.service;

import project.HackHustle.dto.QuestionDto;

import java.util.List;

public interface QuestionService {


   public List<QuestionDto> getQuestionByTopicAssesment(String topicName);
    List<QuestionDto> getQuestionByTopic(String topicName);

    List<QuestionDto> getQuestionBySubject(Long subjectID);
}
