package com.acciojob.librarymanagementsystemapril.Controllers;

import com.acciojob.librarymanagementsystemapril.Services.CardService;
import com.acciojob.librarymanagementsystemapril.models.LibraryCard;
import com.acciojob.librarymanagementsystemapril.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("add")
    public String addCard(){
        return cardService.addCard();
    }

    @PutMapping("associateCardWithStudent")
    public String associateCardWithStudent(@RequestParam("cardId")int cardId,
                                           @RequestParam("studentId") int studentId){
        return cardService.associateCardWithStudent(cardId, studentId);
    }
}
