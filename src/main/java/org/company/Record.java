package org.company;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Record {

    @CsvBindByName(column = "Timestamp")
    @CsvDate(value = "M/d/yy h:mm:ss a")
    private LocalDateTime timestamp;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvBindByName(column = "ZIP")
    private String zip;

    @CsvBindByName(column = "FullName")
    private String fullName;

    @CsvCustomBindByName(converter = DurationConverter.class, column = "FooDuration")
    private Duration fooDuration;

    @CsvCustomBindByName(converter = DurationConverter.class, column = "BarDuration")
    private Duration barDuration;

    @CsvBindByName(column = "TotalDuration")
    private String totalDuration;

    @CsvBindByName(column = "Notes")
    private String notes;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Duration getFooDuration() {
        return fooDuration;
    }

    public void setFooDuration(Duration fooDuration) {
        this.fooDuration = fooDuration;
    }

    public Duration getBarDuration() {
        return barDuration;
    }

    public void setBarDuration(Duration barDuration) {
        this.barDuration = barDuration;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(timestamp, record.timestamp) &&
                Objects.equals(zip, record.zip) &&
                Objects.equals(fullName, record.fullName) &&
                Objects.equals(address, record.address) &&
                Objects.equals(fooDuration, record.fooDuration) &&
                Objects.equals(barDuration, record.barDuration) &&
                Objects.equals(totalDuration, record.totalDuration) &&
                Objects.equals(notes, record.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, zip, fullName, address, fooDuration, barDuration, totalDuration, notes);
    }
}
