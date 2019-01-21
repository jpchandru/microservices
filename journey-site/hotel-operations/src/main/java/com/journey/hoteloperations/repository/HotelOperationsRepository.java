package com.journey.hoteloperations.repository;

import com.journey.hoteloperations.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOperationsRepository extends JpaRepository<Hotel, Long> {
}
