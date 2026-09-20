package com.logistics.factorymethod;

/**
 * Concrete Creator for road transportation.
 */
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
