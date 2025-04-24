package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;
import pl.kurs.watercontainers.services.WaterContainerService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //WaterContainer beczka = new WaterContainer("Beczka", 300, 100);

        WaterContainer beczka = WaterContainer.create("Beczka", 300, 100);
        WaterContainer mazuer = WaterContainer.create("Mauzer", 1000, 800);

        WaterContainerService service = new WaterContainerService();
        WaterContainer maxContainer = service.findHighestLevelWaterContainer(List.of(beczka, mazuer));



//        try {
//            mazuer.pourWaterFrom(beczka, 150);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }
}
