package com.hotelreservation;

import java.util.*;

public class Hotel {
    public String name;
    public int rate;
    ArrayList<Hotel> arrayofHotel = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Hotel(String name, int rate) {
        this.name = name;
        this.rate = rate;

    }

    public Hotel() {

    }

    // method to add hotel
    public boolean addHotel(Hotel hotel) {
        arrayofHotel.add(hotel);
        return true;
    }

    public String getHotelName() {
        return name;
    }

    public int getRating() {
        return rate;
    }
}
