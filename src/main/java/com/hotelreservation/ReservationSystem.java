package com.hotelreservation;

import java.util.*;

public class ReservationSystem {

    public static void main(String Args[]) {
        Hotel hotel = new Hotel();
        System.out.println("Welcome to hotel Reservation System");
        ReservationSystem reservationSystem = new ReservationSystem();
        Hotel lakeWood = new Hotel("LakeWood", 110);
        Hotel bridgeWood = new Hotel("BridgeWood", 130);
        Hotel ridgeWood = new Hotel("RidgeWood", 140);
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
    }
}