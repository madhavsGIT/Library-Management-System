package com.acciojob.librarymanagementsystemapril.Services;



import com.acciojob.librarymanagementsystemapril.Enum.CardStatus;
import com.acciojob.librarymanagementsystemapril.Repositories.CardRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.StudentRepository;
import com.acciojob.librarymanagementsystemapril.Requests.UpdateStudentRequest;
import com.acciojob.librarymanagementsystemapril.models.LibraryCard;
import com.acciojob.librarymanagementsystemapril.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CardRepository cardRepository;


    public String addStudent(Student student){
        studentRepository.save(student);
        return "The student has been added to the Db";
    }

    public List<Student> findAllStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentRepository.findAll();
        return studentList;
    }

    public Student findStudent(Integer studentId) throws Exception{
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isEmpty()){
            throw new Exception("student doesn't exist");
        }
        return optionalStudent.get();
    }

    public String updateStudentDetails(UpdateStudentRequest request) throws Exception {

        Student student = findStudent(request.getStudentId());
        //update attributes
        student.setEmailId(request.getEmailId());
        student.setAddress(request.getAddress());
        studentRepository.save(student);

        return "Student details have been updated succesfully";

    }

    public List<Student> studentsWithDeactivatedCardStatus(){

        //get all students
        List<LibraryCard> cardsList = cardRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for(LibraryCard card : cardsList) {
            if(card.getCardStatus().equals(CardStatus.DEACTIVATED)){
                studentList.add(card.getStudent());
            }
        }
        return studentList;
    }

}
