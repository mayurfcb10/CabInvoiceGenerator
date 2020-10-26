package com.bridgelabz.cabinvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService;

    @Before
    public void setUp() throws Exception  {
        invoiceService = new InvoiceService();
    }

    /* Print Welcome Message */
    @Test
    public void printWelcomeMessage() {
        invoiceService.printWelcomeMessage();
    }

    /* Test Case given for distance and time gives total cost  */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance  = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    /* Test Case given for less distance and time gives minimum cost  */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        double distance  = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    /* Test Case to check total Fare of multiple rides for given Distance and Time */
    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary(){
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        String userId = "mayurfcb005";
        invoiceService.addRides(userId,rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
