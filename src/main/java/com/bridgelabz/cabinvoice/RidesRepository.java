package com.bridgelabz.cabinvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RidesRepository {
    private HashMap<String, List<Ride>> ridesData;
    public RidesRepository(){
        this.ridesData = new HashMap<String, List<Ride>>();
    }

    public void addRides(String userId, Ride[] rides){
        List<Ride> userRides = ridesData.get(userId);
        if(userRides == null){
            ridesData.put(userId, Arrays.asList(rides));
        }
    }

    /**
     * @param userId
     * @return List of rides
     */
    public List<Ride> getRidesData(String userId) {
        return ridesData.get(userId);
    }
}
