package com.hotelreservation;

import java.util.*;
import java.util.stream.*;

public class Hotel {
    public String name;
    public int rate;
    ArrayList<Hotel> arrayofHotels = new ArrayList<>();
    Map<String, Integer> costOfHotels = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public Hotel(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public Hotel() {

    }

    // method to add hotel
    public boolean addHotel(Hotel hotel) {
        arrayofHotels.add(hotel);
        return true;
    }

    public int findCheapestHotel(String dateCheckIn, String dateCheckOut) {
        String dayStart = dateCheckIn.substring(0, 2);
        int checkInDay = Integer.parseInt(dayStart);
        String dayEnd = dateCheckOut.substring(0, 2);
        int checkOutDay = Integer.parseInt(dayEnd);
        int numberOfDays = checkOutDay - checkInDay;
        costOfHotels = arrayofHotels.stream().collect(Collectors.toMap(e -> e.getHotelName(), e -> e.getRate() * numberOfDays));
        String hotel = Collections.min(costOfHotels.keySet());
        int cost = costOfHotels.get(hotel);
        System.out.println("Minimm Hotel is " + hotel + " :" + cost);
        return cost;
    }

    public void calculatePrice() {

    }

    public String getHotelName() {
        return name;
    }

    public int getRate() {
        return rate;
    }
}
