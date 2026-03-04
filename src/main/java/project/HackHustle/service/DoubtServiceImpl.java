package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.DoubtDto;
import project.HackHustle.entity.Doubt;
import project.HackHustle.entity.Student;
import project.HackHustle.entity.Teacher;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.mapper.DoubtMapper;
import project.HackHustle.repository.DoubtRepository;
import project.HackHustle.repository.StudentRepository;
import project.HackHustle.repository.TeacherRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class DoubtServiceImpl implements DoubtService {

    private DoubtRepository doubtRepository;
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    @Override
    public DoubtDto saveDoubt(DoubtDto doubtDto)
    {
        Doubt doubt = DoubtMapper.mapToDoubt(doubtDto);
        Doubt savedDoubt = doubtRepository.save(doubt);

        return DoubtMapper.mapToDoubtDto(savedDoubt);

//        Student student = studentRepository.findById(doubtDto.getStudentId())
//                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
//
//
//        Teacher teacher = teacherRepository
//                .findBySubjectAssociated(question.getSubject())  // adjust if needed
//                .orElseThrow(() -> new ResourceNotFoundException("No teacher found"));
//
//        Doubt doubt = new Doubt();
//        doubt.setQueryAsked(doubtDto.getQueryAsked());
//        doubt.setStudent(student);
//        doubt.setTeacher(teacher);
//
//        doubt.setDoubtStatus("Pending");
//        doubt.setAnswerProvided("None");
//
//        Doubt saved = doubtRepository.save(doubt);
//
//        return DoubtMapper.mapToDoubtDto(saved);
    }

//    @Override
//    public DoubtDto updateDoubt(DoubtDto doubtDto)
//    {
//        Doubt doubt = doubtRepository.findById(doubtDto.getDoubtID()).orElseThrow(
//                () -> new ResourceNotFoundException("Student does not exist with given id " + doubtDto.getDoubtID()));
//
//        doubt.setDoubtStatus(doubtDto.getDoubtStatus());
//        doubt.setAnswerProvided(doubtDto.getAnswerProvided());
//        doubtRepository.save(doubt);
//
//        return DoubtMapper.mapToDoubtDto(doubt);
//    }

    // project.HackHustle.service.DoubtServiceImpl
    @Override
    public DoubtDto updateDoubt(DoubtDto doubtDto) {
        Doubt doubt = doubtRepository.findById(doubtDto.getDoubtID()).orElseThrow(
                () -> new ResourceNotFoundException("Doubt does not exist with given id " + doubtDto.getDoubtID()));

        doubt.setAnswerProvided(doubtDto.getAnswerProvided());

        // LOGIC: If an answer is provided, set status to Resolved
        if (doubtDto.getAnswerProvided() != null && !doubtDto.getAnswerProvided().isEmpty()) {
            doubt.setDoubtStatus("Resolved");
        } else {
            doubt.setDoubtStatus(doubtDto.getDoubtStatus());
        }

        doubtRepository.save(doubt);
        return DoubtMapper.mapToDoubtDto(doubt);
    }


    @Override
    public void deleteDoubt(Long doubtID)
    {
        Doubt doubt = doubtRepository.findById(doubtID)
                .orElseThrow(() -> new ResourceNotFoundException("Doubt not found with ID: " + doubtID));

        doubtRepository.delete(doubt);
    }

    @Override
    public List<DoubtDto> teacherDoubtList(Long teacherID)
    {
//        List<Doubt> teacherList = doubtRepository.findAll().stream()
//                .filter(d -> d.getTeacher() != null && d.getTeacher().getTeacherID().equals(teacherID))
//                .toList();
//
//        if (teacherList.isEmpty())
//        {
//                throw new ResourceNotFoundException("No doubts found for teacher ID: " + teacherID);
//        }
        List<Doubt> teacherList =
                doubtRepository.findByTeacher_TeacherIDAndDoubtStatus(teacherID, "Pending");


        return teacherList.stream().map(DoubtMapper::mapToDoubtDto).toList();
    }

    @Override
    public List<DoubtDto> studentDoubtList(Long studentId)
    {
        List<Doubt> studentList = doubtRepository.findByStudent_StudentId(studentId);

        if (studentList.isEmpty())
        {
            throw new ResourceNotFoundException("No doubts found for student ID: " + studentId);
        }
        return studentList.stream().map(DoubtMapper::mapToDoubtDto).toList();
    }

    @Override
    public DoubtDto createDoubt(DoubtDto doubtDto) {

        Student student = studentRepository.findById(doubtDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Teacher teacher = teacherRepository
                .findBySubjectAssociated(doubtDto.getSelectedSubject())
                .orElseThrow(() -> new ResourceNotFoundException("No teacher found for this subject"));

        Doubt doubt = new Doubt();
        doubt.setQueryAsked(doubtDto.getQueryAsked());
        doubt.setStudent(student);
        doubt.setTeacher(teacher);
        doubt.setSelectedSubject(doubtDto.getSelectedSubject());

        Doubt saved = doubtRepository.save(doubt);

        return DoubtMapper.mapToDoubtDto(saved);
    }


    @Override
    public List<DoubtDto> teacherResolvedDoubtList(Long teacherID) {
        List<Doubt> resolvedList =
                doubtRepository.findByTeacher_TeacherIDAndDoubtStatus(teacherID, "Resolved");
        return resolvedList.stream().map(DoubtMapper::mapToDoubtDto).toList();
    }

}


