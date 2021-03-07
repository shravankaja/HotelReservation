package com.hotelreservation;

import org.junit.jupiter.api.*;

public class HotelTest {
    ReservationSystem reservationSystem = new ReservationSystem();
    Hotel hotel = new Hotel();

    @Test
    void givenHotelNameAndRateCheckIfHotelIsAddedToSystem() {
        Hotel lakeWood = new Hotel("lkeWood", 110);
        hotel.addHotel(lakeWood);
        Assertions.assertTrue(hotel.arrayofHotels.contains(lakeWood));
    }

    @Test
    void givenDateRangeWeShouldGetHotelWithMinimumPrice() {
        Hotel lakeWood = new Hotel("LakeWood", 160);
        Hotel bridgeWood = new Hotel("BridgeWood", 170);
        Hotel ridgeWood = new Hotel("RidgeWood", 140);
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        Assertions.assertEquals(510,hotel.findCheapestHotel("12Sep2020","15Sep2020"));
    }
}
