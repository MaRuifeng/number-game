package com.flyer.tdd.entities;

/**
 * Match check result
 */

public class MatchResult {
    private MatchCode code;
    private int count;

    public MatchResult(MatchCode code, int count) {
        if (count < 0) throw new IllegalArgumentException("Match count cannot be negative!");
        this.code = code;
        this.count = count;
    }

    public String print() {
        return this.count + " " + this.code.getCode();
    }

    public int getCount() {
        return count;
    }
}
