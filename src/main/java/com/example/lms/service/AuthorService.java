package com.example.lms.service;

import com.example.lms.dto.AuthorDTO;
import com.example.lms.dto.AuthorSaveDTO;
import com.example.lms.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {
    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<AuthorDTO> getAllAuthor();

    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);

    String deleteAuthor(int id);
}
