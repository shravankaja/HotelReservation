package com.hotelreservation;

public class Hotel {
    public String hotelName;
    public int rating;
    public int weekDayRates;
    public int weekEndRates;

    public Hotel(String hotelName, int rating, int weekDayRates, int weekEndRates) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekDayRates = weekDayRates;
        this.weekEndRates = weekEndRates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRating() {
        return rating;
    }

    public int getWeekDayRates() {
        return weekDayRates;
    }

    public int getWeekEndRates() {
        return weekEndRates;
    }
}
