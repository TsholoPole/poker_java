package com.company;

import java.util.*;

public class Main {

    List<Card> testHand = new ArrayList<>();

    List<Card> hand = new ArrayList<>(5);
    List<Card> cards = new ArrayList<Card>();
    private Random mRandom;

    public static void main(String[] args) {
	// write your code here

        //PLAY
        System.out.println("--------------POKER------------------");

        Main main = new Main();


        main.initDeck();

        //String result = evaluateCards();

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
//        int j = 51;
//
//        for(int i =0; i < 5; i++) {
//            if (this.cards.isEmpty()) {
//                System.out.println("---- Cards are empty.");
//                return;
//            }
//            if (this.cards.get(j) != null) {
////                System.out.println("Current card: " + this.cards.get(j));
//                this.hand.add(this.cards.remove(j));
//            }
//            j--;
//        }


        hand.add(new Card(Suits.DIAMONDS, Ranks.FOUR));
        this.hand.add(new Card(Suits.CLUBS, Ranks.FOUR));
        this.hand.add(new Card(Suits.HEARTS, Ranks.FOUR));
        this.hand.add(new Card(Suits.SPADES, Ranks.FOUR));
        this.hand.add(new Card(Suits.DIAMONDS, Ranks.FOUR));
//        this.hand.add(new Card(Suits.DIAMONDS, Ranks.SEVEN));
        evaluateCards();
    }


    public void evaluateCards() {
        System.out.println("\n\n--------- Evaluating Cards ----------");

        for(int i = 0; i < this.hand.size(); i++){
            Card card = this.hand.get(i);
            System.out.println("Card: " + card.getRank().value() + card.getSuit().value());
        }

        //do card evaluation
        //Five of a kind
        int five = 0;
        Ranks theRank = this.hand.get(0).getRank();//use the first rank as a base
        for(int i=0; i< this.hand.size(); i++) {
            if(this.hand.get(i).getRank() == theRank) {
                five += 1;
            }
        }
        if(five == 5){
            System.out.println("Five of a kind!!!");
            return;
        }

        //STRAIGHT FLUSH
        Suits baseSuit = this.hand.get(0).getSuit();
        int fiveSuits = 0;
        for(int i=0; i< this.hand.size(); i++) {
            if(this.hand.get(i).getSuit() == baseSuit) {
                fiveSuits += 1;
            }
        }
        //All cards have the same suit
        if(fiveSuits == 5) {
            System.out.println("Cards with same suit: " + this.hand.get(0).getSuit());

            //Jack high-straight flush
            Suits theSuit = hand.get(0).getSuit();

            if(this.hand.contains(new Card(theSuit, Ranks.JACK))){
                if(hand.contains(new Card(theSuit,Ranks.TEN))){
                    if(hand.contains(new Card(theSuit,Ranks.NINE))){
                        if(hand.contains(new Card(theSuit,Ranks.EIGHT))){
                            if(hand.contains(new Card(theSuit,Ranks.SEVEN))){
                                System.out.println("Jack-high Straight flush");
                                return;
                            }
                        }
                    }
                }
            }

            //Queen high-straight flush
            if (this.hand.contains(new Card(theSuit,Ranks.QUEEN)))
                if (this.hand.contains(new Card(theSuit,Ranks.JACK)))
                    if (this.hand.contains(new Card(theSuit,Ranks.TEN)))
                        if (this.hand.contains(new Card(theSuit,Ranks.NINE)))
                            if (this.hand.contains(new Card(theSuit,Ranks.EIGHT))){
                                System.out.println("Queen-high Straight flush");
                                return;
                            }

            //Ace-high straight flush
            if (this.hand.contains(new Card(theSuit,Ranks.ACE)))
                if (this.hand.contains(new Card(theSuit,Ranks.KING)))
                    if (this.hand.contains(new Card(theSuit,Ranks.QUEEN)))
                        if (this.hand.contains(new Card(theSuit,Ranks.JACK)))
                            if (this.hand.contains(new Card(theSuit,Ranks.TEN))){
                                System.out.println("Ace-high Straight flush");
                                return;
                            }

            //Five high-straight flush
            if (this.hand.contains(new Card(theSuit,Ranks.FIVE)))
                if (this.hand.contains(new Card(theSuit,Ranks.FOUR)))
                    if (this.hand.contains(new Card(theSuit,Ranks.THREE)))
                        if (this.hand.contains(new Card(theSuit,Ranks.TWO)))
                            if (this.hand.contains(new Card(theSuit,Ranks.ACE))){
                                System.out.println("Five-High Straight flush");
                                return;
                            }

            //Ace high-straight flush
            if (this.hand.contains(new Card(theSuit,Ranks.QUEEN)))
                if (this.hand.contains(new Card(theSuit,Ranks.KING)))
                    if (this.hand.contains(new Card(theSuit,Ranks.THREE)))
                        if (this.hand.contains(new Card(theSuit,Ranks.TWO)))
                            if (this.hand.contains(new Card(theSuit,Ranks.ACE))){
                                System.out.println("Ace-High Straight flush");
                                return;
                            }
            //King high-straight flush
            if (this.hand.contains(new Card(theSuit,Ranks.QUEEN)))
                if (this.hand.contains(new Card(theSuit,Ranks.KING)))
                    if (this.hand.contains(new Card(theSuit,Ranks.JACK)))
                        if (this.hand.contains(new Card(theSuit,Ranks.TEN)))
                            if (this.hand.contains(new Card(theSuit,Ranks.ACE))){
                                System.out.println("King-High Straight flush");
                                return;
                            }

            //Nine high-straight flush
            if(this.hand.contains(new Card(theSuit,Ranks.NINE)))
                if(this.hand.contains(new Card(theSuit,Ranks.EIGHT)))
                    if(this.hand.contains(new Card(theSuit,Ranks.SEVEN)))
                        if(this.hand.contains(new Card(theSuit,Ranks.SIX)))
                            if(this.hand.contains(new Card(theSuit,Ranks.FIVE))){
                                System.out.println("Nine-High Straight flush");
                                return;
                            }
            return;
        }

        //FOUR OF A KIND
        if(fourOfAKind(this.hand.get(0), this.hand)){
            System.out.println("Four of a Kind!!!");
            return;
        }

        //Flush
        Suits flushSuit = this.hand.get(0).getSuit();
        int flushSuits = 0;
        for(int i=0; i< this.hand.size(); i++) {
            if(this.hand.get(i).getSuit() == flushSuit) {
                flushSuits += 1;
            }
        }
        if(flushSuits == 5){
            if(this.hand.contains(Ranks.KING)){
                System.out.println("King-High flush");
                return;
            }

            System.out.println("Flush");
        }

        //TWO PAIR



        System.out.println("\n-- Hand evaluated\n");
        //evaluate cards at this point
        }

        private boolean fourOfAKind(Card card, List<Card> cardLists){
            Ranks tempRank = card.getRank();

            //System.out.println("\n--" + tempRank );

            int temp = 0;
            /* Creating all possible cards with rank... */
            for (Suits s : Suits.values()) {
                Card c = new Card(s,tempRank);
                System.out.println("\n--" + c.getSuit() + c.getRank() );
                if(cardLists.contains(c)){
                    //System.out.println("\n-- c found"  );
                    temp+=1;
                }
            }

            if(temp > 3){
                return true;
            }
            return false;
        }
}
