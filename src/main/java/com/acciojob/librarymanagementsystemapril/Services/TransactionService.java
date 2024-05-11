package com.acciojob.librarymanagementsystemapril.Services;

import com.acciojob.librarymanagementsystemapril.Enum.CardStatus;
import com.acciojob.librarymanagementsystemapril.Enum.TransactionStatus;
import com.acciojob.librarymanagementsystemapril.Repositories.BookRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.CardRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.TransactionRepository;
import com.acciojob.librarymanagementsystemapril.models.Book;
import com.acciojob.librarymanagementsystemapril.models.LibraryCard;
import com.acciojob.librarymanagementsystemapril.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    public  String issueBook(int cardId, int bookId) throws Exception{
        Optional<LibraryCard> optionalCard = cardRepository.findById(cardId);
        if(optionalCard.isEmpty()){
            throw new Exception("Invalid cardId");
        }

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Invalid bookId");
        }

        Book book = optionalBook.get();
        LibraryCard card = optionalCard.get();

        Transaction transaction = new Transaction();




        if(book.isIssued() == true){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            throw new Exception("book is already issued");
        }
        if(card.getNoOfBooksIssued()==3){
            throw new Exception("Card Book issue Limit is reached");
        }



        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setCard(card);
        transaction.setBook(book);
        book.setIssued(true);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction = transactionRepository.save(transaction);

        cardRepository.save(card);
        bookRepository.save(book);


         return "The transaction is saved with transactionId : "+transaction.getTransactionId();
    }

    public String returnBook(int cardId, int bookId) throws Exception{

        Optional<LibraryCard> optionalCard = cardRepository.findById(cardId);
        if(optionalCard.isEmpty()){
            throw new Exception("Invalid cardId");
        }

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Invalid bookId");
        }

        Book book = optionalBook.get();
        LibraryCard card = optionalCard.get();

        Transaction transaction = new Transaction();
        if(book.isIssued() == false){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            throw new Exception(("This book is not been issued"));
        }
        if(card.getNoOfBooksIssued() == 0){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            throw new Exception(("Nothing to return"));
        }



        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(false);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()-1);

        transaction = transactionRepository.save(transaction);

        cardRepository.save(card);
        bookRepository.save(book);

        return "The transaction is saved with transactionId : "+transaction.getTransactionId();

    }



}
