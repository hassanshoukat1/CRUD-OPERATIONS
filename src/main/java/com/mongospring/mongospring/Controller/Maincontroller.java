package com.mongospring.mongospring.Controller;

import com.mongospring.mongospring.Repositry.StudentRepository;
import com.mongospring.mongospring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students") // Added base path for better API structure
public class Maincontroller {

    @Autowired
    StudentRepository studentRepository; // Updated repository name to follow naming conventions

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @GetMapping("/all")
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        Student data = studentRepository.findById(student.getRno()).orElse(null);
        System.out.println(data);
        if (data != null) {
            data.setName(student.getName());
            data.setAddress(student.getAddress());
            studentRepository.save(data);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentRepository.deleteById(id);
    }
}
