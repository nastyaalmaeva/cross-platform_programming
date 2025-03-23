package ui;

import properties.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner;
    private ArrayList<Property> properties;

    public UserInteraction(ArrayList<Property> properties) {
        this.scanner = new Scanner(System.in);
        this.properties = properties;
    }

    public void inputMainChoice() {
        clearConsole();
        System.out.println("Choose an action: ");
        System.out.println(" 1) Add Property");
        System.out.println(" 2) Delete Property");
        System.out.println(" 3) Sell Property");
        System.out.println(" 4) Transfer Property");
        System.out.println(" 5) Display information about all properties");
        System.out.println(" 6) Restore an example list of properties");
        System.out.println(" 7) Clear the list of properties");
        System.out.println(" 8) Exit");
        System.out.println();

        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            try {
                Property newProperty = inputChoiceCreateProperty();
                if (newProperty != null) {
                    addIfUnique(newProperty);
                    System.out.println("Property added successfully.");
                    waitForKeyPress();
                }
            } catch (Exception e) {
                System.err.println("Error during property creation: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 2) {
            try {
                if (properties.isEmpty()) {
                    System.out.println("List of properties is empty.");
                    waitForKeyPress();
                } else {
                    inputChoiceDeleteProperty();
                    System.out.println("Property deleted successfully.");
                    waitForKeyPress();
                }
            } catch (Exception e) {
                System.err.println("Error during property deletion: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 3) {
            try {
                if (properties.isEmpty()) {
                    System.out.println("List of properties is empty.");
                    waitForKeyPress();
                } else {
                    inputChoiceSellProperty();
                    waitForKeyPress();
                }
            } catch (Exception e) {
                System.err.println("Error during selling property: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 4) {
            try {
                if (properties.isEmpty()) {
                    System.out.println("List of properties is empty.");
                    waitForKeyPress();
                } else {
                    inputChoiceTransferProperty();
                    waitForKeyPress();
                }
            } catch (Exception e) {
                System.err.println("Error during transferring property: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 5) {
            try {
                showAllProperties();
                waitForKeyPress();
            } catch (Exception e) {
                System.err.println("Error during showing all properties: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 6) {
            try {
                restoreExampleList();
                System.out.println("Example list of properties has been restored.");
                waitForKeyPress();
            } catch (Exception e) {
                System.err.println("Error during restoring example list: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 7) {
            try {
                properties.clear();
                System.out.println("List of properties cleared successfully.");
                waitForKeyPress();
            } catch (Exception e) {
                System.err.println("Error during clearing the list: " + e.getMessage());
                waitForKeyPress();
            }
        } else if (choice == 8) {
            System.out.println("Exiting the application.");
            waitForKeyPress();
            System.exit(0);
        } else {
            System.out.println("Incorrect choice.");
            waitForKeyPress();
        }
    }

    private Property inputChoiceCreateProperty() {
        clearConsole();
        System.out.println("Choose a property type to create: ");
        System.out.println(" 1) Apartment");
        System.out.println(" 2) Car");
        System.out.println(" 3) Country House");
        System.out.println(" 4) Go back to menu");
        System.out.println();

        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return createApartment();
            case 2:
                return createCar();
            case 3:
                return createCountryHouse();
            default:
                return null;
        }
    }

    private void inputChoiceDeleteProperty() {
        showAllProperties();

        if (!properties.isEmpty()) {
            System.out.println();
            System.out.print("Enter the number of the property to delete: ");

            int number = scanner.nextInt();

            if (number < 1 || number > properties.size()) {
                throw new IndexOutOfBoundsException("Invalid property number.");
            }

            properties.remove(number - 1);
        }
    }

	private void inputChoiceSellProperty() {
        showAllProperties();

        if (!properties.isEmpty()) {
            System.out.println();
            System.out.print("Enter the number of the property to sell: ");

            int number = scanner.nextInt();

            if (number < 1 || number > properties.size()) {
                throw new IndexOutOfBoundsException("Invalid property number.");
            }

            Property propertyToSell = properties.get(number - 1);
            propertyToSell.sell();
        }
    }

    private void inputChoiceTransferProperty() {
        showAllProperties();

        if (!properties.isEmpty()) {
            System.out.println();
            System.out.print("Enter the number of the property to transfer: ");

            int number = scanner.nextInt();

            if (number < 1 || number > properties.size()) {
                throw new IndexOutOfBoundsException("Invalid property number.");
            }

            Property propertyToTransfer = properties.get(number - 1);
            propertyToTransfer.transfer();
        }
    }

    private void showAllProperties() {
        System.out.println("*** List of Properties ***");
        if (properties.isEmpty()) {
            System.out.println("List of properties is empty.");
        } else {
            for (int index = 0; index < properties.size(); index++) {
                System.out.println("Property #" + (index + 1));
                System.out.println(properties.get(index));
                System.out.println("****************************");
            }
        }
    }

    private void restoreExampleList() {
        properties.clear();

        Property luxuryApartment = new Apartment(1000000, 50);
        Property sportsCar = new Car(500000, 2, 2015);
        Property countrysideCottage = new CountryHouse(2000000, 500, 100);
        Property downtownApartment = new Apartment(1500000, 75);
        Property familyCar = new Car(300000, 1.6, 2010);
        Property summerHouse = new CountryHouse(1000000, 300, 80);
        Property cozyApartment = new Apartment(800000, 40);
        Property vintageCar = new Car(700000, 3.0, 2020);
        Property luxuryVilla = new CountryHouse(2500000, 600, 120);
        Property modernApartment = new Apartment(1200000, 60);

        properties.addAll(Arrays.asList(luxuryApartment, sportsCar, countrysideCottage, downtownApartment,
                familyCar, summerHouse, cozyApartment, vintageCar, luxuryVilla, modernApartment));
    }

    private void addIfUnique(Property property) {
        if (!properties.contains(property)) {
            properties.add(property);
        } else {
            System.out.println("Property already exists in the list.");
        }
    }

    private Apartment createApartment() {
        System.out.println("*** Creating Apartment ***");
        System.out.print("Enter the worth of the apartment: ");
        double worth = scanner.nextDouble();
        System.out.print("Enter the square of the apartment: ");
        int square = scanner.nextInt();

        return new Apartment(worth, square);
    }

    private Car createCar() {
        System.out.println("*** Creating Car ***");
        System.out.print("Enter the worth of the car: ");
        double worth = scanner.nextDouble();
        System.out.print("Enter the engine volume of the car: ");
        double volume = scanner.nextDouble();
        System.out.print("Enter the year of manufacture of the car: ");
        int year = scanner.nextInt();

        return new Car(worth, volume, year);
    }

    private CountryHouse createCountryHouse() {
        System.out.println("*** Creating Country House ***");
        System.out.print("Enter the worth of the country house: ");
        double worth = scanner.nextDouble();
        System.out.print("Enter the ownership square of the country house: ");
        int ownershipSquare = scanner.nextInt();
        System.out.print("Enter the house square of the country house: ");
        int houseSquare = scanner.nextInt();

        return new CountryHouse(worth, ownershipSquare, houseSquare);
    }

    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Failed to clear console: " + e.getMessage());
        }
    }

    private void waitForKeyPress() {
        System.out.print("Press any key to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }
}