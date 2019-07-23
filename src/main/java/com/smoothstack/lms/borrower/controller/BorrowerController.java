package com.smoothstack.lms.borrower.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.borrower.Const;
import com.smoothstack.lms.borrower.entity.BookCopies;
import com.smoothstack.lms.borrower.entity.Borrower;
import com.smoothstack.lms.borrower.entity.LibraryBranch;
import com.smoothstack.lms.borrower.service.BorrowerService;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {

	@Autowired
	private BorrowerService borrService;
	
	@PostMapping(value = "/login", produces = { Const.JSON, Const.XML}, consumes = { Const.JSON, Const.XML})
	public ResponseEntity<Borrower> loginBorrower(@RequestBody Integer cardNo){
		return cardNo == null ? new ResponseEntity<Borrower>(HttpStatus.BAD_REQUEST) 
				: borrService.loginBorrower(cardNo);	
	}
	
	@GetMapping(value = "/branches", produces = { Const.JSON, Const.XML})
	public List<LibraryBranch> getAllBranches(){
		return borrService.getAllBranches();
	}
	
	
	@GetMapping(value = "/branch/{branchId}/booksAvailable", produces = { Const.XML, Const.JSON })
	public ResponseEntity<List<BookCopies>> getAllAvailableBooksAtBranch(@Valid @PathVariable Integer branchId){		
		return borrService.getAllAvailableBooksAtBranch(branchId);
	}
	
	
	
}
