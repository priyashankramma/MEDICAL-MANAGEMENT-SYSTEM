package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.entity.OrdersEntity;

@Repository
public interface OrdersRepo extends JpaRepository<OrdersEntity,Integer> {

	List<OrdersEntity> findAllByCustomerId(int custId);

}
