package com.gpsolutions.ticketsBookingCinema.dao;


import com.gpsolutions.ticketsBookingCinema.service.Reserv;
import com.gpsolutions.ticketsBookingCinema.service.Show;

import java.io.IOException;
import java.util.List;

public interface Dao {

    List<Show> getSchedule() throws IOException;

    boolean bookSeats(int sessionId, String surName, int seats) throws IOException;

    boolean cancelReservation(int reservationId) throws IOException;

    Reserv getReserveInfo(int reservationId) throws IOException;

}
