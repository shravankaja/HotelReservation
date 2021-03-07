package com.hotelreservation;

import java.util.*;

public class ReservationSystem {

    public static void main(String Args[]) {
        Hotel hotel = new Hotel();
        System.out.println("Welcome to hotel Reservation System");
        ReservationSystem reservationSystem = new ReservationSystem();
        Hotel lakeWood = new Hotel("LakeWood", 110, 90, 3, 80, 80);
        Hotel bridgeWood = new Hotel("BridgeWood", 150, 60, 4, 110, 50);
        Hotel ridgeWood = new Hotel("RidgeWood", 220, 150, 5, 100, 40);
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        hotel.findCheapestHotel("11Sep2020", "12 Sep2020", "Regular");
        hotel.findBestRatedHotel("11Sep2020", "12 Sep2020", "Reward");
        hotel.findCheapestHotelRewardCustomer("11Sep2020", "12 Sep2020", "Reward");
    }
}