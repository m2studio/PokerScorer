package Jirapat.Gambler.Poker;

import java.util.ArrayList;
import java.util.List;

/**
 This class is represent Poker player information
 */
public class PokerPlayer implements Comparable<PokerPlayer> {
    private String name;
    private List<Card> holdCards;

    /**
     * Instantiates PokerPlayer object
     * @param name Poker player name
     */
    public PokerPlayer(String name) {
        this.name = name;
        this.holdCards = new ArrayList<>();
    }

    /**
     * adds Poker card to current player
     * @param card
     */
    public void addCard(Card card) {
        this.holdCards.add(card);
    }

    /**
     * gets Poker rank
     * @return Poker rank
     */
    public Rank getRank() {
        Rank rank = new Rank(this.holdCards);
        return rank;
    }

    /**
     * gets player name
     * @return player name
     */
    public String getName() { return name;}

    /**
     * gets hold cards of current player
     * @return
     */
    public List<Card> getCards() { return this.holdCards; }

    /**
     * compares ranking between current player and a given player
     * @param inputPlayer a given player you would like to compare with
     * @return 1 if current player has higher rank, -1 if a given player has higher rank
     * otherwise return 0
     */
    @Override
    public int compareTo(PokerPlayer inputPlayer) {
        return this.getRank().compareTo(inputPlayer.getRank());
    }
}
