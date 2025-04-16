package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;

public class Application {
    public static void main(String[] args) {
        //WaterContainer beczka = new WaterContainer("Beczka", 300, 100);

        WaterContainer beczka = WaterContainer.create("Beczka", 300, 100);


    }
}
