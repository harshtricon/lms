package com.example.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowUpdateDTO {
private int id;
    private int book_id;
    private int user_id;
    private LocalDate borrow_date;
    private LocalDate return_date;

}
