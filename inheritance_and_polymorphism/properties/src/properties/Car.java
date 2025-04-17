package properties;

import interfaces.VehicleOwnership;
import java.time.Year;
import java.util.Objects;

public class Car extends Property implements VehicleOwnership {
    private double volume;
    private int year;
    private String registrationNumber;
    private String vehicleType;
    private String makeAndModel;

    public Car(double worth, double volume, int year, String registrationNumber, String vehicleType, String makeAndModel) {
        super(worth);
        setVolume(volume);
        setYear(year);
        setRegistrationNumber(registrationNumber);
        setVehicleType(vehicleType);
        setMakeAndModel(makeAndModel);
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public String getMakeAndModel() {
        return makeAndModel;
    }

    @Override
    public double calculateTax() {
        return 0.1 * getVolume() * getWorth();
    }

    public double getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }

    private void setVolume(double volume) {
        if (volume > 0) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException("Car volume cannot be less than zero.");
        }
    }

    private void setYear(int year) {
        if (year > 0 && year >= 1885 && year <= Year.now().getValue()) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid car year.");
        }
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.trim().isEmpty()) {
            this.registrationNumber = registrationNumber;
        } else {
            throw new IllegalArgumentException("Registration number cannot be empty.");
        }
    }

    public void setVehicleType(String vehicleType) {
        if (vehicleType != null && !vehicleType.trim().isEmpty()) {
            this.vehicleType = vehicleType;
        } else {
            throw new IllegalArgumentException("Vehicle type cannot be empty.");
        }
    }

    public void setMakeAndModel(String makeAndModel) {
        if (makeAndModel != null && !makeAndModel.trim().isEmpty()) {
            this.makeAndModel = makeAndModel;
        } else {
            throw new IllegalArgumentException("Make and model cannot be empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Double.compare(car.volume, volume) == 0 &&
                year == car.year &&
                Objects.equals(registrationNumber, car.registrationNumber) &&
                Objects.equals(vehicleType, car.vehicleType) &&
                Objects.equals(makeAndModel, car.makeAndModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, year,
                registrationNumber, vehicleType, makeAndModel);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Volume: " + getVolume() + "\n" +
                "Year: " + getYear() + "\n" +
                "Registration Number: " + getRegistrationNumber() + "\n" +
                "Vehicle Type: " + getVehicleType() + "\n" +
                "Make and Model: " + getMakeAndModel();
    }
}