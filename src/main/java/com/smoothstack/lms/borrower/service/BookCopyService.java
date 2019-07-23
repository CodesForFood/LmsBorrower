package com.smoothstack.lms.borrower.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.lms.borrower.dao.BookCopyDAO;
import com.smoothstack.lms.borrower.entity.BookCopies;

@Service
public class BookCopyService {
 
	
	@Autowired
	private BookCopyDAO copyDAO;
	
	@Transactional
	public Integer removeACopy(Integer bookId, Integer branchId) {
		return copyDAO.removeACopy(bookId, branchId);
	}
	
	@Transactional
	public Optional<List<BookCopies>> getAvailableBooksFromBranch(Integer branchId) {
		return copyDAO.getAvailableBooksFromBranch(branchId);
	}

	@Transactional
	public Integer addACopy(Integer bookId, Integer branchId) {
		return copyDAO.addACopy(bookId, branchId);		
	}

	
	
	
}
