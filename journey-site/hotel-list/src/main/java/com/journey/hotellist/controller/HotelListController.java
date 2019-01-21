package com.journey.hotellist.controller;

import com.journey.hotellist.model.Hotel;
import com.journey.hotellist.service.HotelListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/hotels")
public class HotelListController {

    @Autowired
    HotelListService hotelListService;

    @GetMapping
    public ResponseEntity<Page<Hotel>> getHotelList(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok().body(hotelListService.getHotelList(page, size));
    }

    @GetMapping ("/{id}")
    public ResponseEntity getHotelById(@PathVariable Long id){
        if(id <= 0){
            return new ResponseEntity<>("Invalid input", HttpStatus.PRECONDITION_FAILED);
        }
        Optional<Hotel> hotel = hotelListService.getByHotelId(id);
        if(hotel != null){
            return ResponseEntity.ok().body(hotel);
        }else{
            return new ResponseEntity<>("No hotel available for that id", HttpStatus.NOT_FOUND);
        }

    }

}
