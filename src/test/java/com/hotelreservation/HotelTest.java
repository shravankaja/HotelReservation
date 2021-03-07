package com.hotelreservation;

import org.junit.jupiter.api.*;

import java.rmi.server.*;

public class HotelTest {
    ReservationSystem reservationSystem = new ReservationSystem();
    Hotel hotel = new Hotel();

    @Test
    void givenHotelNameAndRateCheckIfHotelIsAddedToSystem() {
        Hotel lakeWood = new Hotel("lkeWood", 110);
        hotel.addHotel(lakeWood);
        Assertions.assertTrue(hotel.arrayofHotel.contains(lakeWood));
    }
}


