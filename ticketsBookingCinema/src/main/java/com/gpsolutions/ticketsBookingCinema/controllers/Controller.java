package com.gpsolutions.ticketsBookingCinema.controllers;


import com.gpsolutions.ticketsBookingCinema.dao.Dao;
import com.gpsolutions.ticketsBookingCinema.entities.Reserv;
import com.gpsolutions.ticketsBookingCinema.entities.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
    private final Logger LOG = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private Dao dao;

    @GetMapping(value = "/schedule", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Session> getSchedule() throws IOException {
        LOG.info("getSchedule");
        return dao.getSchedule();
    }

    @GetMapping(value = "/reservation/{reservationId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Reserv> getReservationInfo(@PathVariable(value = "reservationId") int reservationId) throws IOException {
        LOG.info("get Reservation Info with id={}", reservationId);
        Reserv reservation = dao.getReserveInfo(reservationId);
        return (reservation == null) ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping(value = "/reservation")
    public ResponseEntity reserve(@RequestParam(value = "sessionId") int sessionId,
                                  @RequestParam(value = "surName") String surName,
                                  @RequestParam(value = "seats") int seats) throws IOException {
        LOG.info("Reserve {} seats for {} on session with id={}", seats, surName, sessionId);
        boolean res = dao.bookSeats(sessionId, surName, seats);
        return (res) ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "reservation/{reservationId}")
    public ResponseEntity cancelReservation(@PathVariable(value = "reservationId") int reservationId) throws IOException {
        LOG.info("Cancel reservation with id={}", reservationId);
        boolean res = dao.cancelReservation(reservationId);
        return (res) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
