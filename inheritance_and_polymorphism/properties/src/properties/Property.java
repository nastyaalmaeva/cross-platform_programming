package properties;

import java.util.Objects;

public abstract class Property {
    private double worth;

    protected Property(double worth) {
        setWorth(worth);
    }

    public void sell() {
        System.out.println("Имущество было продано.");
    }

    public void transfer() {
        System.out.println("Имущество было передано.");
    }

    public abstract double calculateTax();

    public double getWorth() {
        return worth;
    }

    public void setWorth(double worth) {
        if (worth > 0) {
            this.worth = worth;
        }
        else {
            throw new IllegalArgumentException("Стоимость не может быть меньше нуля.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(worth, property.worth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(worth);
    }

    @Override
    public String toString() {
        return  "Класс: " + this.getClass().getSimpleName() + "\n" +
                "Стоимость: " + getWorth();
    }
}
