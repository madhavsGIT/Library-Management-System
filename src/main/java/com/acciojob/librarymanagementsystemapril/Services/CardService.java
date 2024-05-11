package com.acciojob.librarymanagementsystemapril.Services;

import com.acciojob.librarymanagementsystemapril.Enum.CardStatus;
import com.acciojob.librarymanagementsystemapril.Repositories.CardRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.StudentRepository;
import com.acciojob.librarymanagementsystemapril.models.LibraryCard;
import com.acciojob.librarymanagementsystemapril.models.Student;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

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

        cardRepository.save(card);

        return "Associating card and student with cardId "+cardId +" and studentId "+studentId;



    }

}
