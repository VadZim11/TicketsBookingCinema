package com.gpsolutions.ticketsBookingCinema.service;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Show {
    private int id;

    @JsonFormat(pattern = "yyyy,MM,dd't'HH:mm")
    private LocalDateTime time;

    private String film;
    private int seats;

    public Show (int id, LocalDateTime time, String film, int seats) {
        this.id = id;
        this.time = time;
        this.film = film;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
