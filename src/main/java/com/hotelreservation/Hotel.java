package com.hotelreservation;

import java.rmi.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Hotel {
    public String name;
    public int weekDayRate;
    public int weekEndRate;
    public int rating;
    ArrayList<Hotel> arrayOfHotels = new ArrayList<>();
    Map<String, Integer> costOfHotels = new HashMap<>();
    HashMap<String, String> monthsInYear = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> ratingOfHotels = new HashMap<>();

    public Hotel(String name, int weekDayRate, int weekEndRate, int rating) {
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rating = rating;
    }

    public Hotel() {

    }

    // method to add hotel
    public boolean addHotel(Hotel hotel) {
        arrayOfHotels.add(hotel);
        return true;
    }

    public int getRating() {
        return rating;
    }

    // method to find cheap hotel for given date range
    public int findCheapestHotel(String dateCheckIn, String dateCheckOut) {
        ratingOfHotels = arrayOfHotels.stream().collect(Collectors.toMap(e -> e.getHotelName(), e -> e.getRating()));
        String dayStart = dateCheckIn.substring(0, 2);
        int checkInDay = Integer.parseInt(dayStart);
        String dayEnd = dateCheckOut.substring(0, 2);
        int checkOutDay = Integer.parseInt(dayEnd);
        int numberOfDays = checkOutDay - checkInDay;
        int numberOfWeekEnds = noOfWeekDaysAndWeekEnds(dateCheckIn, dateCheckOut, numberOfDays, checkInDay, checkOutDay);
        numberOfDays = numberOfDays - numberOfWeekEnds;
        int finalNumberOfDays = numberOfDays;
        costOfHotels = arrayOfHotels.stream().collect(Collectors.toMap(e -> e.getHotelName(), e -> e.getWeekDayRate() * finalNumberOfDays + e.getWeekEndRate() * numberOfWeekEnds));
        int cost = Collections.min(costOfHotels.values());
        String hotel = costOfHotels.entrySet().stream().filter(e -> e.getValue().equals(cost)).map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("Hotel : " + hotel);
        System.out.println("Stay Price :" + cost);
        System.out.println("Rating  : " + ratingOfHotels.get(hotel));
        return cost;
    }

    public static int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
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

    public String poplateMonths(String month) {
        monthsInYear.put("Sep", "SEPTEMBER");
        return monthsInYear.get(month);
    }

    public int noOfWeekDaysAndWeekEnds(String dateCheckIn, String dateCheckOut, int numOfDays, int checkIn, int checkOut) {
        int weekEndCount = 0;
        String month = dateCheckIn.substring(2, 5);
        String monthOfGivenDate = poplateMonths(month);
        String year = dateCheckIn.substring(5, 9);
        int yearOfGivenDate = Integer.parseInt(year);
        for (int i = checkIn; i <= checkOut; i++) {
            LocalDate localDate = LocalDate.of(yearOfGivenDate, Month.valueOf(monthOfGivenDate), i);
            DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
            if (dayOfWeek.name().equals("SATURDAY") || dayOfWeek.name().equals("SUNDAY")) {
                weekEndCount++;
            }
        }
        return weekEndCount;
    }
}

