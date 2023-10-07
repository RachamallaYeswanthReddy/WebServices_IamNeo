package com.Yeswanth.HelloWorld.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    // this is one api
    @GetMapping("/")
    String return1(){
        return "Hello World";
    }
}
