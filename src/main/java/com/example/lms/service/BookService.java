package com.example.lms.service;

import com.example.lms.dto.BookDTO;
import com.example.lms.dto.BookSaveDTO;
import com.example.lms.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBook();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);
}