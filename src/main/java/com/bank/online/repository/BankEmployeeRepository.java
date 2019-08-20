package com.bank.online.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.online.model.BankEmployee;

@Repository
public interface BankEmployeeRepository extends JpaRepository<BankEmployee, Long>{
		
	Optional<BankEmployee> findByEmployeeIdAndEmployeePassword(long id,String pwd);
}
