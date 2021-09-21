package com.quercusdata.itxdemo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {

    /**
     * Correct an issue when the ISO LocalDateTime object has zero seconds
     * @param dateTime LocalDateTime
     * @return String the corrected time with seconds
     */
    public static String withSeconds(LocalDateTime dateTime) {
        // formatter with required seconds
        DateTimeFormatter withSecs = DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT);
        try {
            LocalDateTime.parse(dateTime.toString(), withSecs);
        } catch (DateTimeParseException e) {
            return dateTime.toString() + ":00";
        }
        return dateTime.toString();
    }
}
