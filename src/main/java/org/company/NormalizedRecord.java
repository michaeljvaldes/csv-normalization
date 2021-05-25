package org.company;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;
import java.util.Objects;

public class NormalizedRecord {

    @CsvBindByName(column = "Timestamp", required = true)
    @CsvDate(value = "M/d/yy h:mm:ss a")
    private final LocalDateTime timestamp;

    @CsvBindByName(column = "ZIP", required = true)
    private final String zip;

    @CsvBindByName(column = "FullName", required = true)
    private final String fullName;

    @CsvBindByName(column = "Address", required = true)
    private final String address;

    @CsvBindByName(column = "FooDuration", required = true)
    private final double fooDuration;

    @CsvBindByName(column = "BarDuration", required = true)
    private final double barDuration;

    @CsvBindByName(column = "TotalDuration", required = true)
    private final double totalDuration;

    @CsvBindByName(column = "Notes", required = true)
    private final String notes;

    public NormalizedRecord(LocalDateTime timestamp, String zip, String fullName, String address, double fooDuration, double barDuration, double totalDuration, String notes) {
        this.timestamp = timestamp;
        this.zip = zip;
        this.fullName = fullName;
        this.address = address;
        this.fooDuration = fooDuration;
        this.barDuration = barDuration;
        this.totalDuration = totalDuration;
        this.notes = notes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getZip() {
        return zip;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public double getFooDuration() {
        return fooDuration;
    }

    public double getBarDuration() {
        return barDuration;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalizedRecord that = (NormalizedRecord) o;
        return Double.compare(that.fooDuration, fooDuration) == 0 &&
                Double.compare(that.barDuration, barDuration) == 0 &&
                Double.compare(that.totalDuration, totalDuration) == 0 &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(zip, that.zip) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, zip, fullName, address, fooDuration, barDuration, totalDuration, notes);
    }
}
