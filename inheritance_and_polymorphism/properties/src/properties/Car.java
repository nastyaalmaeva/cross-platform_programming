package properties;

import java.time.Year;
import java.util.Objects;

public class Car extends Property {
    private double volume;
    private int year;

    public Car(double worth, double volume, int year) {
        super(worth);
        setVolume(volume);
        setYear(year);
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

    public void setVolume(double volume) {
        if (volume > 0) {
            this.volume = volume;
        }
        else {
            throw new IllegalArgumentException("Объем двигателя автомобиля не может быть меньше нуля.");
        }
    }

    public void setYear(int year) {
        if (year > 0) {
            if (year >= 1885 || year <= Year.now().getValue()) {
                this.year = year;
            }
            else {
                throw new IllegalArgumentException("Этот год либо еще не наступил, либо автомобилей еще не было.");
            }
        }
        else {
            throw new IllegalArgumentException("Год не может быть меньше нуля.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return volume == car.volume && year == car.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, year);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Объем двигателя: " + getVolume() + "\n" +
                "Год выпуска: " + getYear();
    }
}
