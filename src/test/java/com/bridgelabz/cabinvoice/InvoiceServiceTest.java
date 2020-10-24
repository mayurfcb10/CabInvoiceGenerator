package com.bridgelabz.cabinvoice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGeneratorService invoiceService = new InvoiceGeneratorService();
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
        InvoiceGeneratorService invoiceGenerator = new InvoiceGeneratorService();
        double distance  = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

}
