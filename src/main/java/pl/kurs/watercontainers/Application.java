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
        WaterContainer cysterna = WaterContainer.create("Cysterna", 100_000, 30_000);
        WaterContainer zbiornik = WaterContainer.create("Cysterna", 20_000, 0);

        WaterContainerService service = new WaterContainerService();
        WaterContainer maxContainer = service.findHighestLevelWaterContainer(List.of(beczka, mazuer));
        System.out.println(service.findTheMostFilledWaterContainer(List.of(beczka, mazuer, cysterna)));
        List<WaterContainer> emptyContainers = service.findEmptyContainers(List.of(beczka, mazuer, cysterna, zbiornik));
        emptyContainers.add(beczka);



//        try {
//            mazuer.pourWaterFrom(beczka, 150);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }
}
