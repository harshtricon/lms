package com.example.lms.service.IMPL;
import com.example.lms.dto.BorrowDTO;
import com.example.lms.dto.BorrowSaveDTO;
import com.example.lms.dto.BorrowUpdateDTO;
import com.example.lms.entity.Borrow;
import com.example.lms.repo.BookRepo;
import com.example.lms.repo.BorrowRepo;
import com.example.lms.repo.UserRepo;
import com.example.lms.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {
        @Autowired
        private BookRepo bookRepo;

        @Autowired
        private UserRepo userRepo;

        @Autowired
        private BorrowRepo borrowRepo;


        @Override
        public String addBorrow(BorrowSaveDTO borrowSaveDTO) {

            Borrow borrow = new Borrow(

                    bookRepo.getById(borrowSaveDTO.getBook_id()),
                    userRepo.getById(borrowSaveDTO.getUser_id()),
                    borrowSaveDTO.getBorrow_date(),
                    borrowSaveDTO.getReturn_date()

            );
            borrowRepo.save(borrow);

            return null;
        }

        @Override
        public List<BorrowDTO> getAllBorrow() {

            List<Borrow> getBorrow = borrowRepo.findAll();
            List<BorrowDTO> borrowDTOList = new ArrayList<>();

            for(Borrow borrow : getBorrow)
            {
                BorrowDTO borrowDTO = new BorrowDTO(
                        borrow.getId(),
                        borrow.getBook(),
                        borrow.getUser(),
                        borrow.getBorrowDate(),
                        borrow.getReturnDate()

                );
                borrowDTOList.add(borrowDTO);

            }
            return borrowDTOList;


        }

        @Override
        public String updateBorrow(BorrowUpdateDTO borrowUpdateDTO) {

            try {


                if(borrowRepo.existsById(borrowUpdateDTO.getId())) {
                    Borrow borrow = borrowRepo.getById(borrowUpdateDTO.getId());
                    borrow.setBook(bookRepo.getById(borrowUpdateDTO.getBook_id()));
                    borrow.setUser(userRepo.getById(borrowUpdateDTO.getUser_id()));
                    borrow.setBorrowDate(borrowUpdateDTO.getBorrow_date());
                    borrow.setReturnDate(borrowUpdateDTO.getReturn_date());

                    borrowRepo.save(borrow);

                    return "Borrow updated successfully.";

                }
                else
                {
                    System.out.println("Borrow ID Not Found");
                }

            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            return null;


        }
}
