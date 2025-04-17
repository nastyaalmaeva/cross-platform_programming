package properties;

import interfaces.RealEstateOwnership;

import java.util.Objects;

public class CountryHouse extends Property implements RealEstateOwnership {
    private int ownershipSquare;
    private int houseSquare;
    private String cadastralNumber;
    private String address;
    private int floorsCount;
    private int constructionYear;

    public CountryHouse(double worth, int ownershipSquare, int houseSquare, String cadastralNumber, String address, int floorsCount, int constructionYear) {
        super(worth);
        setOwnershipSquare(ownershipSquare);
        setHouseSquare(houseSquare);
        setCadastralNumber(cadastralNumber);
        setAddress(address);
        setFloorsCount(floorsCount);
        setConstructionYear(constructionYear);
    }

    @Override
    public double calculateTax() {
        return (0.0002 * getOwnershipSquare() + 0.01 * getHouseSquare()) * getWorth();
    }

    public int getOwnershipSquare() {
        return ownershipSquare;
    }

    public int getHouseSquare() {
        return houseSquare;
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

    private void setOwnershipSquare(int ownershipSquare) {
        if (ownershipSquare > 0) {
            this.ownershipSquare = ownershipSquare;
        }
        else {
            throw new IllegalArgumentException("Ownership square cannot be less than zero.");
        }
    }

    private void setHouseSquare(int houseSquare) {
        if (houseSquare > 0) {
            if (houseSquare <= getOwnershipSquare()) {
                this.houseSquare = houseSquare;
            }
            else {
                throw new IllegalArgumentException("Square of house cannot be larger than square of ownership.");
            }
        }
        else {
            throw new IllegalArgumentException("House square cannot be less than zero.");
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
        CountryHouse that = (CountryHouse) o;
        return ownershipSquare == that.ownershipSquare &&
                houseSquare == that.houseSquare &&
                floorsCount == that.floorsCount &&
                constructionYear == that.constructionYear &&
                Objects.equals(cadastralNumber, that.cadastralNumber) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ownershipSquare, houseSquare, cadastralNumber, address, floorsCount, constructionYear);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Ownership Square: " + getOwnershipSquare() + "\n" +
                "House Square: " + getHouseSquare() + "\n" +
                "Cadastral Number: " + getCadastralNumber() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Floors Count: " + getFloorsCount() + "\n" +
                "Construction Year: " + getConstructionYear();
    }
}
