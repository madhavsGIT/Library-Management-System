package com.acciojob.librarymanagementsystemapril.Controllers;

import com.acciojob.librarymanagementsystemapril.Services.StudentService;

import com.acciojob.librarymanagementsystemapril.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("student")
@RestController
public class studentController {
    @Autowired
    private StudentService stu_service;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student Student){
            String res = stu_service.addStudent(Student);
            return res;
    }
    @GetMapping("findAllStudents")
    public List<Student> findAllStudents(){
        List<Student> studentsList = new ArrayList<>();
        studentsList = stu_service.findAllStudents();

        return studentsList;
    }
}
