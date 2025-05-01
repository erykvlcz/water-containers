package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaterContainerService {
    public WaterContainer findHighestLevelWaterContainer(List<WaterContainer> list){


        if(list.isEmpty()){
            return null;
        }

        WaterContainer max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(max.getWaterLevel() < list.get(i).getWaterLevel()){
                max = list.get(i);
            }
        }
        return max;
    }

    public WaterContainer findTheMostFilledWaterContainer(List<WaterContainer> list){


        if(list.isEmpty()){
            return null;
        }

        WaterContainer mostFilled = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(getFillRatio(mostFilled) < getFillRatio(list.get(i))){
                mostFilled = list.get(i);
            }
        }
        return mostFilled;
    }

    public List<WaterContainer> findEmptyContainers(List<WaterContainer> list){
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        List<WaterContainer> emptyWaterContainersList = new ArrayList<>();
        for (WaterContainer waterContainer : list) {
            if(waterContainer.getWaterLevel() == 0){
                emptyWaterContainersList.add(waterContainer);
            }
        }
        return Collections.unmodifiableList(emptyWaterContainersList);
    }

    private double getFillRatio(WaterContainer waterContainer){
        return waterContainer.getWaterLevel() / waterContainer.getMaxCapacity();
    }


}
