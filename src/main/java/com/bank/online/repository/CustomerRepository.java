package com.bank.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.online.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
