package com.acciojob.librarymanagementsystemapril.Services;


import com.acciojob.librarymanagementsystemapril.Enum.Genre;
import com.acciojob.librarymanagementsystemapril.Repositories.AuthorRepository;
import com.acciojob.librarymanagementsystemapril.Repositories.BookRepository;
import com.acciojob.librarymanagementsystemapril.models.Author;
import com.acciojob.librarymanagementsystemapril.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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



    public List<String> findAllBooksOfAuthor(String authorName){
        List<Book> bookList = bookRepository.findAll();
        List<String> ansBookList = new ArrayList<>();
        for(Book book : bookList){

            if(book.getAuthor().getAuthorName().equals(authorName)){
                ansBookList.add(book.getBookName());
            }
        }

        return ansBookList;
    }

    public Book recommendBook(Genre genre) {
        //get books list
        List<Book> bookList = bookRepository.findAll();

        //get books of input genre
        List<Book> ansBookList = new ArrayList<>();

        for(Book book : bookList) {
            if(book.getGenre().equals(genre)){
                ansBookList.add(book);
            }
        }

        //get book of highest rating
        double maxRating = 0.0;
        Book answerBook = null;
        for(Book book : ansBookList){
            if(book.getRating() > maxRating){
                maxRating = book.getRating();
                answerBook = book;
            }
        }
        return answerBook;
    }

}
