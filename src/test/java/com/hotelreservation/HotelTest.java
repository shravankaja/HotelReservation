package com.hotelreservation;

import org.junit.jupiter.api.*;

public class HotelTest {
    ReservationSystem reservationSystem = new ReservationSystem();
    Hotel hotel = new Hotel();
    Hotel lakeWood = new Hotel("LakeWood", 110, 90);
    Hotel bridgeWood = new Hotel("BridgeWood", 150, 50);
    Hotel ridgeWood = new Hotel("RidgeWood", 220, 150);

    @Test
    void givenHotelNameAndRateCheckIfHotelIsAddedToSystem() {
        Hotel lakeWood = new Hotel("LakeWood", 110, 90);
        hotel.addHotel(lakeWood);
        Assertions.assertTrue(hotel.arrayOfHotels.contains(lakeWood));
    }


    @Test
    void givenDateRangeWeShouldGetHotelWithMinimumPrice() {
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        Assertions.assertEquals(330, hotel.findCheapestHotel("12Sep2020", "15Sep2020"));
    }

    @Test
    void givenDateRangeWeShouldGetPriceAccordingToWeekDayAndWeekEnds() {
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        Assertions.assertEquals(1530, hotel.findCheapestHotel("12Sep2020", "27Sep2020"));
    }
}


