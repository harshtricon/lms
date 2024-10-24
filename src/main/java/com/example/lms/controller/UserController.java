package com.example.lms.controller;

import com.example.lms.dto.*;
import com.example.lms.service.AuthorService;
import com.example.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO)
    {
        String authorname = userService.addUser(userSaveDTO);
        return  "Added Successfully";
    }

    @GetMapping(path = "/getAll")// jab endpoint ye aaega tab getall method call hoga
    public List<UserDTO> getAllUser()
    {
        List<UserDTO> allUser = userService.getAllUser();
        return allUser;
    }

    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO)
    {
        String username = userService.updateUser(userUpdateDTO);
        return  username;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable(value = "id")int id)
    {
        String username = userService.deleteUser(id);
        return  "deleteddd";
    }
}
