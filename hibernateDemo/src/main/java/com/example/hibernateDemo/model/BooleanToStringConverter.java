package com.example.hibernateDemo.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter
        implements AttributeConverter<Boolean,String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) return null;
        if(attribute) return "yes";
        return "no";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        if(dbData.equalsIgnoreCase("yes"))
            return true;
        return false;
    }
}
