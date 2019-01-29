package com.company;

public class Card {
    private Suits suit;
    private Ranks rank;

    public Card(Ranks rank) {
        this.rank = rank;
    }

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Card))
            return false;
        Card otherCard = (Card) other;
        return (this.getSuit()==otherCard.getSuit() && this.getRank()==otherCard.getRank()) &&
                (this.getClass().getName().equals(otherCard.getClass().getName()));
    }
}
