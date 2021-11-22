package com.baeldung.java_8_features;

public class T01_defaultmethod {
    public static void main(String[] args) {
        Vehicle vehicle = new VehicleImpl();
        String overview = vehicle.getOverview();
        System.out.println(overview);
    }
}
