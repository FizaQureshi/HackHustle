package project.HackHustle.service;

import project.HackHustle.dto.StudentDto;

import java.util.List;

public interface StudentService
{
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(String studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long studentId, StudentDto updatedStudent);

    void deleteStudent(Long studentId);

    StudentDto loginStudent(String email, String password);

    StudentDto getStudentByEmail(String email);

}
