package com.Crypto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping
    public String Hello(){
        return "Welcome to CryptoZenith";
    }

    @GetMapping("/api")
    public String secure(){
        return "Welcome to CryptoZenith";
    }
}
