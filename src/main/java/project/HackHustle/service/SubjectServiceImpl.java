package project.HackHustle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.SubjectProgressResponseDto;
import project.HackHustle.dto.TopicProgressResponseDto;
import project.HackHustle.dto.SubjectDto;
import project.HackHustle.entity.Student;
import project.HackHustle.entity.Subject;
import project.HackHustle.mapper.SubjectMapper;
import project.HackHustle.repository.StudentRepository;
import project.HackHustle.repository.SubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream()
                .map(SubjectMapper::mapToSubjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto getSubjectById(Long subjectID) {
        Subject subject = subjectRepository.findById(subjectID)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + subjectID));

        return SubjectMapper.mapToSubjectDto(subject);
    }

    public List<TopicProgressResponseDto> getStudentProgress(String emailId, Long subjectId)
    {
        Student student = studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + emailId));

        Long studentId = student.getStudentId();

        List<Object[]> results = subjectRepository.findProgressDataNative(studentId, subjectId);

        // 3. Map Results to DTO with Percentage Logic
        return results.stream().map(result -> {
            long topicId = ((Number) result[0]).longValue();
            long solved = ((Number) result[1]).longValue();
            long total = ((Number) result[2]).longValue();

            double percentage = (total > 0) ? ((double) solved / total) * 100 : 0.0;

            // Rounding to 2 decimal places (e.g., 33.33)
            percentage = Math.round(percentage * 100.0) / 100.0;

            return new TopicProgressResponseDto(
                    topicId,
                    solved,
                    total,
                    percentage
            );
        }).collect(Collectors.toList());
    }


    public List<SubjectProgressResponseDto> getAllSubjectsProgress(String emailId)
    {
        Student student = studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Object[]> results = subjectRepository.findAllSubjectsProgressNative(student.getStudentId());

        return results.stream().map(result -> {
            long solved = ((Number) result[1]).longValue();
            long total = ((Number) result[2]).longValue();

            double percentage = (total > 0) ? (double) solved / total * 100 : 0.0;

            percentage = Math.round(percentage * 100.0) / 100.0;

            return new SubjectProgressResponseDto(
                    ((Number) result[0]).longValue(),
                    solved,
                    total,
                    percentage
            );
        }).collect(Collectors.toList());
    }
}
