package Exercise2;

public class FeeCalculator {
    // Constants
    private static final double STANDARD_RATE = 1500.0;
    private static final double URGENT_RATE = 2500.0;
    private static final double GROUP_RATE = 1200.0;
    private static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    // Calculates base fee based on booking type
    public static double calculateBaseFee(String bookingType, int hours){
        double rate = STANDARD_RATE;

        if(bookingType.equals("GROUP")){
            rate = GROUP_RATE;
        }
        else if(bookingType.equals("URGENT")){
            rate = URGENT_RATE;
        }
        return rate*hours;
    }

    // Calculates platform fee (15% of base fee)
    public static double calculatePlatformFee(double baseFee){
        return baseFee*PLATFORM_FEE_PERCENTAGE;
    }

    // Calculates total (base + platform fee)
    public static double calculateTotal(String bookingType, int hours){
        double baseFee = calculateBaseFee(bookingType, hours);
        double platformFee = calculatePlatformFee(baseFee);

        return baseFee + platformFee;
        }

}

