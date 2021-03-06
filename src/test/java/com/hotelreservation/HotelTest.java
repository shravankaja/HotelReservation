package com.hotelreservation;

import org.junit.jupiter.api.*;

public class HotelTest {
    @Test
    void checkHotelAdded() {
        ReservationSystem reservationSystem = new ReservationSystem();
        int result = reservationSystem.addHotel("LakeWood",4,110,120);
        Assertions.assertEquals(0, result);
    }
}
