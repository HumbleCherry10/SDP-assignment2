package com.logistics.abstractfactory;

/**
 * Abstract Factory interface for creating family of UI components.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
