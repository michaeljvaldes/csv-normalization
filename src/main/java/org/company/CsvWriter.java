package org.company;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

import static com.opencsv.ICSVWriter.DEFAULT_QUOTE_CHARACTER;
import static java.nio.charset.StandardCharsets.UTF_8;

public class CsvWriter {

    private static final Logger LOGGER = LogManager.getLogger(CsvWriter.class);

    public void writeCsvToOutputStream(List<NormalizedRecord> records, OutputStream outputStream) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream, UTF_8))) {
            StatefulBeanToCsv<NormalizedRecord> beanToCsv = new StatefulBeanToCsvBuilder<NormalizedRecord>(writer)
                    .withQuotechar(DEFAULT_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(records);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            LOGGER.error("Error writing beans to csv; " + e.getMessage());
        }
    }
}
