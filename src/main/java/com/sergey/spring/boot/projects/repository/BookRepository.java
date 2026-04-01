package com.sergey.spring.boot.projects.repository;

import com.sergey.spring.boot.projects.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("SELECT b FROM Book b WHERE b.userId = :userId ORDER BY b.timeFrom ASC, b.id ASC")
    List<Book> findByUserId(Integer userId);

    @Query("SELECT b FROM Book b WHERE b.placeId = :placeId ORDER BY b.timeFrom ASC, b.id ASC")
    List<Book> findByPlaceId(Integer placeId);

    @Query("SELECT COUNT(b) > 0 FROM Book b " +
            "WHERE b.placeId = :placeId " +
            "AND b.timeFrom < :timeTo " +
            "AND b.timeTo > :timeFrom")
    boolean existsOverlappingBooking(Integer placeId, LocalDateTime timeFrom, LocalDateTime timeTo);
}
