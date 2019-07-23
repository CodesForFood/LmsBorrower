package com.smoothstack.lms.borrower.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.lms.borrower.entity.Borrower;

@Repository
public interface BorrowerDAO extends JpaRepository<Borrower, Integer>{

}
