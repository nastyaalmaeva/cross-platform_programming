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

        Property apartment1 = new Apartment(1000000, 50, "KAPT-12345", "123 Main St, City", 5, 2010);
        Property apartment2 = new Apartment(1500000, 75, "KAPT-23456", "456 Oak Ave, Town", 10, 2015);
        Property apartment3 = new Apartment(800000, 40, "KAPT-34567", "789 Pine Blvd, Village", 3, 2008);
        Property apartment4 = new Apartment(1200000, 60, "KAPT-45678", "101 Elm St, Metropolis", 15, 2018);
        Property apartment5 = new Apartment(950000, 55, "KAPT-56789", "202 Maple Rd, Suburb", 7, 2012);

        Property car1 = new Car(500000, 2.0, 2015, "A123BC", "Sedan", "BMW X5");
        Property car2 = new Car(300000, 1.6, 2010, "D456EF", "Hatchback", "Toyota Corolla");
        Property car3 = new Car(700000, 3.0, 2020, "G789HI", "SUV", "Audi Q7");
        Property car4 = new Car(250000, 1.8, 2017, "J012KL", "Sedan", "Honda Civic");
        Property car5 = new Car(450000, 2.4, 2019, "M345NO", "Crossover", "Mazda CX-5");

        Property house1 = new CountryHouse(2000000, 500, 100, "LAND-12345", "1 Country Lane, Rural", 2, 2005);
        Property house2 = new CountryHouse(1000000, 300, 80, "LAND-23456", "2 Forest Path, Countryside", 1, 2000);
        Property house3 = new CountryHouse(2500000, 600, 120, "LAND-34567", "3 Lake View, Outskirts", 3, 2012);
        Property house4 = new CountryHouse(1800000, 450, 95, "LAND-45678", "4 Mountain Rd, Highlands", 2, 2008);
        Property house5 = new CountryHouse(3000000, 700, 150, "LAND-56789", "5 Seaside Dr, Coast", 2, 2015);

        properties.addAll(Arrays.asList(
            apartment1, apartment2, apartment3, apartment4, apartment5,
            car1, car2, car3, car4, car5,
            house1, house2, house3, house4, house5
        ));
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
        scanner.nextLine();
        
        System.out.print("Enter the worth of the apartment: ");
        double worth = scanner.nextDouble();
        
        System.out.print("Enter the square of the apartment: ");
        int square = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter the cadastral number of the apartment: ");
        String cadastralNumber = scanner.nextLine();
        
        System.out.print("Enter the address of the apartment: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter the floors count of the apartment: ");
        int floorsCount = scanner.nextInt();
        
        System.out.print("Enter the construction year of the apartment: ");
        int constructionYear = scanner.nextInt();

        return new Apartment(worth, square, cadastralNumber, address, floorsCount, constructionYear);
    }

    private Car createCar() {
        System.out.println("*** Creating Car ***");
        scanner.nextLine();
        
        System.out.print("Enter the worth of the car: ");
        double worth = scanner.nextDouble();
        
        System.out.print("Enter the engine volume of the car: ");
        double volume = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter the year of manufacture of the car: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter the registration number of the car: ");
        String registrationNumber = scanner.nextLine();
        
        System.out.print("Enter the vehicle type of the car: ");
        String vehicleType = scanner.nextLine();
        
        System.out.print("Enter the make and model of the car: ");
        String makeAndModel = scanner.nextLine();

        return new Car(worth, volume, year, registrationNumber, vehicleType, makeAndModel);
    }

    private CountryHouse createCountryHouse() {
        System.out.println("*** Creating Country House ***");
        scanner.nextLine();
        
        System.out.print("Enter the worth of the country house: ");
        double worth = scanner.nextDouble();
        
        System.out.print("Enter the ownership square of the country house: ");
        int ownershipSquare = scanner.nextInt();
        
        System.out.print("Enter the house square of the country house: ");
        int houseSquare = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter the cadastral number of the country house: ");
        String cadastralNumber = scanner.nextLine();
        
        System.out.print("Enter the address of the country house: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter the floors count of the country house: ");
        int floorsCount = scanner.nextInt();
        
        System.out.print("Enter the construction year of the country house: ");
        int constructionYear = scanner.nextInt();

        return new CountryHouse(worth, ownershipSquare, houseSquare, cadastralNumber, address, floorsCount, constructionYear);
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