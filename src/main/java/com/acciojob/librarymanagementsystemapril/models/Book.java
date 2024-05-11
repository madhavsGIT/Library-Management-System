package com.acciojob.librarymanagementsystemapril.models;

import com.acciojob.librarymanagementsystemapril.Enum.Genre;
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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    private String bookName;
    private int noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private boolean isIssued;

    @JoinColumn
    @ManyToOne
    private Author author;

}
