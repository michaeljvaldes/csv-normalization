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
        List<Record> records = reader.parseCsvFromInputStream(getClass().getResourceAsStream(SAMPLE_FILE));
        assertEquals(9, records.size());
        Record monkeyAlbertoRecord = records.stream()
                .filter(record -> "Monkey Alberto".equals(record.getFullName()))
                .findAny()
                .get();
        assertEquals("I am the very model of a modern major general", monkeyAlbertoRecord.getNotes());

        LocalDateTime expectedDateTime = LocalDateTime.of(2011, Month.APRIL, 1, 11, 0, 0);
        assertEquals(expectedDateTime, monkeyAlbertoRecord.getTimestamp());
    }
}
