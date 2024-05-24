package com.acciojob.librarymanagementsystemapril.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private int age;
    private String branch;
    @Column(unique = true,length = 300)
    private String emailId;
    private String address;

}
