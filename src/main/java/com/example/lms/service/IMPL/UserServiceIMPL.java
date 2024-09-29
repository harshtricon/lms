package com.example.lms.service.IMPL;

import com.example.lms.dto.AuthorDTO;
import com.example.lms.dto.UserDTO;
import com.example.lms.dto.UserSaveDTO;
import com.example.lms.dto.UserUpdateDTO;
import com.example.lms.entity.Author;
import com.example.lms.entity.User;
import com.example.lms.repo.AuthorRepo;
import com.example.lms.repo.UserRepo;
import com.example.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getName(),
                userSaveDTO.getEmail()
        );
        userRepo.save(user);
        return user.getName();

    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> getUser = userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : getUser)
        {
            UserDTO userDTO = new UserDTO(
                    user.getUserid(),
                    user.getName(),
                    user.getEmail()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepo.existsById(userUpdateDTO.getUserid())) {
            User user = userRepo.getById(userUpdateDTO.getUserid());
            user.setName(userUpdateDTO.getName());
            user.setEmail(userUpdateDTO.getEmail());
            userRepo.save(user);
            return user.getName();
        } else {
            System.out.println("User ID Not Exist!!!!!!!!");
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        if(userRepo.existsById(id))
        {
            userRepo.deleteById(id);
        }
        else
        {
            System.out.println("ID Not Found");
        }
        return null;

    }
}
