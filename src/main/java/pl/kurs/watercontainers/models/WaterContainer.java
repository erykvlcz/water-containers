package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.util.Objects;

public class WaterContainer implements Serializable, Comparable<WaterContainer> {
    private final String name;
    private final double maxCapacity;
    private double waterLevel;

    public WaterContainer() {
        this.name = null;
        this.maxCapacity = 0;
    }

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public static WaterContainer create(String name, double maxCapacity, double waterLevel){
        if(maxCapacity <= 0 ){
            throw  new RuntimeException("Max capacity should be above 0");
        }
        if(waterLevel < 0){
            throw new RuntimeException("Water level should be 0 or above");
        }
        if(waterLevel > maxCapacity) {
            throw new RuntimeException("Water level should be same as maxCapacity or below");
        }
        return new WaterContainer(name, maxCapacity, waterLevel);
    }

    public void addWater(double value){
        checkWaterValueInput(value);
        checkIfAddingIsPossible(value);
        waterLevel += value;
    }

    public void pourOutWater(double value){
        checkWaterValueInput(value);
        checkIfRemovingIsPossible(value);

        waterLevel -= value;
    }

    public void pourWaterFrom(WaterContainer sourceContainer, double value){
        checkIfAddingIsPossible(value);
        sourceContainer.pourOutWater(value);
        addWater(value);
    }

    private void checkWaterValueInput(double value){
        if(value <= 0){
            throw new IllegalArgumentException("Value should be above zero");
        }
    }

    private void checkIfAddingIsPossible(double value){
        if(value + waterLevel > maxCapacity){
            throw new IllegalArgumentException("Value + actual water level can not be higher than max capacity");
        }

    }

    private void checkIfRemovingIsPossible(double value){
        if(waterLevel - value < 0){
            throw new IllegalArgumentException("Too much water to pour out");
        }
    }


    public String getName() {
        return name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }



    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(maxCapacity, that.maxCapacity) == 0 && Double.compare(waterLevel, that.waterLevel) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, waterLevel);
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }

    @Override
    public int compareTo(WaterContainer o) {
        return Double.compare(waterLevel, o.waterLevel);
    }
}
