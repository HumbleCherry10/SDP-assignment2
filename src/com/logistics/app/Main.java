package com.logistics.app;

import com.logistics.abstractfactory.GUIFactory;
import com.logistics.abstractfactory.MacOSFactory;
import com.logistics.abstractfactory.WindowsFactory;
import com.logistics.factorymethod.Logistics;
import com.logistics.factorymethod.RoadLogistics;
import com.logistics.factorymethod.SeaLogistics;

import java.util.Scanner;

/**
 * Main application entry point.
 * Handles configuration startup, input validation, object assembly, and execution.
 */
public class Main {

    private static final String DEFAULT_CARGO = "laboratory equipment";
    private static final String DEFAULT_DESTINATION = "Aktau warehouse";

    public static void main(String[] args) {
        String deliveryModeInput;
        String uiPlatformInput;

        if (args.length >= 2) {
            deliveryModeInput = args[0].trim();
            uiPlatformInput = args[1].trim();
            executeConfig(deliveryModeInput, uiPlatformInput, false);
        } else if (args.length == 1) {
            System.err.println("Error: Insufficient command-line arguments. Expected 2 arguments: <DELIVERY_MODE> <UI_PLATFORM>");
            System.err.println("Example: java com.logistics.app.Main ROAD WINDOWS");
        } else {
            // Interactive mode
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("=== Logistics Application Startup ===");
                System.out.print("Enter Delivery Mode (ROAD / SEA): ");
                deliveryModeInput = scanner.nextLine().trim();

                System.out.print("Enter UI Platform (WINDOWS / MACOS): ");
                uiPlatformInput = scanner.nextLine().trim();

                executeConfig(deliveryModeInput, uiPlatformInput, true);
            }
        }
    }

    /**
     * Validates input choices, selects appropriate concrete factories, and runs the application.
     */
    private static void executeConfig(String deliveryMode, String uiPlatform, boolean isInteractive) {
        Logistics logistics = createLogistics(deliveryMode);
        GUIFactory guiFactory = createGUIFactory(uiPlatform);

        if (logistics == null || guiFactory == null) {
            if (logistics == null) {
                System.err.println("Error: Unsupported or missing delivery mode '" + deliveryMode + "'. Allowed values: ROAD, SEA.");
            }
            if (guiFactory == null) {
                System.err.println("Error: Unsupported or missing UI platform '" + uiPlatform + "'. Allowed values: WINDOWS, MACOS.");
            }
            return;
        }

        // Print selected choices as required by assignment specification
        System.out.println("Delivery mode: " + deliveryMode.toUpperCase());
        System.out.println("UI platform: " + uiPlatform.toUpperCase());

        // Create client application and execute workflow
        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run(DEFAULT_CARGO, DEFAULT_DESTINATION);
    }

    private static Logistics createLogistics(String deliveryMode) {
        if (deliveryMode == null) {
            return null;
        }
        return switch (deliveryMode.toUpperCase()) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> null;
        };
    }

    private static GUIFactory createGUIFactory(String uiPlatform) {
        if (uiPlatform == null) {
            return null;
        }
        return switch (uiPlatform.toUpperCase()) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> null;
        };
    }
}
