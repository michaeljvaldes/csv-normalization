package org.company;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvReaderTest {

    private static final String SAMPLE_FILE = "sample.csv";
    private final CsvReader reader = new CsvReader();

    @Test
    public void testSample() {
        List<Record> records = getRecordsFromResource(SAMPLE_FILE);
        assertEquals(9, records.size());
        Record promptNegotiatorRecord = records.stream()
                .filter(record -> "Prompt Negotiator".equals(record.getFullName()))
                .findAny()
                .get();
        assertEquals("I’m just gonna say, this is AMAZING. WHAT NEGOTIATIONS.", promptNegotiatorRecord.getNotes());
    }

    @Test
    public void testSampleDateTimeConversion() {
        List<Record> records = getRecordsFromResource(SAMPLE_FILE);
        Record monkeyAlbertoRecord = records.stream()
                .filter(record -> "Monkey Alberto".equals(record.getFullName()))
                .findAny()
                .get();
        LocalDateTime expectedDateTime = LocalDateTime.of(2011, Month.APRIL, 1, 11, 0, 0);
        assertEquals(expectedDateTime, monkeyAlbertoRecord.getTimestamp());
    }

    @Test
    public void testDurationConversion() {
        List<Record> records = getRecordsFromResource(SAMPLE_FILE);
        Record supermanRecord = records.stream()
                .filter(record -> "Superman übertan".equals(record.getFullName()))
                .findAny()
                .get();
        double expectedFooDurationMillis = 401012123D;
        assertEquals(expectedFooDurationMillis, supermanRecord.getFooDuration().toMillis());
    }

    private List<Record> getRecordsFromResource(String resourceName) {
        return reader.parseCsvFromInputStream(getClass().getClassLoader().getResourceAsStream(resourceName));
    }

}
