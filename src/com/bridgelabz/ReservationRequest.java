package com.bridgelabz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationRequest {

    //Rating Type
    private RateType rateType;

    //Customer Type
    private CustomerType customerType;

    //Date you want to book the room
    List<LocalDate> dates;

    public ReservationRequest(String userRequest) {
        this.rateType = RateType.fromUser(userRequest);
        this.customerType = CustomerType.fromUser(userRequest);
        this.dates = dateFrom(userRequest);
    }
    // 23-05-2022  to 31-05-2022
    public List<LocalDate> dateFrom(String userRequest) {
        List<LocalDate> dateOfRequest = new ArrayList<>();
        String dateRegex = "^\\d{2}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(userRequest);
        boolean matches = matcher.matches();
        if (matches) {
            for (int i = 0;i < matcher.groupCount(); i++)
            {
                dateOfRequest.add(dateFrom(matcher.group(i)));
            }
        }
        return dateOfRequest;
    }

//    public LocalDate datesFrom (String time) {
//        return new LocalDate(DateTimeFormatter.ofPattern("dMMMy").parse(time));
//    }
}
