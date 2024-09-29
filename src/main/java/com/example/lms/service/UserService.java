package com.example.lms.service;

import com.example.lms.dto.UserDTO;
import com.example.lms.dto.UserSaveDTO;
import com.example.lms.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();

    String updateUser(UserUpdateDTO userUpdateDTO);

    String deleteUser(int id);
}
