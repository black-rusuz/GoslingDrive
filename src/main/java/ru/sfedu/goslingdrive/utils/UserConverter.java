package ru.sfedu.goslingdrive.utils;

import com.opencsv.bean.AbstractBeanField;
import ru.sfedu.goslingdrive.model.bean.AutoPart;
import ru.sfedu.goslingdrive.model.bean.User;

import java.util.List;

public class UserConverter extends AbstractBeanField<List<User>, String> {
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
