package com.bridgelabz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomReservationSystem {

    public static void main(String[] args) {

        List<Hotel> hotels = new ArrayList<>();

        hotels.add(new Hotel("Lakewood", 3, 110, 80, 90, 80));
        hotels.add(new Hotel("Bridgewood", 4, 160, 110, 60, 50));
        hotels.add(new Hotel("Ridgewood", 5, 220, 100, 150, 40));

        LocalDate fromDate = LocalDate.parse("2022-05-23");
        LocalDate toDate = LocalDate.parse("2022-05-31");

        String isCustomerType = "regular";

        Hotel cheapestHotelRoom = findCheapestHotelRoom(hotels, fromDate, toDate, isCustomerType);
        System.out.println("The cheapest hotel is: " + cheapestHotelRoom.getName() + " \tRegular rate : " + cheapestHotelRoom.getWeekdayRegularRate());
    }

    private static Hotel findCheapestHotelRoom(List<Hotel> hotels, LocalDate fromDate, LocalDate toDate, String customerType) {
        return hotels.stream()
                .min((hotel1, hotel2) -> (int) (hotel1.getTotalPrice(fromDate, toDate, customerType) - hotel2.getTotalPrice(fromDate, toDate, customerType)))
                .orElse(null);
    }

}