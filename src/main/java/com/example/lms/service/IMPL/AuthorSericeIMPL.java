package com.example.lms.service.IMPL;

import com.example.lms.dto.AuthorDTO;
import com.example.lms.dto.AuthorSaveDTO;
import com.example.lms.dto.AuthorUpdateDTO;
import com.example.lms.entity.Author;
import com.example.lms.repo.AuthorRepo;
import com.example.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> getAuthors = authorRepo.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        for(Author author : getAuthors)
        {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorid(),
                    author.getName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {
         if (authorRepo.existsById(authorUpdateDTO.getAuthorid())) {
                Author author = authorRepo.getById(authorUpdateDTO.getAuthorid());
                author.setName(authorUpdateDTO.getName());
                authorRepo.save(author);
                return author.getName();
            } else {
                System.out.println("Author ID Not Exist!!!!!!!!");
            }
            return null;
        }
    }

