package com.bridgelabz.cabinvoice;

public class InvoiceGeneratorService {
    private static final double MINIMUM_COST_PER_KM = 10 ;
    private static final int MINIMUM_COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Cab Invoice Generator");
    }

    /**
     * @param distance
     * @param time
     * @return total Fare for given Distance and Time
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * MINIMUM_COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * @param rides
     * @return total fare calculation for multiple rides
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride:rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
