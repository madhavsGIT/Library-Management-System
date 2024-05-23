package com.acciojob.librarymanagementsystemapril.Services;


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
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    public String addAuthor(Author author){
         author = authorRepository.save(author);
         return "This author has been added to Db with authorId "+ author.getAuthorId();
    }

    public Author findAuthorById(int authorId) throws Exception{
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isEmpty()){
            throw new Exception("This authorId is invalid");
        }
        Author author = optionalAuthor.get();
        return author;
    }

    public List<String> findAllAuthors(){
        List<Author> authorList = authorRepository.findAll();
        List<String> authorsNames = new ArrayList<>();
        for(Author author : authorList){
            authorsNames.add(author.getAuthorName());
        }
        return authorsNames;
    }


    public String findAuthorWhoWrittenMaxNoOfBooks(){
        //get all authors
        List<String> authorsNames = findAllAuthors();

        int maxNoOfBook = 0;
        String ansAuthor = "";
        for(String author : authorsNames){
            List<String> bookList = bookService.findAllBooksOfAuthor(author);
            if(bookList.size() > maxNoOfBook){
                maxNoOfBook = bookList.size();
                ansAuthor = author;
            }
        }
        return ansAuthor;
    }

}
