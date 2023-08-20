package co.ebird.hotspot.utils;

import java.util.ArrayList;
import java.util.List;

public class TransformDate {

    public static String toFormat(String strDate) {
        String[] date = strDate.split(" ");
        String day = ("0" + date[0]).substring(date[0].length() - 1);
        String month = date[1];
        String year = date[2];
        month = switch (month) {
            case "ene" -> "01";
            case "feb" -> "02";
            case "mar" -> "03";
            case "abr" -> "04";
            case "may" -> "05";
            case "jun" -> "06";
            case "jul" -> "07";
            case "ago" -> "08";
            case "sep" -> "09";
            case "oct" -> "10";
            case "nov" -> "11";
            case "dic" -> "12";
            default -> "00";
        };
        return day + "/" + month + "/" + year;
    }



}
