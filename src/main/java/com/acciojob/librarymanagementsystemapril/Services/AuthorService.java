package com.acciojob.librarymanagementsystemapril.Services;


import com.acciojob.librarymanagementsystemapril.Repositories.AuthorRepository;
import com.acciojob.librarymanagementsystemapril.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

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

}
