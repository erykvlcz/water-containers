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

    public boolean addWater(double value){
        checkWaterValueInput(value);
        if(!addIsPossible(value)){
            return false;
        }
        waterLevel += value;
        return true;
    }

    public boolean pourOutWater(double value){
        checkWaterValueInput(value);
        if(!subtractIsPossible(value)){
            return false;
        }
        waterLevel -= value;
        return true;
    }

    public boolean pourWaterFrom(WaterContainer sourceContainer, double value){
        if (sourceContainer == null) {
            System.out.println("Source container can not be null");
            return false;
        }

        if(!this.addIsPossible(value) || !sourceContainer.subtractIsPossible(value)){
            return false;
        }

        boolean operation1 = sourceContainer.pourOutWater(value);
        boolean operation2 = addWater(value);
        return operation1 && operation2;

    }

    private void checkWaterValueInput(double value){
        if(value <= 0){
            throw new IllegalArgumentException("Value should be above zero");
        }
    }

    private boolean addIsPossible(double value){
        if(value + waterLevel > maxCapacity){
            System.out.println("Value + actual water level can not be higher than max capacity");
            return false;
        }
        return true;
    }

    private boolean subtractIsPossible(double value){
        if(waterLevel - value < 0){
            System.out.println("Too much water to pour out");
            return false;
        }
        return true;
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
