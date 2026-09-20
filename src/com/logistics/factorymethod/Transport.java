package com.logistics.factorymethod;

/**
 * Product interface for logistics transport.
 * Defines the contract for all delivery mechanisms.
 */
public interface Transport {
    void deliver(String cargo, String destination);
}
