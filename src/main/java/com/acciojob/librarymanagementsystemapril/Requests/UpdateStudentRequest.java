package com.acciojob.librarymanagementsystemapril.Requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateStudentRequest {
    private Integer studentId;
    private String emailId;
    private String address;
}
