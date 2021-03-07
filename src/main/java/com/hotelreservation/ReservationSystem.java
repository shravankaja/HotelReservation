package com.hotelreservation;

import java.util.*;

public class ReservationSystem {

    public static void main(String Args[]) {
        Hotel hotel = new Hotel();
        System.out.println("Welcome to hotel Reservation System");
        ReservationSystem reservationSystem = new ReservationSystem();
        Hotel lakeWood = new Hotel("LakeWood", 110, 90);
        Hotel bridgeWood = new Hotel("BridgeWood", 150, 50);
        Hotel ridgeWood = new Hotel("RidgeWood", 220, 150);
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        hotel.findCheapestHotel("12Sep2020","15Sep2020");
    }
}