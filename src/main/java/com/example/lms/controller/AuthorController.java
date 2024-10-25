package com.example.lms.controller;

import com.example.lms.dto.AuthorDTO;
import com.example.lms.dto.AuthorSaveDTO;
import com.example.lms.dto.AuthorUpdateDTO;
import com.example.lms.exception.AuthorNotFoundException;
import com.example.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller for managing authors in the Library Management System.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/authors")
public class
AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * Adds a new author to the system.
     *
     * @param authorSaveDTO the author information to save
     * @return a response entity indicating the result of the operation
     */
    @PostMapping
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO) {
        try {
            String authorName = authorService.addAuthor(authorSaveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Author '" + authorName + "' added successfully.");
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid author data provided.", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add author due to a server error.", e);
        }
    }

    /**
     * Retrieves a list of all authors.
     *
     * @return a list of authors
     */
    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        try {
            List<AuthorDTO> allAuthors = authorService.getAllAuthor();
            return ResponseEntity.ok(allAuthors);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve authors due to a server error.", e);
        }
    }

    /**
     * Updates an existing author's information.
     *
     * @param authorUpdateDTO the updated author information
     * @return a response entity indicating the result of the operation
     */
    @PutMapping
    public ResponseEntity<String> updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO) {
        try {
            String authorName = authorService.updateAuthor(authorUpdateDTO);
            return ResponseEntity.ok("Author '" + authorName + "' updated successfully.");
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with the provided ID.", e);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid update data provided for the author.", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update author due to a server error.", e);
        }
    }

    /**
     * Deletes an author by their ID.
     *
     * @param id the ID of the author to delete
     * @return a response entity indicating the result of the operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") int id) {
        try {
            String authorName = authorService.deleteAuthor(id);
            return ResponseEntity.ok("Author '" + authorName + "' deleted successfully.");
        } catch (AuthorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with the provided ID.", e);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ID provided for author deletion.", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete author due to a server error.", e);
        }
    }
}