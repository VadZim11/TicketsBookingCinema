package com.gpsolutions.ticketsBookingCinema.service;

public class Reserv {
    private int id;
    private int sessionId;
    private String surName;
    private int tikets;

    public Reserv(int id, int sessionId, String surName, int tikets) {
        this.id = id;
        this.sessionId = sessionId;
        this.surName = surName;
        this.tikets = tikets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getTikets() {
        return tikets;
    }

    public void setTikets(int tikets) {
        this.tikets = tikets;
    }
}
