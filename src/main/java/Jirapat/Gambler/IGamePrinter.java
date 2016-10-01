package Jirapat.Gambler;

import Jirapat.Gambler.Poker.PokerPlayer;
import Jirapat.Gambler.Poker.WinnerPokerPlayer;

/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public interface IGamePrinter {
    void PrintWinnerScore(WinnerPokerPlayer player);
    void PrintTie();
}
