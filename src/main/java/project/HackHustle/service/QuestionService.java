package project.HackHustle.service;

import project.HackHustle.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> getQuestionByTopic(String topicName);

    List<QuestionDto> getQuestionBySubject(Long subjectID);
}
