package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.entity.CustomerEntity;
import com.pharmacy.entity.PharmacyItemEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {


}
