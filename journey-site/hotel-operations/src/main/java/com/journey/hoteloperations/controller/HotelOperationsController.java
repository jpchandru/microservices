package com.journey.hoteloperations.controller;

import com.journey.hoteloperations.model.Hotel;
import com.journey.hoteloperations.service.HotelOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelOperationsController {

    @Autowired
    HotelOperationsService hotelOperationsService;

    @PostMapping("/add")
    public ResponseEntity addHotel(@RequestBody List<Hotel> hotelList){
        if(hotelList != null){
            for(Hotel htl:hotelList){
                if(!performValidation(htl)){
                    return new ResponseEntity<>("Invalid Input values. Please check.", HttpStatus.PRECONDITION_FAILED);
                }
            }
        }

        if(hotelOperationsService.insertHotel(hotelList)){
            return new ResponseEntity<>("Hotel(s) has been added successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Problem while adding HOTEL(s)", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editHotel(@PathVariable Long id, @RequestBody Hotel hotel){
        if(id <= 0){
            return new ResponseEntity<>("Invalid input", HttpStatus.PRECONDITION_FAILED);
        }
        if(hotelOperationsService.editHotel(id, hotel)){
           // return new ResponseEntity<>("Hotel has been edited successfully", HttpStatus.NO_CONTENT);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("Problem while editing HOTEL", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/{id}")
    public ResponseEntity getHotelById(@PathVariable Long id){
        if(id <= 0){
            return new ResponseEntity<>("Invalid input", HttpStatus.PRECONDITION_FAILED);
        }
        Optional<Hotel> hotel = hotelOperationsService.getByHotelId(id);
        if(hotel != null){
            return ResponseEntity.ok().body(hotel);
        }else{
            return new ResponseEntity<>("No hotel available for that id", HttpStatus.NOT_FOUND);
        }

    }


    private Boolean performValidation(Hotel hotel){
        if(hotel != null){
            if(0 < hotel.getId() && null != hotel.getName() && null != hotel.getLocation()
                    && 0 < hotel.getRating()){
                return true;
            }
        }
        return false;
    }

}
