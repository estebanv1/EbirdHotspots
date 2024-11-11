package co.ebird.hotspot.utils;

import java.util.List;

public class ExportUtil {

    private ExportUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String getFrequencyHeaders() {
        StringBuilder frequencyHeaders = new StringBuilder();
        String[] months = {"ene","feb","mar","abr","may","jun","jul","ago","sep","oct","nov"};
        for (String month : months) {
            for (int i = 1; i < 5; i = i + 1) {
                frequencyHeaders.append(month).append(i).append(", ");
            }
        }
        return String.valueOf(frequencyHeaders.append("dic1, dic2, dic3, dic4"));
    }

    public static String getFrequencies(List<List<String>> birdsData, int index) {
        StringBuilder frequencies = new StringBuilder();
        for (int j = 0; j < 47; j = j + 1) {
            frequencies.append(birdsData.get(index).get(j + 5)).append(", ");
        }
        return String.valueOf(frequencies.append(birdsData.get(index).get(52)));
    }
}
