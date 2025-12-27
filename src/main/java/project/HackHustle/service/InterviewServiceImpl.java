package project.HackHustle.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.InterviewDto;
import project.HackHustle.entity.Interview;
import project.HackHustle.mapper.InterviewMapper;
import project.HackHustle.repository.InterviewRepository;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

   private  InterviewRepository interviewRepository;


    @Override
    public void saveInterview(InterviewDto interviewDto) {
        Interview interview = InterviewMapper.mapToInterview(interviewDto);
        Interview savedInterview = interviewRepository.save(interview);
    }


    @Override
    public List<InterviewDto> getAllInterview(Long id) {

        List<Interview> interviews = interviewRepository.findByStudentID(id);

        return interviews.stream()
                .map(InterviewMapper::mapToInterviewDto)
                .toList();
    }

}
