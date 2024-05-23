package com.acciojob.librarymanagementsystemapril.Controllers;

import com.acciojob.librarymanagementsystemapril.Requests.UpdateStudentRequest;
import com.acciojob.librarymanagementsystemapril.Services.StudentService;

import com.acciojob.librarymanagementsystemapril.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("student")
@RestController
public class studentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student Student){
            String res = studentService.addStudent(Student);
            return res;
    }
    @GetMapping("findAllStudents")
    public List<Student> findAllStudents(){
        List<Student> studentsList = new ArrayList<>();
        studentsList = studentService.findAllStudents();

        return studentsList;
    }

    @GetMapping("get-student-info")
    public ResponseEntity getStudent(@RequestParam("studentId") Integer studentId){
        try{
            Student student = studentService.findStudent(studentId);
            return new ResponseEntity(student, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("update-student-details")
    public ResponseEntity updateStudentInfo(UpdateStudentRequest updateStudentRequest){
        try{
            String response = studentService.updateStudentDetails(updateStudentRequest);
            return new ResponseEntity( response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
