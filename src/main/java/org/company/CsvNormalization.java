package org.company;

import java.util.List;

public class CsvNormalization {

    public static void main(String[] args) {
        CsvReader reader = new CsvReader();
        List<Record> records = reader.parseCsvFromInputStream(System.in);
        new CsvWriter().writeCsvToOutputStream(records, System.out);
    }

}
