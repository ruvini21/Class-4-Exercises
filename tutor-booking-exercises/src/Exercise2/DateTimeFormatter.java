package Exercise2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class MyDateTimeFormatter {

    // Formats to: "2025-11-16 14:30"
    public static String formatDateTime(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
    }

    // Formats to: "November 16, 2025"
    public static String formatDateLong(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return dateTime.format(formatter);
    }

    // Formats to: "2:30 PM"
    public static String formatTime(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return dateTime.format(formatter);
    }
}
