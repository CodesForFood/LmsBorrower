package com.smoothstack.lms.borrower.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.borrower.entity.LibraryBranch;

public interface BranchDAO extends JpaRepository<LibraryBranch, Integer> {

}
