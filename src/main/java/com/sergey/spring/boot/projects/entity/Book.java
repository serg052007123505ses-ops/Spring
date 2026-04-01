package com.sergey.spring.boot.projects.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "place_id", nullable = false)
    private Integer placeId;

    @Column(name = "time_from", nullable = false)
    private LocalDateTime timeFrom;

    @Column(name = "time_to", nullable = false)
    private LocalDateTime timeTo;

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getPlaceId() { return placeId; }
    public void setPlaceId(Integer placeId) { this.placeId = placeId; }

    public LocalDateTime getTimeFrom() { return timeFrom; }
    public void setTimeFrom(LocalDateTime timeFrom) { this.timeFrom = timeFrom; }

    public LocalDateTime getTimeTo() { return timeTo; }
    public void setTimeTo(LocalDateTime timeTo) { this.timeTo = timeTo; }
}
