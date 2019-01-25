package com.ecommerce.server.repository;

import com.ecommerce.server.model.CjKartUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CjKartUserRepository extends JpaRepository<CjKartUser, Long>{
    Optional<CjKartUser> findByUserName(String userName);
}
