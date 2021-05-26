package org.company.mapper;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class ZipConverter extends AbstractBeanField<String, String> {

    @Override
    protected String convert(String value) throws CsvDataTypeMismatchException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new CsvDataTypeMismatchException("ZIP is not an integer");
        }
        if (value.length() == 0) {
            throw new CsvDataTypeMismatchException("ZIP is empty");
        } else if (value.length() > 5) {
            throw new CsvDataTypeMismatchException("ZIP is more than 5 characters");
        }
        return value;
    }
}
