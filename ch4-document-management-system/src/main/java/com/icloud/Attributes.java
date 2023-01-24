package com.icloud;

public enum Attributes {

    PATH,
    PATIENT,
    ADDRESS,
    BODY,
    WIDTH,
    HEIGHT,
    TYPE,
    AMOUNT;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
