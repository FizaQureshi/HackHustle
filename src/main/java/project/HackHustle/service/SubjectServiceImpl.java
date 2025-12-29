package project.HackHustle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.SubjectDto;
import project.HackHustle.entity.Subject;
import project.HackHustle.mapper.SubjectMapper;
import project.HackHustle.repository.SubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

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
}
