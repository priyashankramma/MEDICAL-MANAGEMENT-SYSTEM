package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer>{
	 

}
 
