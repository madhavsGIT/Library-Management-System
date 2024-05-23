package com.acciojob.librarymanagementsystemapril.Controllers;

import com.acciojob.librarymanagementsystemapril.Enum.Genre;
import com.acciojob.librarymanagementsystemapril.Services.BookService;
import com.acciojob.librarymanagementsystemapril.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){

        return bookService.addBook(book);

    }

    @PutMapping("/associate-book-author")
    public ResponseEntity associateBookAndAuthor(@RequestParam("bookId") int bookId,
                                                 @RequestParam("authorId") int authorId)
    {
        try
        {
            String response = bookService.associateBookAndAuthor(bookId, authorId);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //find all books of perticular author
    @GetMapping("find-all-books-of-author")
    public ResponseEntity findAllBookOfAuthor(@RequestParam("authorName") String authorName){
        List<String> bookList = bookService.findAllBooksOfAuthor(authorName);
        return new ResponseEntity(bookList, HttpStatus.OK);
    }

    @GetMapping("recommend-highest-rated-type-genre")
    public Book recommendBookByGenreOfHighestRating(Genre genre){
        return bookService.recommendBook(genre);
    }


}
