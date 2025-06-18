package pl.kurs.watercontainers.models;

public class Car {


    private String producer;
    private String model;
    private int powerHp;

    public Car(String producer, String model, int powerHp) {
        this.producer = producer;
        this.model = model;
        this.powerHp = powerHp;
    }


    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", powerHp=" + powerHp +
                '}';
    }
}
