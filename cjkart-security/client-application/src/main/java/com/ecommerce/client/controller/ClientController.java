package com.ecommerce.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/cjkart")
public class ClientController {

    @GetMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("Welcome to CJKart", HttpStatus.OK);
    }


    @GetMapping("/user")
    public ResponseEntity<Principal> getUser(Principal user){
        return new ResponseEntity<Principal>(user, HttpStatus.OK);
    }
}
