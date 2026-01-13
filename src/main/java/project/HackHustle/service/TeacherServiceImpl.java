package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.TeacherDto;
import project.HackHustle.entity.Teacher;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.mapper.TeacherMapper;
import project.HackHustle.repository.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService
{
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto)
    {
        Teacher teacher = TeacherMapper.mapToTeacher(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.mapToTeacherDto(savedTeacher);
    }

    @Override
    public TeacherDto getTeacherById(Long teacherId)
    {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        return TeacherMapper.mapToTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllTeachers()
    {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(TeacherMapper::mapToTeacherDto).collect(Collectors.toList());
    }


    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto updatedTeacher)
    {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new ResourceNotFoundException("Teacher does not exist with given id " + teacherId));

        teacher.setFirstName(updatedTeacher.getFirstName());
        teacher.setLastName(updatedTeacher.getLastName());
        teacher.setEmailId(updatedTeacher.getEmailId());
        teacher.setPassword(updatedTeacher.getPassword());
        teacher.setRating(updatedTeacher.getRating());
        teacher.setSubjectAssociated(updatedTeacher.getSubjectAssociated());
        teacher.setInstitute(updatedTeacher.getInstitute());
        teacher.setDepartment(updatedTeacher.getDepartment());
        teacher.setDesignation(updatedTeacher.getDesignation());
        teacher.setExperience(updatedTeacher.getExperience());
        teacher.setContact(updatedTeacher.getContact());

        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.mapToTeacherDto(savedTeacher);
    }

    @Override
    public void deleteTeacher(Long teacherId)
    {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new ResourceNotFoundException("Teacher does not exist with given id " + teacherId));

        teacherRepository.deleteById(teacherId);
    }

    @Override
    public void loginTeacher(String email, String password)
    {
        // Check if email exists
        Teacher teacher = teacherRepository.findByEmailId(email)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with email: " + email));

        // Check password match
        if (!teacher.getPassword().equals(password)) {
            throw new IllegalArgumentException("Incorrect password");
        }

        // Successful login — do nothing, just return
    }
}
