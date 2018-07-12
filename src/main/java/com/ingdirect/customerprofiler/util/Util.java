package com.ingdirect.customerprofiler.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    public static LocalDateTime parseDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy h:mm:ss a");
        return  LocalDateTime.parse(string,formatter);
    }
}
