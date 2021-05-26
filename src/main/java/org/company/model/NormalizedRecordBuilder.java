package org.company.model;

import java.time.LocalDateTime;

public class NormalizedRecordBuilder {
    private LocalDateTime timestamp;
    private String zip;
    private String fullName;
    private String address;
    private double fooDuration;
    private double barDuration;
    private double totalDuration;
    private String notes;

    public NormalizedRecordBuilder setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public NormalizedRecordBuilder setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public NormalizedRecordBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public NormalizedRecordBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public NormalizedRecordBuilder setFooDuration(double fooDuration) {
        this.fooDuration = fooDuration;
        return this;
    }

    public NormalizedRecordBuilder setBarDuration(double barDuration) {
        this.barDuration = barDuration;
        return this;
    }

    public NormalizedRecordBuilder setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
        return this;
    }

    public NormalizedRecordBuilder setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public NormalizedRecord build() {
        return new NormalizedRecord(timestamp, zip, fullName, address, fooDuration, barDuration, totalDuration, notes);
    }
}
