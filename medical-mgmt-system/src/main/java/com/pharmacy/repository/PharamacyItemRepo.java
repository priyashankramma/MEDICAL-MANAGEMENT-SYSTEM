package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pharmacy.entity.PharmacyItemEntity;


@Repository
public interface PharamacyItemRepo extends JpaRepository<PharmacyItemEntity,Integer>{
	 
	List<PharmacyItemEntity> findByCategory(String searchString);

	PharmacyItemEntity findByCategoryAndMedicineName(String cateegory, String itemName);
	
	@Query(value="SELECT * FROM pharmacy_items where medicine_name =?1",nativeQuery=true)
	PharmacyItemEntity getByMedicineName(String itemName);

}
