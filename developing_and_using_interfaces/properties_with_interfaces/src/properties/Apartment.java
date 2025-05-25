package properties;

import interfaces.RealEstateOwnership;

import java.util.Objects;

public class Apartment extends Property implements RealEstateOwnership {
    private int square;
    private String cadastralNumber;
    private String address;

    public Apartment(double worth, int square, String cadastralNumber, String address) {
        super(worth);
        setSquare(square);
        setCadastralNumber(cadastralNumber);
        setAddress(address);
    }

    @Override
    public double calculateTax() {
        return 0.001 * getSquare() * getWorth();
    }

    @Override
    public double calculateUtilityCost() {
        return getSquare() * 50 + getWorth() * 0.0005;
    }

    public int getSquare() {
        return square;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setSquare(int square) {
        if (square > 0) {
            this.square = square;
        } else {
            throw new IllegalArgumentException("Площадь не может быть меньше нуля.");
        }
    }

    @Override
    public void setCadastralNumber(String cadastralNumber) {
        if (cadastralNumber != null && !cadastralNumber.trim().isEmpty()) {
            this.cadastralNumber = cadastralNumber;
        } else {
            throw new IllegalArgumentException("Кадастровый номер не может быть пустым.");
        }
    }

    @Override
    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес не может быть пустым.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment that = (Apartment) o;
        return square == that.square &&
               Objects.equals(cadastralNumber, that.cadastralNumber) &&
               Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), square, cadastralNumber, address);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Площадь: " + getSquare() + "\n" +
               "Кадастровый номер: " + getCadastralNumber() + "\n" +
               "Адрес: " + getAddress();
    }
}
