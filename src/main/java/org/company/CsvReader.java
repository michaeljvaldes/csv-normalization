package org.company;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.opencsv.ICSVWriter.DEFAULT_QUOTE_CHARACTER;

public class CsvReader {

    private static final Logger LOGGER = LogManager.getLogger(CsvReader.class);

    public List<Record> parseCsvFromInputStream(InputStream inputStream) {
        List<Record> records = new ArrayList<>();
        try (
                Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        ) {
            CsvToBean<Record> csvToBean = new CsvToBeanBuilder<Record>(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withQuoteChar(DEFAULT_QUOTE_CHARACTER)
                    .withType(Record.class)
                    .build();
            Iterator<Record> recordIterator = csvToBean.iterator();
            recordIterator.forEachRemaining(records::add);
        } catch (IOException e) {
            LOGGER.error("Error reading csv to beans; " + e.getMessage());
        }
        return records;
    }
}

