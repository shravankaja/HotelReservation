package com.hotelreservation;

import java.rmi.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Hotel {
    String name;
    int weekDayRate;
    int weekEndRate;
    int rating;
    int rewardWeekDayRate;
    int rewardWeekEndRate;
    ArrayList<Hotel> arrayOfHotels = new ArrayList<>();
    Map<String, Integer> costOfHotels = new HashMap<>();
    HashMap<String, String> monthsInYear = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> ratingOfHotels = new HashMap<>();
    Map<String, Integer> costOfHotelsRewardForCustomer = new HashMap<>();

    public Hotel(String name, int weekDayRate, int weekEndRate, int rating, int rewardWeekDayRate, int rewardWeekEndRate) {
        this.name = name;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rating = rating;
        this.rewardWeekDayRate = rewardWeekDayRate;
        this.rewardWeekEndRate = rewardWeekEndRate;
    }

    public Hotel() {

    }

    // method to add hotel
    public boolean addHotel(Hotel hotel) {
        arrayOfHotels.add(hotel);
        return true;
    }

    public int getRating() {
        return rating;
    }

    // method to find cheap hotel for given date range
    public int findCheapestHotel(String dateCheckIn, String dateCheckOut, String customerType) {
        int costReturn = 0;
        ratingOfHotels = arrayOfHotels.stream().collect(Collectors.toMap(e -> e.getHotelName(), e -> e.getRating()));
        String dayStart = dateCheckIn.substring(0, 2);
        int checkInDay = Integer.parseInt(dayStart);
        String dayEnd = dateCheckOut.substring(0, 2);
        int checkOutDay = Integer.parseInt(dayEnd);
        int numberOfDays = checkOutDay - checkInDay;
        int numberOfWeekEnds = noOfWeekDaysAndWeekEnds(dateCheckIn, dateCheckOut, numberOfDays, checkInDay, checkOutDay);
        numberOfDays = numberOfDays - numberOfWeekEnds;
        int finalNumberOfDays = numberOfDays;
        if (customerType.equals("Regular")) {
            costOfHotels = arrayOfHotels.stream().collect(Collectors.
                    toMap(e -> e.getHotelName(), e -> e.getWeekDayRate() * finalNumberOfDays + e.getWeekEndRate() * numberOfWeekEnds));
            int cost = Collections.min(costOfHotels.values());
            String hotel = costOfHotels.entrySet().stream().filter(e -> e.getValue().equals(cost)).map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);
            costReturn = cost;
        } else if (customerType.equals("Reward")) {
            costOfHotelsRewardForCustomer = arrayOfHotels.stream().collect(Collectors
                    .toMap(e -> e.getHotelName(), e -> e.getRewardWeekDayRate() * finalNumberOfDays + e.getRewardWeekEndRate() * numberOfWeekEnds));
            int cost = Collections.min(costOfHotelsRewardForCustomer.values());
            String hotel = costOfHotelsRewardForCustomer.entrySet().stream().filter(e -> e.getValue().equals(cost)).map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);
            costReturn = cost;
        } else {
            System.out.println("Please enter customer type as Regular or Reward");
        }
        return costReturn;
    }

    public static int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public String getHotelName() {
        return name;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public int getWeekEndRate() {
        return weekEndRate;
    }

    public String poplateMonths(String month) {
        monthsInYear.put("Sep", "SEPTEMBER");
        return monthsInYear.get(month);
    }

    // To calclate Number of WeekDays in the given date range
    public int noOfWeekDaysAndWeekEnds(String dateCheckIn, String dateCheckOut, int numOfDays, int checkIn, int checkOut) {
        int weekEndCount = 0;
        String month = dateCheckIn.substring(2, 5);
        String monthOfGivenDate = poplateMonths(month);
        String year = dateCheckIn.substring(5, 9);
        int yearOfGivenDate = Integer.parseInt(year);
        for (int i = checkIn; i <= checkOut; i++) {
            LocalDate localDate = LocalDate.of(yearOfGivenDate, Month.valueOf(monthOfGivenDate), i);
            DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
            if (dayOfWeek.name().equals("SATURDAY") || dayOfWeek.name().equals("SUNDAY")) {
                weekEndCount++;
            }
        }
        return weekEndCount;
    }

    //Method to find best rated hotel
    public int findBestRatedHotel(String dateCheckIn, String dateCheckout, String customerType) {
        findCheapestHotel(dateCheckIn, dateCheckout, customerType);
        ratingOfHotels = arrayOfHotels.stream().collect(Collectors.toMap(e -> e.getHotelName(), e -> e.getRating()));
        if ((costOfHotels.get("LakeWood") < costOfHotels.get("BridgeWood") &&
                ratingOfHotels.get("LakeWood") > ratingOfHotels.get("BridgeWood")) && (costOfHotels.get("LakeWood")
                < costOfHotels.get("RidgeWood") &&
                ratingOfHotels.get("LakeWood") > ratingOfHotels.get("RidgeWood"))) {
            return costOfHotels.get("LakeWood");
        }
        if ((costOfHotels.get("BridgeWood") < costOfHotels.get("LakeWood") &&
                ratingOfHotels.get("BridgeWood") > ratingOfHotels.get("LakeWood")) &&
                (costOfHotels.get("BridgeWood") < costOfHotels.get("RidgeWood") &&
                        ratingOfHotels.get("BridgeWood") > ratingOfHotels.get("RidgeWood"))) {
            return costOfHotels.get("BridgeWood");
        } else {
            return costOfHotels.get("RidgeWood");
        }
    }

    public int getRewardWeekDayRate() {
        return rewardWeekDayRate;
    }

    public int getRewardWeekEndRate() {
        return rewardWeekEndRate;
    }

    // Method to find Cheapest Hotel for Reward Customers
    public int findCheapestHotelRewardCustomer(String dateCheckIn, String dateCheckOut, String customerType) {
        int costReturn = 0;
        try {
            if (customerType.equals("Reward")) {
                findCheapestHotel(dateCheckIn, dateCheckOut, customerType);
                int cost = Collections.min(costOfHotelsRewardForCustomer.values());
                String hotel = costOfHotelsRewardForCustomer.entrySet().stream().filter(e -> e.getValue().equals(cost)).map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);
                costReturn = cost;
            } else {
                System.out.println("Please enter Reward as customer type");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return costReturn;
    }
}

