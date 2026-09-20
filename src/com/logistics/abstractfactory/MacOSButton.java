package com.logistics.abstractfactory;

/**
 * Concrete Product for macOS Button.
 */
public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering macOS button");
    }
}
