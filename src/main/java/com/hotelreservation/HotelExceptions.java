package com.hotelreservation;

public class HotelExceptions extends Exception {
    String message;

    public HotelExceptions(String message) {
        super(message);
        System.out.println(message);
    }
}
