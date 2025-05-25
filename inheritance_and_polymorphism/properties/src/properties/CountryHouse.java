package properties;

import java.util.Objects;

public class CountryHouse extends Property {
    private int ownershipSquare;
    private int houseSquare;

    public CountryHouse(double worth, int ownershipSquare, int houseSquare) {
        super(worth);
        setOwnershipSquare(ownershipSquare);
        setHouseSquare(houseSquare);
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

    public void setOwnershipSquare(int ownershipSquare) {
        if (ownershipSquare > 0) {
            this.ownershipSquare = ownershipSquare;
        }
        else {
            throw new IllegalArgumentException("Площадь владения не может быть меньше нуля.");
        }
    }

    public void setHouseSquare(int houseSquare) {
        if (houseSquare > 0) {
            if (houseSquare <= getOwnershipSquare()) {
                this.houseSquare = houseSquare;
            }
            else {
                throw new IllegalArgumentException("Площадь дома не может быть больше площади владения.");
            }
        }
        else {
            throw new IllegalArgumentException("Площадь дома не может быть меньше нуля.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CountryHouse that = (CountryHouse) o;
        return ownershipSquare == that.ownershipSquare && houseSquare == that.houseSquare;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ownershipSquare, houseSquare);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Площадь владения: " + getOwnershipSquare() + "\n" +
                "Площадь дома: " + getHouseSquare();
    }
}
