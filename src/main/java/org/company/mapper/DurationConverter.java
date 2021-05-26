package org.company.mapper;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.Duration;

public class DurationConverter extends AbstractBeanField<Duration, String> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        String[] split = value.split(":");
        if (split.length != 3) {
            throw new CsvDataTypeMismatchException("Data for Duration not of format 'hh:mm:ss.SSS'");
        }
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);

        String[] secondsSplit = split[2].split("\\.");
        if (secondsSplit.length != 2) {
            throw new CsvDataTypeMismatchException("Data for Duration not of format 'hh:mm:ss.SSS'");
        }
        int seconds = Integer.parseInt(secondsSplit[0]);
        int millis = Integer.parseInt(secondsSplit[1]);
        return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds).plusMillis(millis);
    }
}
