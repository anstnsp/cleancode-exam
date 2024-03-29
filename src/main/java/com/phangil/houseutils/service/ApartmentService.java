package com.phangil.houseutils.service;

import com.phangil.houseutils.exception.ErrorCode;
import com.phangil.houseutils.exception.HouseUtilsException;
import com.phangil.houseutils.policy.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final GoodsService goodsService;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                .getPrice();
    }

    @Transactional
    public void roll() throws Exception{
        goodsService.aasff();
    }

}
