package com.acciojob.librarymanagementsystemapril.Services;



import com.acciojob.librarymanagementsystemapril.Repositories.StudentRepository;
import com.acciojob.librarymanagementsystemapril.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student Student){
        studentRepository.save(Student);
        return "The student has been added to the Db";
    }

    public List<Student> findAllStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentRepository.findAll();
        return studentList;
    }
}
