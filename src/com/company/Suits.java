package com.company;

public enum Suits {
    SPADES((char)'\u2660'),
    HEARTS((char)'\u2665'),
    DIAMONDS((char)'\u2666'),
    CLUBS((char)'\u2663');

    private final char value;

    private Suits(char value) {
        this.value = value;
    }

    public char value() {
        return this.value;
    }
}
