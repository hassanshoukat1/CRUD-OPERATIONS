package com.mongospring.mongospring.Controller;

import com.mongospring.mongospring.Repositry.Studentrepo;
import com.mongospring.mongospring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Maincontroller {

@Autowired
    Studentrepo studentrepo;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
studentrepo.save(student);
    }

    @GetMapping("/fetchStudents")
    public List<Student> fetchStudents() {
return studentrepo.findAll();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id) {
       return studentrepo.findById(id).orElse(null);
    }

    @PutMapping ("/updateStudent")
    public void updateStudent(@RequestBody Student student) {
Student data=studentrepo.findById(student.getRno()).orElse(null);
System.out.println(data);
if (data!=null){
    data.setName(student.getName());
     data.setAddress(student.getAddress());
     studentrepo.save(data);
}
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentrepo.deleteById(id);
    }

}
