package com.hotelreservation;

import java.util.*;

public class ReservationSystem {
    public String hotelName;
    static String name;
    static int rating;
    static int weekDayRates;
    static int weekEndRates;

    // method to add hotel
    public boolean addHotel(String name, int rating, int weekDayRates, int weekEndRates) {
        hotelName = name;
        Hotel hotelName = new Hotel(name, rating, weekDayRates, weekEndRates);
        return true;
    }

    public static void main(String Args[]) {
        System.out.println("Welcome to hotel Reservation System");
        ReservationSystem reservationSystem = new ReservationSystem();
        System.out.println("Enter Hotel Name");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Enter Ratings");
        rating = sc.nextInt();
        System.out.println("Enter Week Day rates");
        weekDayRates = sc.nextInt();
        System.out.println("Enter WeekEnd Rates");
        weekEndRates = sc.nextInt();
        reservationSystem.addHotel(name, rating, weekDayRates, weekDayRates);
    }
}