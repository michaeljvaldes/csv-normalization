package org.company.file;

import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.company.mapper.CustomMappingStrategy;
import org.company.model.NormalizedRecord;

import java.io.*;
import java.util.List;

import static com.opencsv.ICSVWriter.DEFAULT_QUOTE_CHARACTER;
import static java.nio.charset.StandardCharsets.UTF_8;

public class CsvWriter {

    private static final Logger LOGGER = LogManager.getLogger(CsvWriter.class);

    public void writeCsvToOutputStream(List<NormalizedRecord> records, OutputStream outputStream) {
        MappingStrategy<NormalizedRecord> mappingStrategy = new CustomMappingStrategy<>(NormalizedRecord.class);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream, UTF_8))) {
            StatefulBeanToCsv<NormalizedRecord> beanToCsv = new StatefulBeanToCsvBuilder<NormalizedRecord>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withQuotechar(DEFAULT_QUOTE_CHARACTER)
                    .withApplyQuotesToAll(false)
                    .build();
            beanToCsv.write(records);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            LOGGER.error("Error writing beans to csv; " + e.getMessage());
        }
    }
}
