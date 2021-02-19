package com.example.demo.part.com.controller;


import com.example.demo.part.com.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public class OneController {

    @Autowired
    OneService service;

    public OneController(OneService service) {
        this.service = service;
    }

    @GetMapping
    public String one() {

        return service.one();
    }
}
