package com.company;

import java.util.*;

public class Main {

//    List<String> deck = new ArrayList<>(52);
    List<Card> hand = new ArrayList<>(5);
    List<Card> cards = new ArrayList<Card>();
    private Random mRandom;

    public static void main(String[] args) {
	// write your code here

        //PLAY
        System.out.println("--------------POKER------------------");

        Main main = new Main();


        main.initDeck();

        System.out.print("----- Done");
    }

    public void initDeck(){

        System.out.print("\n\n---- Initialising deck ------");

        /* Creating all possible cards... */
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card c = new Card(s,r);
                this.cards.add(c);
            }
        }

        System.out.println("-------- Shuffling cards ---------------");
        Collections.shuffle(this.cards);

//        System.out.println("Shuffled cards array: " + this.cards);

        this.dealCards();
    }

    public void dealCards() {

        System.out.println("\n\n---- Dealing player's hand...");

        System.out.println("Size: s" + this.cards.size());
        int j = 51;

        for(int i =0; i < 5; i++) {
            if (this.cards.isEmpty()) {
                System.out.println("---- Cards are empty.");
                return;
            }

            if (this.cards.get(j) != null) {
//                System.out.println("Current card: " + this.cards.get(j));
                this.hand.add(this.cards.remove(j));
            }
            j--;

        }

        this.evaluateCards();
    }


    public void evaluateCards() {
        System.out.println("\n\n--------- Evaluating Cards ----------");

        for(int i = 0; i < this.hand.size(); i++){
            Card card = this.hand.get(i);
            System.out.println("Card: " + card.getRank().value() + card.getSuit().value());
        }

        //do card evaluation
        

        //evaluate cards at this point
        }
}
