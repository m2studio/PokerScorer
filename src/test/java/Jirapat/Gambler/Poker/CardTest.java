package Jirapat.Gambler.Poker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Hashtable;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public class CardTest {

    @Test
    public void cardConstructorShouldThrowIllegalArgumentExceptionIfTheInputIsInvalid() {
        String[] inputSet = new String[4];
        inputSet[0] = null;
        inputSet[1] = "AZ";
        inputSet[2] = "BS";
        inputSet[3] = "11S";

        for(String input : inputSet){
            Boolean setAssertion = false;
            try {
                Card card = new Card(input);
            } catch(Exception ex) {
                Assert.isTrue(ex instanceof IllegalArgumentException);
                setAssertion = true;
            }

            Assert.isTrue(setAssertion, "Card value : " + input + ", should throw IllegalArgumentException");
        }
    }

    @Test
    public void shouldReturnCorrectCardValue() {
        Hashtable<String, Integer> validNumber = new Hashtable<String, Integer>() {
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

        validNumber.forEach( (k, v) -> {
            String cardCode = k + "S";
            Card card = new Card(cardCode);
            Assert.isTrue(card.getCardCode().equals(cardCode));
            Assert.isTrue(card.getValue() == v);
            Assert.isTrue(card.getCardNumber().equals(k));
        });
    }

    @Test
    public void shouldReturnCorrectCardSuit() {
        Hashtable<String, Integer> validSuit = new Hashtable<String, Integer>() {
            {
                put("S",   4);  // spade
                put("H",   3);  // heart
                put("D",   2);  // diamond
                put("C",   1);  // club
            }};

        validSuit.forEach( (k, v) -> {
            Card card = new Card("A" + k);
            Assert.isTrue(card.getSuitvalue() == v);
        });
    }

    @Test
    public void cardComparableShouldSortByDescending() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S"));
        cards.add(new Card("3C"));
        cards.add(new Card("10S"));
        cards.add(new Card("AS"));
        cards.add(new Card("KD"));

        Collections.sort(cards);
        Assert.isTrue(cards.get(0).getCardCode() == "AS");
        Assert.isTrue(cards.get(1).getCardCode() == "KD");
        Assert.isTrue(cards.get(2).getCardCode() == "10S");
        Assert.isTrue(cards.get(3).getCardCode() == "7S");
        Assert.isTrue(cards.get(4).getCardCode() == "3C");
    }

    @Test
    public void itShouldReturnCorrectStringValueFromToStringMethod(){
        Card c1 = new Card("AS");
        Assert.isTrue(c1.toString().equals("Ace"));

        Card c2 = new Card("KS");
        Assert.isTrue(c2.toString().equals("King"));

        Card c3 = new Card("QS");
        Assert.isTrue(c3.toString().equals("Queen"));

        Card c4 = new Card("JS");
        Assert.isTrue(c4.toString().equals("Jack"));

        Card c5 = new Card("10S");
        Assert.isTrue(c5.toString().equals("10"));

        Card c6 = new Card("2S");
        Assert.isTrue(c6.toString().equals("2"));
    }
}
