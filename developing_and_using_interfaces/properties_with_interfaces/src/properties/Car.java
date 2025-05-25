package properties;

import interfaces.VehicleOwnership;

import java.time.Year;
import java.util.Objects;

public class Car extends Property implements VehicleOwnership {
    private double volume;
    private int year;
    private String registrationNumber;

    public Car(double worth, double volume, int year, String registrationNumber) {
        super(worth);
        setVolume(volume);
        setYear(year);
        setRegistrationNumber(registrationNumber);
    }

    @Override
    public double calculateTax() {
        return 0.1 * getVolume() * getWorth();
    }

    @Override
    public double calculateMaintenanceCost() {
        double cost = getVolume() * 1000;
        if (getYear() < 2000) {
            cost += 5000;
        } else {
            cost += 2000;
        }
        return cost;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setVolume(double volume) {
        if (volume > 0) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException("Объем двигателя автомобиля не может быть меньше нуля.");
        }
    }

    @Override
    public void setYear(int year) {
        if (year > 0) {
            if (year >= 1885 && year <= Year.now().getValue()) {
                this.year = year;
            } else {
                throw new IllegalArgumentException("Этот год либо еще не наступил, либо автомобилей еще не было.");
            }
        } else {
            throw new IllegalArgumentException("Год не может быть меньше нуля.");
        }
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.trim().isEmpty()) {
            this.registrationNumber = registrationNumber;
        } else {
            throw new IllegalArgumentException("Регистрационный номер не может быть пустым.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car that = (Car) o;
        return Double.compare(that.volume, volume) == 0 &&
               year == that.year &&
               Objects.equals(registrationNumber, that.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, year, registrationNumber);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Объем двигателя: " + getVolume() + "\n" +
               "Год выпуска: " + getYear() + "\n" +
               "Регистрационный номер: " + getRegistrationNumber();
    }
}
