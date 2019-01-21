package com.journey.hoteloperations.service;

import com.journey.hoteloperations.model.Hotel;
import com.journey.hoteloperations.repository.HotelOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelOperationsService {

    @Autowired
    HotelOperationsRepository hotelOperationsRepository;

    public Boolean insertHotel(List<Hotel> hotelList){
        hotelOperationsRepository.saveAll(hotelList);
        for(Hotel h: hotelList){
            if(hotelOperationsRepository.existsById(h.getId())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public Boolean editHotel(Long id, Hotel hotel){
        if(hotelOperationsRepository.existsById(id)){
            Optional<Hotel> htl = hotelOperationsRepository.findById(id);
            htl.get().setId(id);
            htl.get().setName(hotel.getName());
            htl.get().setGroupName(hotel.getGroupName());
            htl.get().setLocation(hotel.getLocation());
            htl.get().setRating(hotel.getRating());
            hotelOperationsRepository.save(htl.get());
            return true;
        }else{
            return false;
        }
    }

    public Optional<Hotel> getByHotelId(Long id){
        return hotelOperationsRepository.findById(id);
    }
}
