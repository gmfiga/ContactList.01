package com.example.contactlist.model;

import android.support.annotation.NonNull;

public class Student {
    private final String name;
    private final String telephone;
    private final String email;

    public Student(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
