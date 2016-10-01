package Jirapat.Gambler.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 This class is represent Poker ranking based on the hold cards
 */
public class Rank implements Comparable<Rank> {

    private List<Card> holdCards;
    private RankType rankType;

    private boolean hasPair;
    private boolean hasTwoPairs ;
    private boolean hasTripple;
    private boolean hasStraight;
    private boolean hasFlush;
    private boolean hasFourOfKind;

    private Integer fourCardValue;
    private Integer tripleCardValue;
    private Integer pairCardValue;
    private Integer secondPairCardvalue;

    // If RankType is the same, use kickers to consider which rank is higher.
    private List<Integer> kickers;


    /**
     * Instantiates Rank object based on card set.
     * @param cards A given cards
     */
    public Rank(List<Card> cards)
    {
        if (cards == null || cards.size() != 5) {
            throw new IllegalArgumentException("There must be 5 cards to determine rank");
        }

        // sort cards first
        Collections.sort(cards);
        this.holdCards = cards;
        setRankType(cards);
    }

    /**
     * Determine rank type based on given cards
     * @param cards given cards
     */
    private void setRankType(List<Card> cards) {
        Integer sameNumberCount = 1;
        String lastCardNumber = "";
        Integer sameSuitCount = 1;
        String lastCardSuit = "";
        Integer straightCount = 1;
        Integer lastCardValue = 0;

        String pairCard = "";
        for(Integer i=0; i<cards.size(); i++) {
            Card card = cards.get(i);
            if (lastCardNumber.equals(card.getCardNumber())) {
                sameNumberCount++;
            } else {
                sameNumberCount = 1;
            }

            if (lastCardSuit.equals(card.getCardSuit())) {
                sameSuitCount++;
            } else {
                sameSuitCount = 1;
            }

            if (card.getValue() + 1 == lastCardValue) {
                straightCount++;
            }

            if (sameNumberCount == 2) {
                if (hasPair) {
                    hasTwoPairs = true;
                    secondPairCardvalue = card.getValue();
                } else {
                    hasPair = true;
                    pairCard = card.getCardNumber();
                    pairCardValue = card.getValue();
                }
            } else if(sameNumberCount == 3) {
                hasTripple = true;
                tripleCardValue = card.getValue();
                if (pairCard.equals(card.getCardNumber())) {
                    hasPair = false;
                }
            } else if(sameNumberCount == 4) {
                hasFourOfKind = true;
                fourCardValue = card.getValue();
            }

            if (sameSuitCount == 5) {
                hasFlush = true;
            }

            if (straightCount == 5) {
                hasStraight = true;
            }

            lastCardNumber = card.getCardNumber();
            lastCardSuit = card.getCardSuit();
            lastCardValue = card.getValue();
        }

        // to fix the straight in case of A is the lowest value in the card set
        if (straightCount == 4
                && cards.get(0).getCardNumber().equals("A")
                && cards.get(4).getCardNumber().equals("2")) {
            hasStraight = true;
        }

        // finalize ranking
        if (hasStraight && hasFlush) {
            if (cards.get(0).getCardNumber().equals("A")
                    && cards.get(4).getCardNumber().equals("10")) {
                rankType = RankType.RoyalStraightFlush;
            } else {
                rankType = RankType.StraightFlush;
            }
        } else if (hasFourOfKind) {
            rankType = RankType.FourOfAKind;
        } else if (hasTripple && hasPair) {
            rankType = RankType.FullHouse;
        } else if (hasFlush) {
            rankType = RankType.Flush;
        } else if (hasStraight) {
            rankType = RankType.Straight;
        } else if (hasTripple) {
            rankType = RankType.Triple;
        } else if (hasTwoPairs) {
            rankType = RankType.TwoPairs;
        } else if (hasPair) {
            rankType = RankType.Pair;
        } else {
            rankType = RankType.HighCard;
        }
    }

    /**
     * gets current rank type
     * @return rank type
     */
    public RankType getRankType() {
        return this.rankType;
    }

    private void setupKicker() {
        if (kickers != null) return;

        kickers = new ArrayList<>();

        if (this.rankType == RankType.RoyalStraightFlush) {
            kickers.add(this.holdCards.get(0).getSuitvalue());
        } else if(this.rankType == RankType.StraightFlush) {
            kickers.add(this.holdCards.get(0).getValue());
        } else if (this.rankType == RankType.FourOfAKind) {
            kickers.add(this.fourCardValue);
            Integer highCardValue = this.holdCards.stream().filter(c -> c.getValue() != this.fourCardValue)
                     .findFirst().get().getValue();
            kickers.add(highCardValue);
        } else if (this.rankType == RankType.FullHouse) {
            kickers.add(this.tripleCardValue);
            kickers.add(this.pairCardValue);
        } else if (this.rankType == RankType.Flush) {
            kickers.add(this.holdCards.get(0).getValue());
        } else if (this.rankType == RankType.Straight) {
            if (holdCards.get(0).getCardNumber().equals("A")
            && holdCards.get(4).getCardNumber().equals("2")) {
                kickers.add(holdCards.get(4).getValue());
            } else {
                kickers.add(holdCards.get(0).getValue());
            }
        } else if (this.rankType == RankType.Triple) {
            kickers.add(this.tripleCardValue);
        } else if (this.rankType == RankType.TwoPairs) {
            if (pairCardValue > secondPairCardvalue) {
                kickers.add(pairCardValue);
                kickers.add(secondPairCardvalue);
            } else {
                kickers.add(secondPairCardvalue);
                kickers.add(pairCardValue);
            }

            Integer highCardvalue = this.holdCards.stream()
                    .filter(c -> c.getValue() != pairCardValue && c.getValue() != secondPairCardvalue)
                    .findFirst().get().getValue();
            kickers.add(highCardvalue);
        } else if (this.rankType == RankType.Pair) {
            kickers.add(pairCardValue);
            for(Integer i=0; i<holdCards.size(); i++) {
                Card card = holdCards.get(i);
                if (card.getValue() != pairCardValue) {
                    kickers.add(card.getValue());
                    break;
                }
            }

        } else {
            // high card, checks the first two highest values
            kickers.add(holdCards.get(0).getValue());
            kickers.add(holdCards.get(1).getValue());
        }
    }

    private int compareKicker(Rank inputRank) {
        inputRank.setupKicker();
        this.setupKicker();
        List<Integer> inputKickers = inputRank.kickers;

        Integer compare = 0;
        for(Integer i=0; i<inputKickers.size(); i++) {
            Integer inputKicker = inputKickers.get(i);
            Integer currentKicker = this.kickers.get(i);

            if (inputKicker != currentKicker) {
                compare = inputKicker - currentKicker;
                break;
            }
        }
        return compare;
    }

    @Override
    public int compareTo(Rank inputRank) {
        Integer compare = 0;
        if (inputRank.getRankType() != this.getRankType()) {
            compare = inputRank.getRankType().getValue() - this.getRankType().getValue();
        } else {
            // need to find kicker and compare
            compare = this.compareKicker(inputRank);
        }
        return compare;
    }
}
