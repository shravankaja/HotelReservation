package com.hotelreservation;

import org.junit.jupiter.api.*;

public class HotelTest {
    ReservationSystem reservationSystem = new ReservationSystem();
    Hotel hotel = new Hotel();
    Hotel lakeWood = new Hotel("LakeWood", 110, 90, 3);
    Hotel bridgeWood = new Hotel("BridgeWood", 150, 50, 4);
    Hotel ridgeWood = new Hotel("RidgeWood", 220, 150, 5);

    @Test
    void givenHotelNameAndRateCheckIfHotelIsAddedToSystem() {
        Hotel lakeWood = new Hotel("LakeWood", 110, 90, 3);
        hotel.addHotel(lakeWood);
        Assertions.assertTrue(hotel.arrayOfHotels.contains(lakeWood));
    }

    @Test
    void givenDateRangeWeShouldGetHotelWithMinimumPrice() {
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        Assertions.assertEquals(250, hotel.findCheapestHotel("12Sep2020", "15Sep2020"));
    }

    @Test
    void givenDateRangeWeShouldGetPriceAccordingToWeekDayAndWeekEnds() {
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        Assertions.assertEquals(50, hotel.findCheapestHotel("11Sep2020", "12Sep2020"));
    }

    @Test
    void givenRatingShouldBeAcceptedAndBindedToHotel() {
        hotel.addHotel(lakeWood);
        int rating = lakeWood.getRating();
        Assertions.assertEquals(3, rating);
    }

    @Test
    void givenDateRangeWeShoudlObtainCheapestHotelWithRating() {
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
        Assertions.assertEquals(50, hotel.findCheapestHotel("11Sep2020", "12Sep2020"));
        Assertions.assertEquals(4, hotel.ratingOfHotels.get("BridgeWood"));
    }
}


