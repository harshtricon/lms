package com.example.lms.repo;


import com.example.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface UserRepo extends JpaRepository<User,Integer > {
}
