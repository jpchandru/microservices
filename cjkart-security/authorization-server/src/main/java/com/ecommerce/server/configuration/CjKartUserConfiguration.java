package com.ecommerce.server.configuration;

import com.ecommerce.server.model.CjKartUser;
import com.ecommerce.server.repository.CjKartUserRepository;
import com.ecommerce.server.service.CjKartUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Stream;

@Configuration
@Order(1)
public class CjKartUserConfiguration {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * This is being stored in H2 in memory DB but this could be replaced via any other data source as well.
     * @param cjKartUserRepository
     * @return UserDetails in SpringContext
     */

    @Bean
    public CommandLineRunner commandLineRunner(CjKartUserRepository cjKartUserRepository){
        String usrName = "ceejay";
        String pwd = passwordEncoder.encode("ceejay");
        return args -> Stream.of(cjKartUserRepository.save(new CjKartUser(usrName,pwd,true)));

       /* return args -> Stream.of("demo,{noop}demo","ceejay,{noop}ceejay")
                .map(u->u.split(","))
                .forEach(t->cjKartUserRepository.save(new CjKartUser(t[0],t[1],true)));*/
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }




}
