import properties.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Property> propertyList = new ArrayList<>();

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

            addIfUnique(propertyList, luxuryApartment);
            addIfUnique(propertyList, sportsCar);
            addIfUnique(propertyList, countrysideCottage);
            addIfUnique(propertyList, downtownApartment);
            addIfUnique(propertyList, familyCar);
            addIfUnique(propertyList, summerHouse);
            addIfUnique(propertyList, cozyApartment);
            addIfUnique(propertyList, vintageCar);
            addIfUnique(propertyList, luxuryVilla);
            addIfUnique(propertyList, modernApartment);

            System.out.println("Налоги на имущество:");
            for (Property property : propertyList) {
                System.out.println(property + "\n" + "Налог: " + String.format("%.2f", property.calculateTax()));
                System.out.println();
            }
        }
        catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void addIfUnique(List<Property> properties, Property property) {
        if (!properties.contains(property)) {
            properties.add(property);
        } else {
            throw new IllegalArgumentException("Имущество уже существует: " + property);
        }
    }
}
