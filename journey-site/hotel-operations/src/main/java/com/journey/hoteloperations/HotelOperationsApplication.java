package com.journey.hoteloperations;

import com.journey.hoteloperations.model.Hotel;
import com.journey.hoteloperations.repository.HotelOperationsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelOperationsApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedDB(HotelOperationsRepository hotelOperationsRepository){
		return args -> {
			hotelOperationsRepository.save(Hotel.builder()
					.id(1005)
					.name("Rennaisance Inn")
					.groupName("Mariott")
					.rating(5)
					.location("Newark, New Jersey, USA")
					.build());
			hotelOperationsRepository.save(Hotel.builder()
					.id(1006)
					.name("Residence Inn")
					.groupName("Mariott")
					.rating(3)
					.location("Metuchen, New Jersey, USA")
					.build());

		};
	}
}

