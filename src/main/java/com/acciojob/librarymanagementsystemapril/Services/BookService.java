package com.acciojob.librarymanagementsystemapril.Services;


import com.acciojob.librarymanagementsystemapril.Repositories.AuthorRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.BookRepository;
import com.acciojob.librarymanagementsystemapril.models.Author;
import com.acciojob.librarymanagementsystemapril.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book){
         book = bookRepository.save(book);
         return "This book has been added to Db with bookId "+book.getBookId();
    }

    public String associateBookAndAuthor(Integer bookId, Integer authorId) throws Exception{
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()){
            throw new Exception("The bookId is invalid");
        }
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isEmpty()){
            throw new Exception("The authorId is invalid");
        }

        Book book = optionalBook.get();
        Author author = optionalAuthor.get();

        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks() + 1);

        bookRepository.save(book);
        authorRepository.save(author);

        return "Book and Author have been asscociated";

    }


}
