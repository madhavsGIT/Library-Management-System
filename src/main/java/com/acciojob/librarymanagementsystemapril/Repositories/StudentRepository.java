package com.acciojob.librarymanagementsystemapril.Repositories;

import com.acciojob.librarymanagementsystemapril.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}
