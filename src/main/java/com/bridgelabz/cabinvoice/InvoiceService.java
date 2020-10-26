package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceService {
    RidesRepository ridesRepository;
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

    public InvoiceService(){
        this.ridesRepository = new RidesRepository();
    }

    /**
     * @param userId and rides
     * @return void
     */
    public void addRides(String userId, Ride[] rides) {
        ridesRepository.addRides(userId, rides);
    }

    /**
     * @param userId
     * @return InvoiceSummary
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        List<Ride> ridesList = ridesRepository.getRidesData(userId);
        return calculateFare(ridesList.toArray(new Ride[ridesList.size()]));
    }
}
