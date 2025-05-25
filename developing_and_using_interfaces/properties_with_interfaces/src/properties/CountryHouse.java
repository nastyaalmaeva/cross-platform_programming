package properties;

import interfaces.RealEstateOwnership;

import java.util.Objects;

public class CountryHouse extends Property implements RealEstateOwnership {
    private int ownershipSquare;
    private int houseSquare;
    private String cadastralNumber;
    private String address;

    public CountryHouse(double worth, int ownershipSquare, int houseSquare, String cadastralNumber, String address) {
        super(worth);
        setOwnershipSquare(ownershipSquare);
        setHouseSquare(houseSquare);
        setCadastralNumber(cadastralNumber);
        setAddress(address);
    }

    @Override
    public double calculateTax() {
        return (0.0002 * getOwnershipSquare() + 0.01 * getHouseSquare()) * getWorth();
    }

    @Override
    public double calculateUtilityCost() {
        return getHouseSquare() * 20 + getOwnershipSquare() * 5 + getWorth() * 0.0002;
    }

    public int getOwnershipSquare() {
        return ownershipSquare;
    }

    public int getHouseSquare() {
        return houseSquare;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setOwnershipSquare(int ownershipSquare) {
        if (ownershipSquare > 0) {
            this.ownershipSquare = ownershipSquare;
        } else {
            throw new IllegalArgumentException("Площадь владения не может быть меньше нуля.");
        }
    }

    public void setHouseSquare(int houseSquare) {
        if (houseSquare > 0) {
            if (houseSquare <= getOwnershipSquare()) {
                this.houseSquare = houseSquare;
            } else {
                throw new IllegalArgumentException("Площадь дома не может быть больше площади владения.");
            }
        } else {
            throw new IllegalArgumentException("Площадь дома не может быть меньше нуля.");
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
        CountryHouse that = (CountryHouse) o;
        return ownershipSquare == that.ownershipSquare &&
               houseSquare == that.houseSquare &&
               Objects.equals(cadastralNumber, that.cadastralNumber) &&
               Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ownershipSquare, houseSquare, cadastralNumber, address);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Площадь владения: " + getOwnershipSquare() + "\n" +
               "Площадь дома: " + getHouseSquare() + "\n" +
               "Кадастровый номер: " + getCadastralNumber() + "\n" +
               "Адрес: " + getAddress();
    }
}
