package constants;

public final class PlatformConstants {

    // Booking rules
    public static final int MIN_BOOKING_HOURS = 1;
    public static final int MAX_BOOKING_HOURS = 4;
    public static final int MAX_ADVANCE_BOOKING_DAYS = 30;

    // Fee structure
    public static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    // Prevent instantiation
    private PlatformConstants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
