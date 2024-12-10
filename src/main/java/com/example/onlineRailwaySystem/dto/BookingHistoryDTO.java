package com.example.onlineRailwaySystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingHistoryDTO {
    private Long bookingId;
    private String trainName;
    private Date bookingDate;
    private int numberOfSeats;

    public BookingHistoryDTO(Long bookingId, String trainName, Date bookingDate, int numberOfSeats) {
        this.bookingId = bookingId;
        this.trainName = trainName;
        this.bookingDate = bookingDate;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
