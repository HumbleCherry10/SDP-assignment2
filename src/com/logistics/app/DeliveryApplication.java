package com.logistics.app;

import com.logistics.abstractfactory.Button;
import com.logistics.abstractfactory.Checkbox;
import com.logistics.abstractfactory.GUIFactory;
import com.logistics.factorymethod.Logistics;

/**
 * Client application class combining Abstract Factory (UI components)
 * and Factory Method (Logistics delivery workflow).
 */
public class DeliveryApplication {
    private final Button button;
    private final Checkbox checkbox;
    private final Logistics logistics;

    /**
     * Constructor injecting abstractions.
     * Obtains UI components using the injected GUIFactory interface.
     *
     * @param factory Abstract factory for UI components
     * @param logistics Creator for transport delivery
     */
    public DeliveryApplication(GUIFactory factory, Logistics logistics) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
        this.logistics = logistics;
    }

    /**
     * Runs the application workflow: renders UI components and executes logistics delivery.
     *
     * @param cargo Description of goods to deliver
     * @param destination Delivery destination
     */
    public void run(String cargo, String destination) {
        button.render();
        checkbox.render();
        logistics.planDelivery(cargo, destination);
    }
}
