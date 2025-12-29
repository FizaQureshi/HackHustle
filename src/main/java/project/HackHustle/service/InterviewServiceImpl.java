package project.HackHustle.service;

//import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.HackHustle.dto.InterviewDto;
import project.HackHustle.entity.Interview;
import project.HackHustle.entity.Student;
import project.HackHustle.mapper.InterviewMapper;
import project.HackHustle.repository.InterviewRepository;
import project.HackHustle.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final StudentRepository studentRepository;

    public InterviewServiceImpl(InterviewRepository interviewRepository, StudentRepository studentRepository) {
        this.interviewRepository = interviewRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void saveInterview(InterviewDto interviewDto) {
        Student student = studentRepository.findById(interviewDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Interview interview = InterviewMapper.mapToInterview(interviewDto, student);
        interviewRepository.save(interview);


    }


    @Transactional(readOnly = true)
    @Override
    public List<InterviewDto> getAllInterview(Long id) {
        List<Interview> interviews =
                interviewRepository.findByStudent_StudentId(id);

        return interviews.stream()
                .map(InterviewMapper::mapToInterviewDto)
                .toList();
    }

}
