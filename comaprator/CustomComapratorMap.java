package comaprator;

import entity.Driver;
import entity.detail.DetailRoute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class CustomComapratorMap implements Comparator<Map.Entry<Driver, ArrayList<DetailRoute>>> {

    final int compareIndex;

    public CustomComapratorMap(int compareIndex) {
        this.compareIndex = compareIndex;
    }

    @Override
    public int compare(Map.Entry<Driver, ArrayList<DetailRoute>> me1, Map.Entry<Driver, ArrayList<DetailRoute>> me2) {
        Object item1 = me1.getValue().get(compareIndex);
        Object item2 = me2.getValue().get(compareIndex);
        int compareResult = 0;

        return compareResult;
    }
}