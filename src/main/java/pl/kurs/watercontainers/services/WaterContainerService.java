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
}
