package org.company;

import org.company.file.CsvReader;
import org.company.file.CsvWriter;
import org.company.model.NormalizedRecord;
import org.company.model.Record;

import java.util.List;
import java.util.stream.Collectors;

public class CommandLineNormalizationService {

    private final CsvReader reader;
    private final CsvWriter writer;
    private final RecordNormalizer recordNormalizer;

    public CommandLineNormalizationService() {
        this.reader = new CsvReader();
        this.writer = new CsvWriter();
        this.recordNormalizer = new RecordNormalizer();
    }

    public void normalizeSystemInToSystemOut() {
        List<Record> records = reader.parseCsvFromInputStream(System.in);
        List<NormalizedRecord> normalizedRecords = records.stream()
                .map(recordNormalizer::transformRecord)
                .collect(Collectors.toList());
        writer.writeCsvToOutputStream(normalizedRecords, System.out);
    }
}
