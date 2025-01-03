package com.mehdirefactoring.com.thisisrefactoring.model.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Author {
    private String name;

    public Author(){}

    public Author(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
