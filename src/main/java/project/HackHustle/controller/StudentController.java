package project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.LoginDto;
import project.HackHustle.dto.StudentDto;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.service.StudentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private StudentService studentService;

    //http://localhost:8080/api/students
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto)
    {
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/students/1001
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId)
    {
        StudentDto studentDto = studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }


    //http://localhost:8080/api/students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents()
    {
        List<StudentDto> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    //http://localhost:8080/api/students/1001
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto updatedStudent)
    {
        StudentDto studentDto = studentService.updateStudent(studentId,updatedStudent);
        return ResponseEntity.ok(studentDto);
    }


    //http://localhost:8080/api/students/1004
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId)
    {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }


    //http://localhost:8080/api/students/login
    @PostMapping("/login")
    public ResponseEntity<Void> loginStudent(@RequestBody LoginDto loginDto)
    {
        try
        {
            studentService.loginStudent(loginDto.getEmailId(), loginDto.getPassword());
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

