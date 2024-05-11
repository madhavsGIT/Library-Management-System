package com.acciojob.librarymanagementsystemapril.Repositories;

import com.acciojob.librarymanagementsystemapril.models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard, Integer> {


}
