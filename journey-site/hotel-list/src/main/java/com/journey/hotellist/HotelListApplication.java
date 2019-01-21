package com.journey.hotellist;

import com.journey.hotellist.model.Hotel;
import com.journey.hotellist.repository.HotelListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelListApplication {


	@Bean
	public CommandLineRunner seedDB(HotelListRepository hotelListRepository){
		return args -> {
			hotelListRepository.save(Hotel.builder()
					.id(1004)
					.name("Embassy Suites")
					.groupName("Hilton")
					.rating(5)
					.location("Edison, New Jersey, USA")
					.build());
			hotelListRepository.save(Hotel.builder()
					.id(1005)
					.name("Rennaisance Inn")
					.groupName("Mariott")
					.rating(5)
					.location("Newark, New Jersey, USA")
					.build());
			hotelListRepository.save(Hotel.builder()
					.id(1006)
					.name("Residence Inn")
					.groupName("Mariott")
					.rating(3)
					.location("Metuchen, New Jersey, USA")
					.build());
			hotelListRepository.save(Hotel.builder()
					.id(1007)
					.name("Homewood Suites")
					.groupName("Hilton")
					.rating(4)
					.location("Jersey City, New Jersey, USA")
					.build());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(HotelListApplication.class, args);
	}

}

