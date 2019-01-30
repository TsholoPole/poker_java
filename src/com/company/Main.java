package com.company;

import java.util.*;

public class Main {

    List<Card> testHand = new ArrayList<>();

    List<Card> hand = new ArrayList<>(5);
    List<Card> cards = new ArrayList<Card>();
    private static  String result = "";
    private Random mRandom;

    public static void main(String[] args) {

        //PLAY
        System.out.println("--------------POKER------------------");

        Main main = new Main();

        main.initDeck();

        System.out.print(result);

        System.out.println("\n----- Done\n");
    }

    public void initDeck(){

//        System.out.print("\n\n---- Initialising deck ------");
        /* Creating all possible cards... */
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card c = new Card(s,r);
                this.cards.add(c);
            }
        }

        Collections.shuffle(this.cards);
        this.dealCards();
        result = evaluateCards(this.hand);

    }

    public void dealCards() {

        System.out.println("\n\n---- Dealing player's hand...");

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

//        hand.add(new Card(Suits.DIAMONDS, Ranks.FOUR));
//        this.hand.add(new Card(Suits.CLUBS, Ranks.FOUR));
//        this.hand.add(new Card(Suits.HEARTS, Ranks.FOUR));
//        this.hand.add(new Card(Suits.SPADES, Ranks.FOUR));
//        this.hand.add(new Card(Suits.DIAMONDS, Ranks.FIVE));
//        this.hand.add(new Card(Suits.DIAMONDS, Ranks.SEVEN));

    }


    public String evaluateCards(List<Card> theHand) {
        System.out.println("\n\n--------- Evaluating Cards ----------");

        System.out.print("\nHand: ");
        for(int i = 0; i < theHand.size(); i++){
            Card card = theHand.get(i);
            System.out.print(card.getRank().value() + card.getSuit().value());
        }
        System.out.println();

        //card evaluation
        //Five of a kind
        int five = 0;
        Ranks theRank = theHand.get(0).getRank();//use the first rank as a base
        for(int i=0; i< theHand.size(); i++) {
            if(theHand.get(i).getRank() == theRank) {
                five += 1;
            }
        }
        if(five == 5){
//            System.out.println("Result: Five of a kind!!!");
            return "Result: Five of a kind!!!";
        }

        //STRAIGHT FLUSH
        Suits baseSuit = theHand.get(0).getSuit();
        int fiveSuits = 0;
        for(int i=0; i< theHand.size(); i++) {
            if(theHand.get(i).getSuit() == baseSuit) {
                fiveSuits += 1;
            }
        }
        //All cards have the same suit
        if(fiveSuits == 5) {
            System.out.println("Cards with same suit: " + theHand.get(0).getSuit());

            //Jack high-straight flush
            Suits theSuit = theHand.get(0).getSuit();

            if(theHand.contains(new Card(theSuit, Ranks.JACK))){
                if(theHand.contains(new Card(theSuit,Ranks.TEN))){
                    if(theHand.contains(new Card(theSuit,Ranks.NINE))){
                        if(theHand.contains(new Card(theSuit,Ranks.EIGHT))){
                            if(theHand.contains(new Card(theSuit,Ranks.SEVEN))){
//                                System.out.println("Result: Jack-high Straight flush");
                                return "Result: Jack-high Straight flush";
                            }
                        }
                    }
                }
            }

            //Queen high-straight flush
            if (theHand.contains(new Card(theSuit,Ranks.QUEEN)))
                if (theHand.contains(new Card(theSuit,Ranks.JACK)))
                    if (theHand.contains(new Card(theSuit,Ranks.TEN)))
                        if (theHand.contains(new Card(theSuit,Ranks.NINE)))
                            if (theHand.contains(new Card(theSuit,Ranks.EIGHT))){
//                                System.out.println("Result: Queen-high Straight flush");
                                return "Result: Queen-high Straight flush";
                            }

            //Ace-high straight flush
            if (theHand.contains(new Card(theSuit,Ranks.ACE)))
                if (theHand.contains(new Card(theSuit,Ranks.KING)))
                    if (theHand.contains(new Card(theSuit,Ranks.QUEEN)))
                        if (theHand.contains(new Card(theSuit,Ranks.JACK)))
                            if (theHand.contains(new Card(theSuit,Ranks.TEN))){
//                                System.out.println("Result: Ace-high Straight flush");
                                return "Result: Ace-high Straight flush";
                            }

            //Five high-straight flush
            if (theHand.contains(new Card(theSuit,Ranks.FIVE)))
                if (theHand.contains(new Card(theSuit,Ranks.FOUR)))
                    if (theHand.contains(new Card(theSuit,Ranks.THREE)))
                        if (theHand.contains(new Card(theSuit,Ranks.TWO)))
                            if (theHand.contains(new Card(theSuit,Ranks.ACE))){
//                                System.out.println("Result: Five-High Straight flush");
                                return "Result: Five-High Straight flush";
                            }

            //Ace high-straight flush
            if (theHand.contains(new Card(theSuit,Ranks.QUEEN)))
                if (theHand.contains(new Card(theSuit,Ranks.KING)))
                    if (theHand.contains(new Card(theSuit,Ranks.THREE)))
                        if (theHand.contains(new Card(theSuit,Ranks.TWO)))
                            if (theHand.contains(new Card(theSuit,Ranks.ACE))){
//                                System.out.println("Result: Ace-High Straight flush");
                                return "Result: Ace-High Straight flush";
                            }
            //King high-straight flush
            if (theHand.contains(new Card(theSuit,Ranks.QUEEN)))
                if (theHand.contains(new Card(theSuit,Ranks.KING)))
                    if (theHand.contains(new Card(theSuit,Ranks.JACK)))
                        if (theHand.contains(new Card(theSuit,Ranks.TEN)))
                            if (theHand.contains(new Card(theSuit,Ranks.ACE))){
//                                System.out.println("Result: King-High Straight flush");
                                return "Result: King-High Straight flush";
                            }

            //Nine high-straight flush
            if(theHand.contains(new Card(theSuit,Ranks.NINE)))
                if(theHand.contains(new Card(theSuit,Ranks.EIGHT)))
                    if(theHand.contains(new Card(theSuit,Ranks.SEVEN)))
                        if(theHand.contains(new Card(theSuit,Ranks.SIX)))
                            if(theHand.contains(new Card(theSuit,Ranks.FIVE))){
//                                System.out.println("Result: Nine-High Straight flush");
                                return "Result: Nine-High Straight flush";
                            }
            return null;
        }

        //FOUR OF A KIND
        if(fourOfAKind(theHand.get(0), theHand)){
//            System.out.println("Result: Four of a Kind!!!");
            return "Result: Four of a Kind!!!";
        }

        //Flush
        Suits flushSuit = theHand.get(0).getSuit();
        int flushSuits = 0;
        for(int i=0; i< theHand.size(); i++) {
            if(theHand.get(i).getSuit() == flushSuit) {
                flushSuits += 1;
            }
        }
        if(flushSuits == 5){
            if(theHand.contains(new Card(flushSuit, Ranks.KING))){
//                System.out.println("Result: King-High flush");
                return "Result: King-High flush";
            }

            return "Result: Flush";
//            System.out.println("Flush");
        }

        //TWO PAIR


        //High Card

//        System.out.println("\n-- theHand evaluated\n");
        return "Result: High card";
    }

        private boolean fourOfAKind(Card card, List<Card> cardLists){
            Ranks tempRank = card.getRank();

            //System.out.println("\n--" + tempRank );

            int temp = 0;
            /* Creating all possible cards with rank... */
            for (Suits s : Suits.values()) {
                Card c = new Card(s,tempRank);
//                System.out.println("\n--" + c.getSuit() + c.getRank() );
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
