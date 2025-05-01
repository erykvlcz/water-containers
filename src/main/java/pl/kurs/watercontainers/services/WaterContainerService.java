package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.List;

public class WaterContainerService {
    public WaterContainer findHighestLevelWaterContainer(List<WaterContainer> list){

        WaterContainer max = null;
        if(list.isEmpty()){
            return null;
        }

        max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(max.getWaterLevel() < list.get(i).getWaterLevel()){
                max = list.get(i);
            }
        }
        return max;
    }

    public WaterContainer findTheMostFilledWaterContainer(List<WaterContainer> list){

        WaterContainer mostFilled = null;
        if(list.isEmpty()){
            return null;
        }

        mostFilled = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if(getFillRatio(mostFilled) < getFillRatio(list.get(i))){
                mostFilled = list.get(i);
            }
        }
        return mostFilled;
    }

    private double getFillRatio(WaterContainer waterContainer){
        return waterContainer.getWaterLevel() / waterContainer.getMaxCapacity();
    }


}
