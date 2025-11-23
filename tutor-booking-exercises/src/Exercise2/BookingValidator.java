package Exercise2;

import java.time.LocalDateTime;

public class BookingValidator {
    // Validates if booking time is in the future
    public static boolean isValidBookingTime(LocalDateTime bookingTime){
        return bookingTime.isAfter(LocalDateTime.now());
    }

    // Validates if duration is between 1 - 4 hours
    public static boolean isValidDuration(int hours){
        return hours >= 1 && hours <= 4;
    }

    // Validates if time slot doesn't overlap with existing booking
    public static boolean isSlotAvailable(
        LocalDateTime newStart,
        LocalDateTime newEnd,
        LocalDateTime existingStart,
        LocalDateTime existingEnd
    ){
        boolean overlaps = newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart);

        return !overlaps;
    }
}