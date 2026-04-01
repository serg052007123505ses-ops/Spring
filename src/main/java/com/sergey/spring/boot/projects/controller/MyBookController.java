package com.sergey.spring.boot.projects.controller;

import com.sergey.spring.boot.projects.entity.Book;
import com.sergey.spring.boot.projects.entity.BookResponse;
import com.sergey.spring.boot.projects.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class MyBookController {
    private final BookService bookingService;

    public MyBookController(BookService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Object> createBooking(
            @RequestParam Integer place_id,
            @RequestParam Integer user_id,
            @RequestParam String from,
            @RequestParam String to) {

        try {
            LocalDateTime fromTime = LocalDateTime.parse(from);
            LocalDateTime toTime = LocalDateTime.parse(to);

            boolean created = bookingService.createBooking(user_id, place_id, fromTime, toTime);

            if (created) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Map.of("error", "Conflict: booking interval overlaps with existing reservation"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid date format"));
        }
    }

    @GetMapping("/booklist")
    public ResponseEntity<Map<String, String>> getBookings(
            @RequestParam(required = false) Integer user_id,
            @RequestParam(required = false) Integer place_id) {

        if (user_id != null) {
            List<Book> bookings = bookingService.getBookingsByUser(user_id);
            List<BookResponse> responses = bookings.stream()
                    .map(BookResponse::fromBooking)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(Map.of("bookings", responses.toString()));
        } else if (place_id != null) {
            List<Book> bookings = bookingService.getBookingsByPlace(place_id);
            List<BookResponse> responses = bookings.stream()
                    .map(BookResponse::fromBooking)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(Map.of("bookings", responses.toString()));
        } else {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Either user_id or place_id must be provided"));
        }
    }

}
