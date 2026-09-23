# Software Design Patterns - Assignment 2: Factory Method & Abstract Factory

**Course:** ShP-2216 Software Design Patterns (2026-2027)  
**Institution:** Astana IT University | School of Software Engineering  
**Student:** Dias Tursynbay  
**Group:** SE-2537  
**Repository:** [https://github.com/HumbleCherry10/SDP-assignment2.git](https://github.com/HumbleCherry10/SDP-assignment2.git)  

---

## 1. Project Purpose

This application demonstrates the combination of two fundamental creational design patterns in Java 17:
1. **Factory Method Pattern (Part A):** Manages logistics transport creation (`Truck` vs `Ship`) via concrete creators (`RoadLogistics` and `SeaLogistics`) adhering to the abstract `Logistics` creator workflow contract.
2. **Abstract Factory Pattern (Part B):** Manages cross-platform UI component families (`Windows` vs `macOS` buttons and checkboxes) created by concrete factories (`WindowsFactory` and `MacOSFactory`) adhering to the `GUIFactory` contract.
3. **Application Client:** Integrates both patterns inside `DeliveryApplication`, enforcing dependency inversion, high cohesion, and strict encapsulation.

---

## 2. Package Structure

```
SDP/
├── src/
│   └── com/
│       └── logistics/
│           ├── factorymethod/        # Part A: Factory Method Pattern
│           │   ├── Transport.java         # Product Interface
│           │   ├── Truck.java             # Concrete Product (Road)
│           │   ├── Ship.java              # Concrete Product (Sea)
│           │   ├── Logistics.java         # Creator Abstract Class
│           │   ├── RoadLogistics.java     # Concrete Creator (Road)
│           │   └── SeaLogistics.java      # Concrete Creator (Sea)
│           ├── abstractfactory/      # Part B: Abstract Factory Pattern
│           │   ├── Button.java            # Abstract Product Interface
│           │   ├── Checkbox.java          # Abstract Product Interface
│           │   ├── WindowsButton.java     # Concrete Product
│           │   ├── MacOSButton.java       # Concrete Product
│           │   ├── WindowsCheckbox.java   # Concrete Product
│           │   ├── MacOSCheckbox.java     # Concrete Product
│           │   ├── GUIFactory.java        # Abstract Factory Interface
│           │   ├── WindowsFactory.java    # Concrete Factory
│           │   └── MacOSFactory.java      # Concrete Factory
│           └── app/                  # Application Integration
│               ├── DeliveryApplication.java # Client application
│               └── Main.java              # Startup driver & validation
├── uml/                              # UML Diagrams
│   ├── factory_method.md              # Factory Method Mermaid UML
│   └── abstract_factory.md            # Abstract Factory Mermaid UML
└── README.md                         # Documentation & build instructions
```

---

## 3. Prerequisites

- **Java Development Kit (JDK 17 or higher)**
- Terminal / Command Prompt / PowerShell

To verify your Java installation:
```bash
java -version
javac -version
```

---

## 4. Build and Run Instructions

### Step 1: Compile Java Source Files
Compile all Java files into the `bin/` directory:
```bash
javac -d bin -sourcepath src src/com/logistics/app/Main.java
```

### Step 2: Run Application

#### Option A: Command-Line Arguments Mode
Run passing `<DELIVERY_MODE>` and `<UI_PLATFORM>` as command line parameters:
```bash
java -cp bin com.logistics.app.Main ROAD WINDOWS
```

#### Option B: Interactive Console Input Mode
Run without command-line arguments to enter interactive mode:
```bash
java -cp bin com.logistics.app.Main
```
*You will be prompted to enter the delivery mode and UI platform.*

---

## 5. Supported Input Values

- **Delivery Modes:** `ROAD`, `SEA` (case-insensitive)
- **UI Platforms:** `WINDOWS`, `MACOS` (case-insensitive)

---

## 6. Verification Results

| Check | Input | Expected Result | Actual Output | Status |
|---|---|---|---|---|
| **1** | `ROAD + WINDOWS` | Truck delivery; Windows button and checkbox | Delivery mode: ROAD<br>UI platform: WINDOWS<br>Rendering Windows button<br>Rendering Windows checkbox<br>Truck delivers laboratory equipment to Astana warehouse | **PASS** |
| **2** | `SEA + WINDOWS` | Ship delivery; Windows button and checkbox | Delivery mode: SEA<br>UI platform: WINDOWS<br>Rendering Windows button<br>Rendering Windows checkbox<br>Ship delivers laboratory equipment to Astana warehouse | **PASS** |
| **3** | `ROAD + MACOS` | Truck delivery; macOS button and checkbox | Delivery mode: ROAD<br>UI platform: MACOS<br>Rendering macOS button<br>Rendering macOS checkbox<br>Truck delivers laboratory equipment to Astana warehouse | **PASS** |
| **4** | `SEA + MACOS` | Ship delivery; macOS button and checkbox | Delivery mode: SEA<br>UI platform: MACOS<br>Rendering macOS button<br>Rendering macOS checkbox<br>Ship delivers laboratory equipment to Astana warehouse | **PASS** |
| **5** | `AIR + WINDOWS` | Clear validation message; no delivery | `Error: Unsupported or missing delivery mode 'AIR'. Allowed values: ROAD, SEA.` | **PASS** |
| **6** | `ROAD + LINUX` | Clear validation message; no UI construction | `Error: Unsupported or missing UI platform 'LINUX'. Allowed values: WINDOWS, MACOS.` | **PASS** |

---

## 7. Clean Code Principles Applied

1. **Meaningful Names:** Descriptive names clearly distinguish roles (`Transport`, `Logistics`, `RoadLogistics`, `GUIFactory`, `WindowsFactory`, `DeliveryApplication`).
2. **Small Methods & Single Responsibility:** Methods like `createTransport()`, `createButton()`, `render()`, `deliver()`, and `executeConfig()` each have a single focused task.
3. **Avoid Duplicated Logic:** Shared logistics execution workflow is localized strictly inside `Logistics.planDelivery(...)` rather than duplicated in client code.
4. **Data Abstraction (Clean Code Ch. 6):** Callers depend exclusively on interface contracts (`Transport`, `Button`, `Checkbox`, `GUIFactory`), hiding all concrete implementation details.
5. **Objects and Encapsulation (Clean Code Ch. 6):** Client object `DeliveryApplication` encapsulates its UI components as `private final` fields, exposing behavior methods instead of public accessors or mutable data structures.
