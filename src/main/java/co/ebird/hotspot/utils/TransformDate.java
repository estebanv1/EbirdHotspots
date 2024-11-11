package co.ebird.hotspot.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransformDate {

    private TransformDate() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger LOGGER = LogManager.getLogger(TransformDate.class);

    public static String toFormat(String strDate) {
        String[] date = strDate.split(" ");
        String day = ("0" + date[0]).substring(date[0].length() - 1);
        String month = date[1].replace(".", "");
        String year = date[2];
        String newMonth = switch (month) {
            case "ene" -> "01";
            case "feb" -> "02";
            case "mar" -> "03";
            case "abr" -> "04";
            case "may" -> "05";
            case "jun" -> "06";
            case "jul" -> "07";
            case "ago" -> "08";
            case "sept", "sep" -> "09";
            case "oct" -> "10";
            case "nov" -> "11";
            case "dic" -> "12";
            default -> "00";
        };
        if (newMonth.equals("00")) {
            LOGGER.log(Level.ERROR, "Error en el mes para la fecha: {}", strDate);
        }
        return day + "/" + newMonth + "/" + year;
    }



}
