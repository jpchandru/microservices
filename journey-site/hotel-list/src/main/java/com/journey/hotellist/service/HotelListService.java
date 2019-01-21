package com.journey.hotellist.service;

import com.journey.hotellist.model.Hotel;
import com.journey.hotellist.repository.HotelListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class HotelListService {

    @Autowired
    HotelListRepository hotelListRepository;

    public Optional<Hotel> getByHotelId(Long id){
        return hotelListRepository.findById(id);
    }

    public Page<Hotel> getHotelList(int page, int size){
        return hotelListRepository.findAll(PageRequest.of(page,size, Sort.Direction.DESC,"rating"));
    }
}
