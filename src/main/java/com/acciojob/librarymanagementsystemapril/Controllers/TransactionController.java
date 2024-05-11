package com.acciojob.librarymanagementsystemapril.Controllers;


import com.acciojob.librarymanagementsystemapril.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PutMapping("issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId")int cardId,
                                    @RequestParam("bookId")int bookId){

        try {
            String result = transactionService.issueBook(bookId,cardId);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId")int cardId,
                                     @RequestParam("bookId")int bookId){
        try {
            String result = transactionService.returnBook(bookId,cardId);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
