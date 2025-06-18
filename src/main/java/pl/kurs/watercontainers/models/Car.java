package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private static final long serialVersionUID = 42L;


    private String brand;
    private String model;
    private int powerHp;

    public Car(String brand, String model, int powerHp) {
        this.brand = brand;
        this.model = model;
        this.powerHp = powerHp;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPowerHp() {
        return powerHp;
    }

    public void setPowerHp(int powerHp) {
        this.powerHp = powerHp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return powerHp == car.powerHp && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, powerHp);
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", powerHp=" + powerHp +
                '}';
    }
}
