package Jirapat.Gambler.Poker;

import java.util.Hashtable;

/**
 This class is represent Poker Card information.
 It contains card number and card suit
 */
public class Card implements Comparable<Card> {
    /**
     * All valid card number
     */
    private static Hashtable<String, Integer> validNumber = new Hashtable<String, Integer>() {
        {
            put("0",   0);
            put("1",   1);
            put("2",   2);
            put("3",   3);
            put("4",   4);
            put("5",   5);
            put("6",   6);
            put("7",   7);
            put("8",   8);
            put("9",   9);
            put("10", 10);
            put("J",  11);
            put("Q",  12);
            put("K",  13);
            put("A",  14);
        }};

    /**
     * All valid card suit
     */
    private static Hashtable<String, Integer> validSuit = new Hashtable<String, Integer>() {
        {
            put("S",   4);  // spade
            put("H",   3);  // heart
            put("D",   2);  // diamond
            put("C",   1);  // club
        }};

    private String cardCode;
    private String number;
    private String suit;

    /**
     * Instantiates Card object based on card code (eg. 2H, AS)
     * @param cardValue A card code
     */
    public Card(String cardValue) {
        String exceptionFormat = "cardValue[%s] argument was invalid";
        if (cardValue == null) {
            throw new IllegalArgumentException("cardValue argument was null");
        }

        String suit = cardValue.substring(cardValue.length() - 1, cardValue.length());
        if (!validSuit.containsKey(suit)) {
            throw new IllegalArgumentException(String.format(exceptionFormat, cardValue));
        }

        this.suit = suit;

        String cardNumber = cardValue.substring(0, cardValue.length() - 1);
        if (!validNumber.containsKey(cardNumber)) {
            throw new IllegalArgumentException(String.format(exceptionFormat, cardValue));
        }

        this.number = cardNumber;
        this.cardCode = cardValue;
    }

    /**
     * gets card number as String (eg. 1,2,3, ...,10,J,Q,K,A)
     * @return card number
     */
    public String getCardNumber() {
        return this.number;
    }

    /**
     * gets card suit as String (eg. S,H,D,C)
     * @return
     */
    public String getCardSuit() {
        return this.suit;
    }

    /**
     * gets a card value to represent card ranking
     * @return ranking number as Integer
     */
    public Integer getValue() {
        return validNumber.get(number);
    }

    /**
     * gets a card suit value to represent suit ranking
     * @return suit ranking number as Integer
     */
    public Integer getSuitvalue() { return validSuit.get(suit); }

    /**
     * gets card code (eg. AS, 3H)
     * @return card code as String
     */
    public String getCardCode() {
        return this.cardCode;
    }

    @Override
    public String toString() {
        String cardString;
        if (number.equals("A")) {
            cardString = "Ace";
        } else if(number.equals("K")) {
            cardString = "King";
        } else if(number.equals("Q")) {
            cardString = "Queen";
        } else if(number.equals("J")) {
            cardString = "Jack";
        } else {
            cardString = number;
        }

        return cardString;
    }

    @Override
    public int compareTo(Card inputCard) {
        Integer inputValue = inputCard.getValue();

        // descending order
        return inputValue - this.getValue();
    }
}
