package com.ecommerce.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class ResourceController {

    @GetMapping("/user/me")
    public ResponseEntity getUser(Principal principal){
        System.out.println(principal);
        if(principal != null)
           return ResponseEntity.ok().body(principal);
        else
            return new ResponseEntity<>("Authentication failure", HttpStatus.NO_CONTENT);
    }


}
