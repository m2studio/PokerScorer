package Jirapat.Gambler;

import Jirapat.Gambler.Poker.PokerPlayer;
import Jirapat.Gambler.Poker.RankType;
import Jirapat.Gambler.Poker.WinnerPokerPlayer;

/**
 This class is responsible for printing winner of each Poker games.
 */
public class GamePrinter implements IGamePrinter {

    /**
     * Prints winner score to screen.
     * @param winner A given winner Poker player
     */
    @Override
    public void PrintWinnerScore(WinnerPokerPlayer winner) {
        String text;
        PokerPlayer player = winner.getWinner();
        if (player.getRank().getRankType() == RankType.HighCard) {
            text = String.format("%s wins. - with %s: %s"
                    , player.getName()
                    , player.getRank().getRankType().toString()
                    , winner.WinningCard().toString());
        } else {
            text = String.format("%s wins. - with %s", player.getName(), player.getRank().getRankType().toString());
        }

        System.out.println(text);
    }

    /**
     * Print tie text to screen.
     */
    @Override
    public void PrintTie() {
        System.out.println("Tie.");
    }
}
