package Jirapat.Gambler.Poker;

/**
 * Created by Windows 10 Pro on 1/10/2559.
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
