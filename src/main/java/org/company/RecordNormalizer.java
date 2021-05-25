package org.company;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class RecordNormalizer {

    public NormalizedRecord transformRecord(Record record) {
        return new NormalizedRecordBuilder()
                .setTimestamp(changeTimeZoneFromPacificToEastern(record.getTimestamp()))
                .setZip(padZipToFiveDigits(record.getZip()))
                .setFullName(convertFullNameToUppercase(record.getFullName()))
                .setAddress(record.getAddress())
                .setFooDuration(convertDurationToSeconds(record.getFooDuration()))
                .setBarDuration(convertDurationToSeconds(record.getBarDuration()))
                .setTotalDuration(calculateTotalDuration(record))
                .setNotes(record.getNotes())
                .build();
    }

    private LocalDateTime changeTimeZoneFromPacificToEastern(LocalDateTime timeStamp) {
        ZoneId oldZone = ZoneId.of("America/Los_Angeles");
        ZoneId newZone = ZoneId.of("America/New_York");
        return timeStamp.atZone(oldZone)
                .withZoneSameInstant(newZone)
                .toLocalDateTime();
    }

    private String padZipToFiveDigits(String zip) {
        return StringUtils.leftPad(zip, 5, '0');
    }

    private String convertFullNameToUppercase(String fullName) {
        return fullName.toUpperCase();
    }

    private double convertDurationToSeconds(Duration duration) {
        return duration.toMillis() / 1000D;
    }

    private double calculateTotalDuration(Record record) {
        return convertDurationToSeconds(record.getFooDuration()) + convertDurationToSeconds(record.getBarDuration());
    }
}
