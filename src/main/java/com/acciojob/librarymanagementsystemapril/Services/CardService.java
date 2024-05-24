package com.acciojob.librarymanagementsystemapril.Services;

import com.acciojob.librarymanagementsystemapril.Enum.CardStatus;
import com.acciojob.librarymanagementsystemapril.Repositories.CardRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.StudentRepository;
import com.acciojob.librarymanagementsystemapril.models.LibraryCard;
import com.acciojob.librarymanagementsystemapril.models.Student;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addCard(){
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.NEW);
        card.setNoOfBooksIssued(0);
        card = cardRepository.save(card);
        return "This card has been added to Db with cardId "+card.getCardId();
    }

    public String associateCardWithStudent(int cardId, int studentId) {


        LibraryCard card = cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();

        card.setStudent(student);
        card.setCardStatus(CardStatus.ACTIVE);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(student.getEmailId());
        mailMessage.setFrom("kmadhav455@gmail.com");
        mailMessage.setSubject("Welcome to library Services");

        String body = "hello "+student.getName() + "\n" +
                "your library card is activated"+ "\n" +
                "make good use of library services";
        mailMessage.setText(body);

        javaMailSender.send(mailMessage);

        cardRepository.save(card);

        return "Associating card and student with cardId "+cardId +" and studentId "+studentId;



    }

}
