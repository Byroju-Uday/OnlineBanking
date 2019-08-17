package com.bank.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.online.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

}