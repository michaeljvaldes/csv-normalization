package org.company;

import org.company.file.CsvWriter;
import org.company.model.NormalizedRecord;
import org.company.model.NormalizedRecordBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvWriterTest {

    @Test
    public void writeCsv() throws IOException {
        List<String> lines = writeFileAndGetLines();
        long csvFileLinesCount = lines.size();
        assertEquals(2, csvFileLinesCount);
    }

    @Test
    public void testHeader() throws IOException {
        List<String> lines = writeFileAndGetLines();
        String header = lines.get(0);
        String expectedHeader = "Timestamp,Address,ZIP,FullName,FooDuration,BarDuration,TotalDuration,Notes";
        assertEquals(expectedHeader, header);
    }


    private List<String> writeFileAndGetLines() throws IOException {
        List<NormalizedRecord> normalizedRecords = Collections.singletonList(buildNormalizedRecord());
        File outputFile = File.createTempFile("output", ".csv");
        try (OutputStream outputStream = new FileOutputStream(outputFile)) {
            new CsvWriter().writeCsvToOutputStream(normalizedRecords, outputStream);
        }
        try (Stream<String> lines = Files.lines(outputFile.toPath(), StandardCharsets.UTF_8)) {
            return lines.collect(Collectors.toList());
        }
    }

    private NormalizedRecord buildNormalizedRecord() {
        return new NormalizedRecordBuilder()
                .setTimestamp(LocalDateTime.of(2011, Month.APRIL, 1, 14, 0, 0))
                .setZip("01003")
                .setFullName("GREAT \"NAME\" FOR A PERSON")
                .setAddress("Super cool address")
                .setFooDuration(7200D)
                .setBarDuration(0.1D)
                .setTotalDuration(7200.1D)
                .setNotes("Copy this I guess")
                .build();
    }
}
