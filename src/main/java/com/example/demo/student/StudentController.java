package com.example.demo.student;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/student")
@CrossOrigin
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired //DEPENDENCY INJECTION
    public StudentController studentController(StudentService studentService){
        this.studentService = studentService;
        return null;
    }


    @GetMapping//MAPPING STUDENT TO DB
    public List<Student> getAllStudents(){
        return studentService.getStudents();
    }
    //POST
    @PostMapping
    public void registerNewStudent(
            @RequestBody
            Student student){
        studentService.addNewStudent(student);
    }
    //DELETE
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    //PUT
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}



