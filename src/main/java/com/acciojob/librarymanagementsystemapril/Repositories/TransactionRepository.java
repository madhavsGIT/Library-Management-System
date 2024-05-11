package com.acciojob.librarymanagementsystemapril.Repositories;

import com.acciojob.librarymanagementsystemapril.models.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String> {

}
