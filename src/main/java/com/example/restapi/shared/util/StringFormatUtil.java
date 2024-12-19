package com.example.restapi.shared.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringFormatUtil {

    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
}
