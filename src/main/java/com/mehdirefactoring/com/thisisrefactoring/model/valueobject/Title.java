package com.mehdirefactoring.com.thisisrefactoring.model.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Title {
    private String value;

    public Title() {}

    public Title(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
