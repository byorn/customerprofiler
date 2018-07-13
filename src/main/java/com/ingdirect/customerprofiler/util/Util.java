package com.ingdirect.customerprofiler.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    private static final String FILE_FORMAT="d/MM/yyyy h:mm:ss a";
    private static final String BROWSER_FORMAT="yyyy-MM-dd";

    public static LocalDateTime parseDateTime(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FILE_FORMAT);
        return  LocalDateTime.parse(string,formatter);
    }

    public static LocalDate parseDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BROWSER_FORMAT);
        return  LocalDate.parse(string,formatter);
    }

  }
