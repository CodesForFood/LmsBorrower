package com.smoothstack.lms.borrower.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.borrower.entity.BookLoan;
import com.smoothstack.lms.borrower.entity.BookLoanId;

public interface BookLoanDAO extends JpaRepository<BookLoan, BookLoanId>{

}
