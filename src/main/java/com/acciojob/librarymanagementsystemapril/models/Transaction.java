package com.acciojob.librarymanagementsystemapril.models;

import com.acciojob.librarymanagementsystemapril.Enum.TransactionStatus;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Timestamp
    private Date issueDate;

    private Date returnDate;
    private double fineAmount;

    @JoinColumn
    @ManyToOne
    private LibraryCard card;

    @JoinColumn
    @ManyToOne
    private Book book;



}
