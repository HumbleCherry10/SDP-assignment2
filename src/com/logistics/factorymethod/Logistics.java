package com.logistics.factorymethod;

/**
 * Creator class declaring the factory method.
 * Contains core delivery workflow logic that relies on the Transport product interface.
 */
public abstract class Logistics {

    /**
     * Factory Method to be overridden by concrete creators.
     * @return a specific Transport instance
     */
    public abstract Transport createTransport();

    /**
     * Shared delivery workflow logic.
     * @param cargo description of items to transport
     * @param destination target location
     */
    public void planDelivery(String cargo, String destination) {
        Transport transport = createTransport();
        transport.deliver(cargo, destination);
    }
}
