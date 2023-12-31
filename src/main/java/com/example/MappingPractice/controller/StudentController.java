package com.example.MappingPractice.controller;

import com.example.MappingPractice.model.Student;
import com.example.MappingPractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("student")
    public Iterable<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }

    @PutMapping("student/update/of")
    public String updateStudent(@RequestParam("studentId") Long studentId,@RequestParam("studentAge") String studentAge){
        return studentService.updateStudentAge(studentId,studentAge);
    }

    @DeleteMapping("student/delete/of")
    public String deleteStudent(@RequestParam("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }
}