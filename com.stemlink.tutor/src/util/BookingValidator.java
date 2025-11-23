package util;

import constants.PlatformConstants;

import java.time.LocalDateTime;

public final class BookingValidator {

    private BookingValidator() {}

    public static boolean isValidDuration(int hours) {
        return hours >= PlatformConstants.MIN_BOOKING_HOURS &&
                hours <= PlatformConstants.MAX_BOOKING_HOURS;
    }

    public static boolean isValidBookingTime(LocalDateTime time) {
        return time.isAfter(LocalDateTime.now());
    }
}
