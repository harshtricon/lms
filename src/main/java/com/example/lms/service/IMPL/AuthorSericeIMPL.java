package com.example.lms.service.IMPL;

import com.example.lms.dto.AuthorSaveDTO;
import com.example.lms.entity.Author;
import com.example.lms.repo.AuthorRepo;
import com.example.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorSericeIMPL implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;


    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(
                authorSaveDTO.getName()
        );
        authorRepo.save(author);
        return author.getName();

    }
}
