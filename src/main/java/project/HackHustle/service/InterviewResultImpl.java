package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.InterviewResultDto;
import project.HackHustle.entity.InterviewResult;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.mapper.InterviewResultMapper;
import project.HackHustle.repository.InterviewResultRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InterviewResultImpl implements InterviewResultService{

    private InterviewResultRepository interviewResultRepository;
    @Override
    public void saveInterviewResult(InterviewResultDto interviewResultDto) {
        InterviewResult interviewResult = InterviewResultMapper.mapToInterviewResult(interviewResultDto);
       InterviewResult saved =  interviewResultRepository.save(interviewResult);

    }

    @Override
    public InterviewResultDto getInterview(Long id) {

        InterviewResult interviewResult = interviewResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InterviewResult not found with id: " + id));

        InterviewResultDto interviewResultDto =
                InterviewResultMapper.mapToInterviewResultDto(interviewResult);

      return interviewResultDto;
    }

}
