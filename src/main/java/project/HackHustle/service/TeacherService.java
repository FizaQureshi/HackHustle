package project.HackHustle.service;

import project.HackHustle.dto.TeacherDto;

import java.util.List;

public interface TeacherService
{
    TeacherDto createTeacher(TeacherDto teacherDto);

    TeacherDto getTeacherById(Long teacherId);

    List<TeacherDto> getAllTeachers();

    TeacherDto updateTeacher(Long teacherId, TeacherDto updatedTeacher);

    void deleteTeacher(Long teacherId);

    void loginTeacher(String email, String password);
}
