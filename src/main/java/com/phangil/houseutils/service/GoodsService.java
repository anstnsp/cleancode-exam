package com.phangil.houseutils.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.phangil.houseutils.entity.Apartment;
import com.phangil.houseutils.policy.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GoodsService {

	private final ApartmentRepository apartmentRepository;

	@Transactional
	public void aasff() throws Exception {
		Apartment apartment = Apartment.builder()
						.address("sfsf")
						.name("sesese")
						.price(332323L)
						.build();
		try {
			apartmentRepository.save(apartment);
			throw new RuntimeException("RuntimeException inside");
		} catch(RuntimeException e) {
			System.out.println("에러던져짐 ");
			throw new RuntimeException("체크드에러로 던지기");
		}

	}

}
