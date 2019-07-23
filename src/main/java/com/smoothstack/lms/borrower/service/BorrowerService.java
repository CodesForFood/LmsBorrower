package com.smoothstack.lms.borrower.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.lms.borrower.dao.BookCopyDAO;
import com.smoothstack.lms.borrower.dao.BookLoanDAO;
import com.smoothstack.lms.borrower.dao.BorrowerDAO;
import com.smoothstack.lms.borrower.dao.BranchDAO;
import com.smoothstack.lms.borrower.entity.BookCopies;
import com.smoothstack.lms.borrower.entity.Borrower;
import com.smoothstack.lms.borrower.entity.LibraryBranch;

@Service
public class BorrowerService {

	@Autowired
	private BorrowerDAO borrDAO;
	
	@Autowired
	private BookLoanDAO loanDAO;
	
	@Autowired
	private BranchDAO branchDAO;
	
	@Autowired
	private BookCopyDAO copyDAO;

	@Transactional
	public ResponseEntity<Borrower> loginBorrower(Integer cardNo) {
		Optional<Borrower> borr = borrDAO.findById(cardNo);
		
		return borr.isPresent() ? new ResponseEntity<Borrower>(borr.get(), HttpStatus.OK) 
				: new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND);						
	}

	@Transactional
	public List<LibraryBranch> getAllBranches() {
		return branchDAO.findAll();
	}

	@Transactional
	public ResponseEntity<List<BookCopies>> getAllAvailableBooksAtBranch(Integer branchId) {
		Optional<List<BookCopies>> bookList = copyDAO.getAvailableBooksFromBranch(branchId);
		
		return bookList.isPresent() ? new ResponseEntity<List<BookCopies>>(bookList.get(), HttpStatus.OK)
				: new ResponseEntity<List<BookCopies>>(HttpStatus.NOT_FOUND);
	}
	
	
}
