package org.company;

import java.util.List;
import java.util.stream.Collectors;

public class CsvNormalization {

    public static void main(String[] args) {
        CsvReader reader = new CsvReader();
        List<Record> records = reader.parseCsvFromInputStream(System.in);
        RecordNormalizer recordNormalizer = new RecordNormalizer();
        List<NormalizedRecord> normalizedRecords = records.stream()
                .map(recordNormalizer::transformRecord)
                .collect(Collectors.toList());
        new CsvWriter().writeCsvToOutputStream(normalizedRecords, System.out);
    }

}
