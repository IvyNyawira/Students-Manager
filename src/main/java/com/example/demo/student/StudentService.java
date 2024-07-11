package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Service
public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

//    public List<Student> getStudents() {
////        return List.of(
////                new Student(
////                        1L,
////                        "Ivy",
////                        "ivy.mary@gmail.com",
////                        "2007-2-12",
////                        24
////                )
////        );
//
//    }
    //SEARCHING THROUGH DATABASE TO FIND USED EMAILS
    //Then saving if not throw exception
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email already taken");//go to app properties to show error  msg  always
        }
        studentRepository.save(student);
    }
    //DELETE
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    //PUT
    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with Id" + studentId + " does not exist"
                ));
        if (name != null && name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}
