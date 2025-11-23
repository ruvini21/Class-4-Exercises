package util;

public final class IdGenerator {

    private static int studentCounter = 1;
    private static int mentorCounter = 1;
    private static int bookingCounter = 1;

    private IdGenerator() {}

    public static synchronized String generateStudentId() {
        return String.format("STU-%03d", studentCounter++);
    }

    public static synchronized String generateMentorId() {
        return String.format("MEN-%03d", mentorCounter++);
    }

    public static synchronized String generateBookingId() {
        return String.format("BK-%03d", bookingCounter++);
    }
}
