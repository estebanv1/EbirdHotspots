package co.ebird.hotspot.utils;

import java.util.List;

public class ExportUtil {

    public static void printFrequencyHeaders() {
        String[] months = {"ene","feb","mar","abr","may","jun","jul","ago","sep","oct","nov"};
        for (String month : months) {
            for (int i = 1; i < 5; i = i + 1) {
                System.out.print(month + i);
                System.out.print(",");
            }
        }
        System.out.println("dic1,dic2,dic3,dic4");
    }

    public static void printFrequencies(List<List<String>> birdsData, int index) {
        for (int j = 0; j < 47; j = j + 1) {
            System.out.print(birdsData.get(index).get(j + 5));
            System.out.print(",");
        }
        System.out.println(birdsData.get(index).get(52));
    }
}
