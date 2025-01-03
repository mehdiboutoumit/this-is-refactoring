package com.mehdirefactoring.com.thisisrefactoring.utils;

public class ValidationUtil {
    public static void validateStringLength(String value, int maxLength, String errorMessage) {
        if (value.length() > maxLength) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

