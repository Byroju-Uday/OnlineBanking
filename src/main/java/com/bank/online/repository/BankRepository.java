package com.bank.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.online.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long>{

}
