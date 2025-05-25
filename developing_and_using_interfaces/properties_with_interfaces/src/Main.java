import properties.*;
import interfaces.RealEstateOwnership;
import interfaces.VehicleOwnership;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Property> propertyList = new ArrayList<>();
            
            Property luxuryApartment = new Apartment(1000000, 50, "77:01:0001001:1234", "г. Москва, ул. Тверская, д. 1");
            Property sportsCar = new Car(500000, 2.0, 2015, "A777AA77");
            Property countrysideCottage = new CountryHouse(2000000, 500, 100, "50:08:0040115:567", "Московская обл., Одинцовский р-н, дер. Жуковка, д. 10");
            Property downtownApartment = new Apartment(1500000, 75, "77:02:0002002:5678", "г. Москва, ул. Арбат, д. 5");
            Property familyCar = new Car(300000, 1.6, 2010, "B123BB177");
            Property summerHouse = new CountryHouse(1000000, 300, 80, "50:09:0070220:890", "Московская обл., Солнечногорский р-н, дер. Лопотово, д. 25");
            Property cozyApartment = new Apartment(800000, 40, "77:03:0003003:9012", "г. Москва, ул. Пятницкая, д. 10");
            Property vintageCar = new Car(700000, 3.0, 2020, "C456CC99");
            Property luxuryVilla = new CountryHouse(2500000, 600, 120, "50:10:0010330:123", "Московская обл., Рублево-Успенское ш., дер. Барвиха, д. 50");
            Property modernApartment = new Apartment(1200000, 60, "77:04:0004004:3456", "г. Москва, ул. Кутузовский проспект, д. 20");

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

            System.out.println("Информация об имуществе и налогах:");
            for (Property property : propertyList) {
                System.out.println("----------------------------------------");
                System.out.println(property);
                System.out.println("Налог: " + String.format("%.2f", property.calculateTax()));

                if (property instanceof RealEstateOwnership) {
                    RealEstateOwnership realEstate = (RealEstateOwnership) property;
                    System.out.println("Кадастровый номер: " + realEstate.getCadastralNumber());
                    System.out.println("Адрес: " + realEstate.getAddress());
                    System.out.println("Стоимость коммунальных услуг: " + String.format("%.2f", realEstate.calculateUtilityCost()));
                }

                if (property instanceof VehicleOwnership) {
                    VehicleOwnership vehicle = (VehicleOwnership) property;
                    System.out.println("Регистрационный номер: " + vehicle.getRegistrationNumber());
                    System.out.println("Год выпуска: " + vehicle.getYear());
                    System.out.println("Стоимость обслуживания: " + String.format("%.2f", vehicle.calculateMaintenanceCost()));
                }
                System.out.println();
            }
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка при добавлении имущества: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addIfUnique(List<Property> properties, Property property) {
        if (!properties.contains(property)) {
            properties.add(property);
        } else {
            throw new IllegalArgumentException("Имущество уже существует: " + property.getClass().getSimpleName() + " со стоимостью " + property.getWorth());
        }
    }
}
