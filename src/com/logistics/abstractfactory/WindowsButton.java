package com.logistics.abstractfactory;

/**
 * Concrete Product for Windows Button.
 */
public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows button");
    }
}
