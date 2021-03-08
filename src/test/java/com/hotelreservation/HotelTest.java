package com.hotelreservation;

import org.junit.jupiter.api.*;

public class HotelTest {
    ReservationSystem reservationSystem = new ReservationSystem();
    Hotel hotel = new Hotel();
    Hotel lakeWood = new Hotel("LakeWood", 110, 90, 3, 80, 80);
    Hotel bridgeWood = new Hotel("BridgeWood", 150, 60, 4, 110, 50);
    Hotel ridgeWood = new Hotel("RidgeWood", 220, 150, 5, 100, 40);

    public void addHotels() {
        hotel.addHotel(lakeWood);
        hotel.addHotel(bridgeWood);
        hotel.addHotel(ridgeWood);
    }

    @Test
    void givenHotelNameAndRateCheckIfHotelIsAddedToSystem() {
        Hotel lakeWood = new Hotel("LakeWood", 110, 90, 3, 80, 80);
        hotel.addHotel(lakeWood);
        Assertions.assertTrue(hotel.arrayOfHotels.contains(lakeWood));
    }

    @Test
    void givenDateRangeWeShouldGetHotelWithMinimumPrice() throws HotelExceptions {
        try {
            addHotels();
            Assertions.assertEquals(270, hotel.findCheapestHotel("12Sep2020", "15Sep2020", "Regular"));
        } catch (HotelExceptions e) {
            System.out.println(e);
        }
    }

    @Test
    void givenDateRangeWeShouldGetPriceAccordingToWeekDayAndWeekEnds() {
        try {
            addHotels();
            Assertions.assertEquals(270, hotel.findCheapestHotel("12Sep2020", "15Sep2020", "Regular"));
        } catch (HotelExceptions e) {
            System.out.println(e);
        }
    }

    @Test
    void givenRatingShouldBeAcceptedAndBindedToHotel() {
        hotel.addHotel(lakeWood);
        int rating = lakeWood.getRating();
        Assertions.assertEquals(3, rating);
    }

    @Test
    void givenDateRangeWeShoudlObtainCheapestHotelWithRating() {
        try {
            addHotels();
            Assertions.assertEquals(60, hotel.findCheapestHotel("11Sep2020", "12Sep2020", "Regular"));
            Assertions.assertEquals(4, hotel.ratingOfHotels.get("BridgeWood"));
        } catch (HotelExceptions e) {
            System.out.println(e);
        }
    }

    @Test
    void givenDateRangeWeShoudlObtainBestRatedHotel() {
        addHotels();
        Assertions.assertEquals(150, hotel.findBestRatedHotel("11Sep2020", "12Sep2020", "Regular"));
        Assertions.assertEquals(5, hotel.ratingOfHotels.get("RidgeWood"));
    }

    @Test
    void givenRewardCustomersRatesShouldBeAssociatedWithEachHotel() {
        addHotels();
        Assertions.assertEquals(80, lakeWood.getRewardWeekDayRate());
    }

    @Test
    void givenDateRangeRewardCustomersShouldBeAbleToFindCheapestHotel() {
        addHotels();
        Assertions.assertEquals(40, hotel.
                findCheapestHotelRewardCustomer("11Sep2020", "12Sep2020", "Reward"));
    }


    @Test
    void givenDateRangeWeShoudlObtainBestRatedAndCheapestHotelRewardCustomer() {
        addHotels();
        Assertions.assertEquals(40, hotel.
                findBestRatedAndCheapestHotelRewardCustomer("11Sep2020", "12Sep2020", "Reward"));
        Assertions.assertEquals(5, hotel.ratingOfHotels.get("RidgeWood"));
    }

    @Test
    void givenDateRangeWeShouldObtainBestRatedAndCheapestHotelForRegular() {
        addHotels();
        Assertions.assertEquals(60, hotel.
                findBestAndCheapestHotelRegular("11Sep2020", "12Sep2020", "Regular"));
        Assertions.assertEquals(4, hotel.ratingOfHotels.get("BridgeWood"));
    }

}


