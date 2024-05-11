package com.acciojob.librarymanagementsystemapril.Controllers;

import com.acciojob.librarymanagementsystemapril.Services.BookService;
import com.acciojob.librarymanagementsystemapril.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
