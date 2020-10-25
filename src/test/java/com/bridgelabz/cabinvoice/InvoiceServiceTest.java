package com.bridgelabz.cabinvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGeneratorService invoiceGenerator;

    @Before
    public void setUp() throws Exception  {
        invoiceGenerator = new InvoiceGeneratorService();
    }

    /* Print Welcome Message */
    @Test
    public void printWelcomeMessage() {
        invoiceGenerator.printWelcomeMessage();
    }

    /* Test Case given for distance and time gives total cost  */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance  = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    /* Test Case given for less distance and time gives minimum cost  */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare(){
        double distance  = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    /* Test Case to check total Fare of multiple rides for given Distance and Time */
    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary(){
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}
