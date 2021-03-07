package com.hotelreservation;

import java.util.*;
import java.util.stream.*;

public class Hotel {
    public String name;
    public int weekDayRate;
    public int weekEndRate;
    ArrayList<Hotel> arrayOfHotels = new ArrayList<>();
    Map<String, Integer> costOfHotels = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public Hotel(String name, int weekDayRate, int weekEndRate) {
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
    }

    public Hotel() {

    }

    // method to add hotel
    public boolean addHotel(Hotel hotel) {
        arrayOfHotels.add(hotel);
        return true;
    }

    // method to find cheap hotel for given date range
    public int findCheapestHotel(String dateCheckIn, String dateCheckOut) {
        String dayStart = dateCheckIn.substring(0, 2);
        int checkInDay = Integer.parseInt(dayStart);
        String dayEnd = dateCheckOut.substring(0, 2);
        int checkOutDay = Integer.parseInt(dayEnd);
        int numberOfDays = checkOutDay - checkInDay;
        costOfHotels = arrayOfHotels.stream().collect(Collectors.toMap(e -> e.getHotelName(), e -> e.getWeekDayRate() * numberOfDays));
        int cost = Collections.min(costOfHotels.values());
        costOfHotels.entrySet().stream().filter(e -> e.getValue().equals(cost)).forEach(e -> System.out.println(e.getKey()));
        System.out.println("Stay Price :" + cost);
        return cost;
    }

    public String getHotelName() {
        return name;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public int getWeekEndRate() {
        return weekEndRate;
    }
}
