package com.ecommerce.client.configuration;

import com.ecommerce.client.model.CjKartUser;
import com.ecommerce.client.repository.CjKartUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class CjKartUserConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(CjKartUserRepository cjKartUserRepository){
        return args ->Stream.of("demo,{noop}demo","ceejay,{noop}ceejay")
                .map(u->u.split(","))
                .forEach(t->cjKartUserRepository.save(new CjKartUser(t[0],t[1],true)));
    }



}
