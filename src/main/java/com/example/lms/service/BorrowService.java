package com.example.lms.service;

import com.example.lms.dto.BorrowDTO;
import com.example.lms.dto.BorrowSaveDTO;
import com.example.lms.dto.BorrowUpdateDTO;

import java.util.List;

public interface BorrowService {
    String addBorrow(BorrowSaveDTO borrowSaveDTO);

    List<BorrowDTO> getAllBorrow();

    String updateBorrow(BorrowUpdateDTO borrowUpdateDTO);
}