package co.ebird.hotspot.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVUtility {

    private CSVUtility() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger LOGGER = LogManager.getLogger(CSVUtility.class);
    private static final String CSV_FILE_PATH = "birdsData.csv";

    public static void deleteCsvFile() {
        File csvFile = new File(CSV_FILE_PATH);
        if (csvFile.exists()) {
            boolean deleted = csvFile.delete();
            if (deleted) {
                LOGGER.info("Archivo 'birdsData.csv' eliminado.");
            } else {
                LOGGER.error("No se pudo eliminar el archivo.");
            }
        }
    }

    public static void appendRowToCsv(String[] values) {

        try (FileWriter writer = new FileWriter(CSV_FILE_PATH, true);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                             //.withQuoteMode(org.apache.commons.csv.QuoteMode.NONE).withEscape('\\')
             )) {

            csvPrinter.printRecord((Object[]) values);

        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error al agregar el ave: {}", e.getMessage());
        }
    }
}