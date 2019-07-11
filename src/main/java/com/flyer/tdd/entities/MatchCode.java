package com.flyer.tdd.entities;

public enum MatchCode {
    POSITION("A"),
    OCCURRENCE("B");

    private String code;

    MatchCode(final String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
