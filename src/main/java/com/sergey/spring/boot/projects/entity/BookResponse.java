package com.sergey.spring.boot.projects.entity;

import java.time.LocalDateTime;

public class BookResponse {
    private Integer id;
    private Integer user_id;
    private Integer place_id;
    private LocalDateTime from;
    private LocalDateTime to;

    public static BookResponse fromBooking(Book booking) {
        BookResponse response = new BookResponse();
        response.setId(booking.getId());
        response.setUser_id(booking.getUserId());
        response.setPlace_id(booking.getPlaceId());
        response.setFrom(booking.getTimeFrom());
        response.setTo(booking.getTimeTo());
        return response;
    }

    // Геттеры и сеттеры
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public Integer getPlace_id() { return place_id; }
    public void setPlace_id(Integer place_id) { this.place_id = place_id; }

    public LocalDateTime getFrom() { return from; }
    public void setFrom(LocalDateTime from) { this.from = from; }

    public LocalDateTime getTo() { return to; }
    public void setTo(LocalDateTime to) { this.to = to; }
}
