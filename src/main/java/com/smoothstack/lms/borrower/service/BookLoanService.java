package com.smoothstack.lms.borrower.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.borrower.dao.BookLoanDAO;
import com.smoothstack.lms.borrower.entity.BookLoan;

@Service
public class BookLoanService {

	
	@Autowired
	private BookLoanDAO loanDAO;
	
	public boolean isBookCheckedOut(BookLoan bookLoan) {
		return loanDAO.existsById(bookLoan.getBookLoanId());		
	}	
	
	
}
