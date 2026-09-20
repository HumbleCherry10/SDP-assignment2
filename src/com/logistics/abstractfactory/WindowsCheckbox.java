package com.logistics.abstractfactory;

/**
 * Concrete Product for Windows Checkbox.
 */
public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Windows checkbox");
    }
}
