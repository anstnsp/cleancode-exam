package com.phangil.houseutils.policy.repository;

import java.util.List;

import com.phangil.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
	List<Apartment> findByName(String name);

}
