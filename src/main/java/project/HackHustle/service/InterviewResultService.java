package project.HackHustle.service;

import org.springframework.http.ResponseEntity;
import project.HackHustle.dto.InterviewResultDto;

public interface InterviewResultService {

    public void  saveInterviewResult(InterviewResultDto interviewResultDto);

    public InterviewResultDto getInterview(Long id);
}
