package util;

import constants.PlatformConstants;

public final class FeeCalculator {

    private FeeCalculator() {}

    public static double calculateBaseFee(double hourlyRate, int hours) {
        return hourlyRate * hours;
    }

    public static double calculatePlatformFee(double baseFee) {
        return baseFee * PlatformConstants.PLATFORM_FEE_PERCENTAGE;
    }

    public static double calculateTotal(double hourlyRate, int hours) {
        double base = calculateBaseFee(hourlyRate, hours);
        return base + calculatePlatformFee(base);
    }
}
