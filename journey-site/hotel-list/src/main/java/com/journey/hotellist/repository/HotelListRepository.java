package com.journey.hotellist.repository;

import com.journey.hotellist.model.Hotel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelListRepository extends PagingAndSortingRepository<Hotel, Long>{
}