package com.acciojob.librarymanagementsystemapril.models;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "author_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;
    private int age;
    private int noOfBooks;
    private double rating;
}
