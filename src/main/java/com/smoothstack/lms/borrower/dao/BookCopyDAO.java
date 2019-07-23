package com.smoothstack.lms.borrower.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.lms.borrower.entity.BookCopies;
import com.smoothstack.lms.borrower.entity.BookCopyId;

public interface BookCopyDAO extends JpaRepository<BookCopies, BookCopyId> {

	@Query(value = "SELECT * FROM tbl_book_copies WHERE branchId = ?1 AND noOfCopies > 0", nativeQuery = true)
	public Optional<List<BookCopies>> getAvailableBooksFromBranch(Integer branchId);

	@Modifying
	@Query(value = "UPDATE tbl_book_copies SET noOfCopies = noOfCopies - 1 WHERE bookId = ?1 AND branchId = ?2",
			nativeQuery = true)
	public Integer removeACopy(Integer bookId, Integer branchId);

	@Modifying
	@Query(value = "UPDATE tbl_book_copies SET noOfCopies = noOfCopies + 1 WHERE bookId = ?1 AND branchId = ?2",
	nativeQuery = true)
	public Integer addACopy(Integer bookId, Integer branchId);
	
}
