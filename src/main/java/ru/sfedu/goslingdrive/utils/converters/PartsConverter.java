package ru.sfedu.goslingdrive.utils.converters;

import com.opencsv.bean.AbstractBeanField;
import ru.sfedu.goslingdrive.model.bean.AutoPart;

import java.util.List;

public class PartsConverter extends AbstractBeanField<List<AutoPart>, String> {
    public static final String fieldsDelimiter = "::";

    @Override
    public List<AutoPart> convert(String s) {
        return List.of();
    }

    @Override
    public String convertToWrite(Object object) {
        return "";
    }
}
