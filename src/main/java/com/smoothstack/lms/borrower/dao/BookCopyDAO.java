package com.smoothstack.lms.borrower.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.lms.borrower.entity.BookCopies;
import com.smoothstack.lms.borrower.entity.BookCopyId;

public interface BookCopyDAO extends JpaRepository<BookCopies, BookCopyId> {

	@Query(value = "SELECT * FROM tbl_book_copies WHERE branchId = ?1 AND noOfCopies > 0", nativeQuery = true)
	public Optional<List<BookCopies>> getAvailableBooksFromBranch(Integer branchId);
	
}
