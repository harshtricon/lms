package com.example.lms.dto;

import com.example.lms.entity.Author;
import com.example.lms.entity.Publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private int bookid;
    private String title;
    private Author author;
    private Publisher publisher;
}