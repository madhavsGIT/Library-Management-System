package com.acciojob.librarymanagementsystemapril.Repositories;

import com.acciojob.librarymanagementsystemapril.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
