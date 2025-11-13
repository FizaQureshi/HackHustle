package project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.LoginDto;
import project.HackHustle.dto.TeacherDto;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.service.TeacherService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teachers")
public class TeacherController
{
    private TeacherService teacherService;

    //http://localhost:8080/api/teachers
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto)
    {
        TeacherDto savedTeacher = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/teachers/1001
    @GetMapping("{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id") Long teacherId)
    {
        TeacherDto teacherDto = teacherService.getTeacherById(teacherId);
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }


    //http://localhost:8080/api/teachers
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers()
    {
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("id") Long teacherId, @RequestBody TeacherDto updatedTeacher)
    {
        TeacherDto teacherDto = teacherService.updateTeacher(teacherId,updatedTeacher);
        return ResponseEntity.ok(teacherDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long teacherId)
    {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<Void> loginTeacher(@RequestBody LoginDto loginDto)
    {
        try
        {
            teacherService.loginTeacher(loginDto.getEmailId(), loginDto.getPassword());
            return ResponseEntity.ok().build();         //200 OK -> success
        }
        catch (ResourceNotFoundException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     //404 Not Found
        }
        catch (IllegalArgumentException ex)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();      //401 Unauthorized -> wrong password
        }
    }
}
