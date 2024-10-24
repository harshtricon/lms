package com.example.lms.controller;
import com.example.lms.dto.AuthorDTO;
import com.example.lms.dto.AuthorSaveDTO;
import com.example.lms.dto.AuthorUpdateDTO;
import com.example.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")

@RequestMapping("api/v1/author")
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO)
    {
        String authorname = authorService.addAuthor(authorSaveDTO);
        return  "Added Successfully";
    }

    @GetMapping(path = "/getAll")  // jab endpoint ye aaega tab getall method call hoga
    public List<AuthorDTO> getAllAuthor()
    {
        List<AuthorDTO> allAuthors = authorService.getAllAuthor();
        return allAuthors;
    }

    @PutMapping(path = "/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO)
    {
        String authorname = authorService.updateAuthor(authorUpdateDTO);
        return  authorname;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id")int id)
    {
        String authorname = authorService.deleteAuthor(id);
        return  "deleteddd";
    }


}