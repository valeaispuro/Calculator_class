package com.example.backend.calculator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {

    @GetMapping("/add")
    public double add(@RequestParam(defaultValue = "0") double a, @RequestParam(defaultValue = "0") double b) {
        return a + b;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam(defaultValue = "0") double a, @RequestParam(defaultValue = "0") double b) {
        return a - b;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam(defaultValue = "1") double a, @RequestParam(defaultValue = "1") double b) {
        return a * b;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam(defaultValue = "1") double a, @RequestParam(defaultValue = "1") double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }
}