package com.improve1.freemp_sproduct.controller;

import com.improve1.freemp_sproduct.dto.SproductRequest;
import com.improve1.freemp_sproduct.dto.SproductResponse;
import com.improve1.freemp_sproduct.model.Greeting;
import com.improve1.freemp_sproduct.service.SproductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/sproduct")
@RequiredArgsConstructor
public class SproductController {
    private final SproductService sproductService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/api/old_product")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSproduct(@RequestBody SproductRequest sproductRequest) {
        sproductService.createSproduct(sproductRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SproductResponse> getAllProducts() {
        return sproductService.getAllSproducts();
    }
}
