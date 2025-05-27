package com.utils;

public class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String repeat(String str, int times) {
        if (str == null || times <= 0) {
            return "";
        }
        return str.repeat(times);
    }
}