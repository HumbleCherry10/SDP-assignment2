package com.logistics.abstractfactory;

/**
 * Concrete Product for macOS Checkbox.
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering macOS checkbox");
    }
}
