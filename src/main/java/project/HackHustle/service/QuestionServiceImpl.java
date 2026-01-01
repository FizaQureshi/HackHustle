package project.HackHustle.service;

import org.springframework.stereotype.Service;
import project.HackHustle.dto.QuestionDto;
import project.HackHustle.entity.Question;
import project.HackHustle.mapper.QuestionMapper;
import project.HackHustle.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<QuestionDto> getQuestionByTopic(String topicName) {
        List<Question> questions =
                questionRepository.findByTopic_TopicName(topicName);

        return questions.stream()
                .map(QuestionMapper::mapToQuestionDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionDto> getQuestionBySubject(Long subjectID) {
        List<Question> questions =
                questionRepository.findRandom20BySubject(subjectID);


        return questions.stream()
                .map(QuestionMapper::mapToQuestionDto)
                .collect(Collectors.toList());
    }
}
