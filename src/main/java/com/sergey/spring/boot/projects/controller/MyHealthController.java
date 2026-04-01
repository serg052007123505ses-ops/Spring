package com.sergey.spring.boot.projects.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class MyHealthController {

    @GetMapping("/ping")
    public ResponseEntity<Object> ping() {
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}
