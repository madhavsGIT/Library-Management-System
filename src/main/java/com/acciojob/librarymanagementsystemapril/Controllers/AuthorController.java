package com.acciojob.librarymanagementsystemapril.Controllers;

import com.acciojob.librarymanagementsystemapril.Services.AuthorService;
import com.acciojob.librarymanagementsystemapril.models.Author;
import com.acciojob.librarymanagementsystemapril.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @GetMapping("find-author-by-Id")
    public ResponseEntity findAuthorById(@RequestParam("id")int authorId){
        try
        {
            Author author = authorService.findAuthorById(authorId);
            return new ResponseEntity(author, HttpStatus.OK);
        }
        catch( Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find-all-authors")
    public List<String> getAllAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping("author-written-maxNoOfBooks")
    public String getAuthorWrittenMaxNoOfBooks(){
        return authorService.findAuthorWhoWrittenMaxNoOfBooks();
    }


}
