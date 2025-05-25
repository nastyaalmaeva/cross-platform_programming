package properties;

import java.util.Objects;

public class Apartment extends Property {
    private int square;

    public Apartment(double worth, int square) {
        super(worth);
        setSquare(square);
    }

    @Override
    public double calculateTax() {
        return 0.001 * getSquare() * getWorth();
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        if (square > 0) {
            this.square = square;
        }
        else {
            throw new IllegalArgumentException("Площадь не может быть меньше нуля.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment apartment = (Apartment) o;
        return square == apartment.square;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), square);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Площадь: " + getSquare();
    }
}
