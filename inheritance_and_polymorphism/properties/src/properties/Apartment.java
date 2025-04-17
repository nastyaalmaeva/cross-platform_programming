package properties;

import interfaces.RealEstateOwnership;
import java.util.Objects;

public class Apartment extends Property implements RealEstateOwnership {
    private int square;
    private String cadastralNumber;
    private String address;
    private int floorsCount;
    private int constructionYear;

    public Apartment(double worth, int square, String cadastralNumber, String address, int floorsCount, int constructionYear) {
        super(worth);
        setSquare(square);
        setCadastralNumber(cadastralNumber);
        setAddress(address);
        setFloorsCount(floorsCount);
        setConstructionYear(constructionYear);
    }

    @Override
    public double calculateTax() {
        return 0.001 * getSquare() * getWorth();
    }

    public int getSquare() {
        return square;
    }

    @Override
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getFloorsCount() {
        return floorsCount;
    }

    @Override
    public int getConstructionYear() {
        return constructionYear;
    }

    public void setSquare(int square) {
        if (square > 0) {
            this.square = square;
        }
        else {
            throw new IllegalArgumentException("Square cannot be less than zero.");
        }
    }

    public void setCadastralNumber(String cadastralNumber) {
        if (cadastralNumber != null && !cadastralNumber.trim().isEmpty()) {
            this.cadastralNumber = cadastralNumber;
        }
        else {
            throw new IllegalArgumentException("Cadastral number cannot be empty.");
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        }
        else {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
    }

    public void setFloorsCount(int floorsCount) {
        if (floorsCount > 0) {
            this.floorsCount = floorsCount;
        }
        else {
            throw new IllegalArgumentException("Floors count must be positive.");
        }
    }

    public void setConstructionYear(int constructionYear) {
        if (constructionYear > 1800 && constructionYear <= java.time.Year.now().getValue()) {
            this.constructionYear = constructionYear;
        }
        else {
            throw new IllegalArgumentException("Invalid construction year.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment that = (Apartment) o;
        return square == that.square &&
                floorsCount == that.floorsCount &&
                constructionYear == that.constructionYear &&
                Objects.equals(cadastralNumber, that.cadastralNumber) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), square, cadastralNumber, address, floorsCount, constructionYear);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Square: " + getSquare() + "\n" +
                "Cadastral Number: " + getCadastralNumber() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Floors Count: " + getFloorsCount() + "\n" +
                "Construction Year: " + getConstructionYear();
    }
}