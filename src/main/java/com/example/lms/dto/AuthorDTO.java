package com.example.lms.dto;
import jakarta.persistence.Entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {
    @Id

    private int authorid;
    private String name;
}
