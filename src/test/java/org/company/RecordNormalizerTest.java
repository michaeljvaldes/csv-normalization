package org.company;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class RecordNormalizerTest {

    @Test
    void transformRecord() {
        Record record =buildRecord();

        NormalizedRecord expectedNormalizedRecord = buildNormalizedRecord();
        NormalizedRecord normalizedRecord =  new RecordNormalizer().transformRecord(record);
        assertEquals(expectedNormalizedRecord, normalizedRecord);
    }

    private Record buildRecord() {
        Record record = new Record();
        LocalDateTime dateTime =  LocalDateTime.of(2011, Month.APRIL, 1, 11, 0, 0);
        record.setTimestamp(dateTime);
        record.setZip("1003");
        record.setFullName("Great name for person");
        record.setAddress("Super cool address");
        record.setFooDuration(Duration.ofHours(2));
        record.setBarDuration(Duration.ofMillis(100));
        record.setTotalDuration("This is not even important");
        record.setNotes("Copy this I guess");
        return record;
    }

    private NormalizedRecord buildNormalizedRecord() {
        return new NormalizedRecordBuilder()
                .setTimestamp( LocalDateTime.of(2011, Month.APRIL, 1, 14, 0, 0))
                .setZip("01003")
                .setFullName("Great name for person")
                .setAddress("Super cool address")
                .setFooDuration(7200D)
                .setBarDuration(0.1D)
                .setTotalDuration(7200.1D)
                .setNotes("Copy this I guess")
                .build();
    }
}
