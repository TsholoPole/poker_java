package com.company;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4ClassRunner.class)
//@Configuration({MainTestConfiguration.class})
public class MainTest {


    @Test()
    public void straight(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.CLUBS, Ranks.NINE));
        hand.add(new Card(Suits.HEARTS, Ranks.EIGHT));
        hand.add(new Card(Suits.SPADES, Ranks.SEVEN));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));

        assertEquals("Result: Flush", main.evaluateCards(hand));

    }

    @Test()
    public void flush(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.DIAMONDS, Ranks.NINE));
        hand.add(new Card(Suits.DIAMONDS, Ranks.EIGHT));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SEVEN));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));

        assertEquals("Result: Flush", main.evaluateCards(hand));

    }

    @Test()
    public void straightFlush(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.JACK));
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.DIAMONDS, Ranks.NINE));
        hand.add(new Card(Suits.DIAMONDS, Ranks.EIGHT));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SEVEN));

        assertEquals("Result: High card", main.evaluateCards(hand));

    }

    @Test()
    public void threeOfAKind(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.SPADES, Ranks.TEN));
        hand.add(new Card(Suits.CLUBS, Ranks.TEN));
        hand.add(new Card(Suits.DIAMONDS, Ranks.FOUR));
        hand.add(new Card(Suits.SPADES, Ranks.FIVE));

        assertEquals("Result: High card", main.evaluateCards(hand));//not impl

    }

    @Test()
    public void fourOfAKind(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.SPADES, Ranks.TEN));
        hand.add(new Card(Suits.HEARTS, Ranks.TEN));
        hand.add(new Card(Suits.CLUBS, Ranks.TEN));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));

        assertEquals("Result: Four of a Kind!!!", main.evaluateCards(hand));

    }

    @Test()
    public void fiveOfAKind(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));
        hand.add(new Card(Suits.CLUBS, Ranks.SIX));
        hand.add(new Card(Suits.HEARTS, Ranks.SIX));
        hand.add(new Card(Suits.SPADES, Ranks.SIX));
        hand.add(new Card(Suits.SPADES, Ranks.SIX));// this is not possible.

        assertEquals("Result: Five of a kind!!!", main.evaluateCards(hand));

    }

    @Test()
    public void fullHouse(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SIX));
        hand.add(new Card(Suits.SPADES, Ranks.SEVEN));
        hand.add(new Card(Suits.SPADES, Ranks.SEVEN));

        assertEquals("Result: High card", main.evaluateCards(hand));//not impl

    }

    @Test()
    public void onePair(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.SPADES, Ranks.TEN));
        hand.add(new Card(Suits.CLUBS, Ranks.FIVE));
        hand.add(new Card(Suits.DIAMONDS, Ranks.TWO));
        hand.add(new Card(Suits.SPADES, Ranks.FIVE));

        assertEquals("Result: High card", main.evaluateCards(hand));//not impl

    }

    @Test()
    public void twoPair(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.TEN));
        hand.add(new Card(Suits.SPADES, Ranks.TEN));
        hand.add(new Card(Suits.CLUBS, Ranks.TWO));
        hand.add(new Card(Suits.DIAMONDS, Ranks.TWO));
        hand.add(new Card(Suits.SPADES, Ranks.FIVE));

        assertEquals("Result: High card", main.evaluateCards(hand));//not impl

    }

    @Test()
    public void highCard(){

        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suits.DIAMONDS, Ranks.KING));
        hand.add(new Card(Suits.SPADES, Ranks.TEN));
        hand.add(new Card(Suits.CLUBS, Ranks.TWO));
        hand.add(new Card(Suits.DIAMONDS, Ranks.SEVEN));
        hand.add(new Card(Suits.SPADES, Ranks.FIVE));

        assertEquals("Result: High card", main.evaluateCards(hand));
    }

//    @Inject
    Main main;
}
