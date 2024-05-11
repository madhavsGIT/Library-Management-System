package com.acciojob.librarymanagementsystemapril.models;

import com.acciojob.librarymanagementsystemapril.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    private int noOfBooksIssued;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @JoinColumn
    @OneToOne
    private Student student;
}
