package com.phangil.houseutils.service;

import com.phangil.houseutils.exception.ErrorCode;
import com.phangil.houseutils.exception.HouseUtilsException;
import com.phangil.houseutils.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                .getPrice();
    }

}
