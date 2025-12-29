package project.HackHustle.service;

import project.HackHustle.dto.SubjectDto;
import java.util.List;

public interface SubjectService {

    List<SubjectDto> getAllSubjects();
    SubjectDto getSubjectById(Long subjectID);
}
