package project.HackHustle.service;

import project.HackHustle.dto.SubjectProgressResponseDto;
import project.HackHustle.dto.TopicProgressResponseDto;
import project.HackHustle.dto.SubjectDto;
import java.util.List;

public interface SubjectService {

    List<SubjectDto> getAllSubjects();
    SubjectDto getSubjectById(Long subjectID);
    List<TopicProgressResponseDto> getStudentProgress(String emailId, Long subjectId);
    List<SubjectProgressResponseDto> getAllSubjectsProgress(String emailId);
}
