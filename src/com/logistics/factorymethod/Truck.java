package com.logistics.factorymethod;

/**
 * Concrete Product for road delivery.
 */
public class Truck implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.println("Truck delivers " + cargo + " to " + destination);
    }
}
