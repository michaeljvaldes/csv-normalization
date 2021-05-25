package org.company;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;

public class Record {

    @CsvBindByName(column = "Timestamp")
    @CsvDate(value = "M/d/yy h:mm:ss a")
    private LocalDateTime timestamp;

    @CsvBindByName(column = "ZIP")
    private String zip;

    @CsvBindByName(column = "FullName")
    private String fullName;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvBindByName(column = "FooDuration")
    private String fooDuration;

    @CsvBindByName(column = "BarDuration")
    private String barDuration;

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

    public String getFooDuration() {
        return fooDuration;
    }

    public void setFooDuration(String fooDuration) {
        this.fooDuration = fooDuration;
    }

    public String getBarDuration() {
        return barDuration;
    }

    public void setBarDuration(String barDuration) {
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
}
