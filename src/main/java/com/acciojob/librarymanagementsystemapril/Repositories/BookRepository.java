package com.acciojob.librarymanagementsystemapril.Repositories;

import com.acciojob.librarymanagementsystemapril.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
