package project.HackHustle.service;

import org.springframework.stereotype.Service;
import project.HackHustle.dto.QuestionStatusDto;
import project.HackHustle.entity.QuestionStatus;
import project.HackHustle.entity.QuestionStatusKey;
import project.HackHustle.mapper.QuestionStatusMapper;
import project.HackHustle.repository.QuestionRepository;
import project.HackHustle.repository.QuestionStatusRepository;

@Service
public class QuestionStatusServiceImpl  implements QuestionStatusService{

  QuestionStatusRepository questionStatusRepository;

    @Override
    public void saveStatus(QuestionStatusDto questionStatusDto) {

        QuestionStatus questionStatus = QuestionStatusMapper.maptoQuestionStatus(questionStatusDto);
       QuestionStatus saved =  questionStatusRepository.save(questionStatus);
    }
}
