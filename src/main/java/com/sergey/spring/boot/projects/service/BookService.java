package com.sergey.spring.boot.projects.service;

import com.sergey.spring.boot.projects.entity.Book;
import com.sergey.spring.boot.projects.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookingRepository;

    public BookService(BookRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public boolean createBooking(Integer userId, Integer placeId, LocalDateTime from, LocalDateTime to) {
        if (bookingRepository.existsOverlappingBooking(placeId, from, to)) {
            return false;
        }

        Book booking = new Book();
        booking.setUserId(userId);
        booking.setPlaceId(placeId);
        booking.setTimeFrom(from);
        booking.setTimeTo(to);

        bookingRepository.save(booking);
        return true;
    }

    public List<Book> getBookingsByUser(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Book> getBookingsByPlace(Integer placeId) {
        return bookingRepository.findByPlaceId(placeId);
    }
}
