package com.logistics.factorymethod;

/**
 * Concrete Creator for sea transportation.
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
