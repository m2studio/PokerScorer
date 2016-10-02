package Jirapat.Gambler.Poker;

/**
 This class is a winner Poker player container, to represent the winner and the card
 that make the winner win in case of getting the same rank
 */
public class WinnerPokerPlayer {

    private final PokerPlayer winner;
    private final Card winningCard;

    public WinnerPokerPlayer(PokerPlayer player, Card winningCard) {
        this.winner = player;
        this.winningCard = winningCard;
    }

    public PokerPlayer getWinner() {return this.winner; }
    public Card WinningCard() { return this.winningCard;}

}
