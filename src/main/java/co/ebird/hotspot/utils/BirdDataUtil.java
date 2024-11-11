package co.ebird.hotspot.utils;

import java.util.List;

public class BirdDataUtil {

    private BirdDataUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static int sumColumn(List<List<String>> birdData, int column) {
        int sum = 0;
        for (List<String> birdDatum : birdData) {
            sum = sum + Integer.parseInt(birdDatum.get(column).trim());
        }
        return sum;
    }





}
