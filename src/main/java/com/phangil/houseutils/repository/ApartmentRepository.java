package com.phangil.houseutils.repository;

import com.phangil.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
