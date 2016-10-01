package Jirapat.Gambler;

import Jirapat.Gambler.Poker.Game;
import Jirapat.Gambler.Poker.WinnerPokerPlayer;

import java.util.List;

/**
 This class is responsible for processing games
 */
public class GameManager {

    private final IGameParser gameParser;
    private final IGamePrinter gamePrinter;

    /**
     * Instantiates GameManager object
     * @param gameParser game parser for parsing input games
     * @param gamePrinter game printer for printing game output
     */
    public GameManager(IGameParser gameParser, IGamePrinter gamePrinter) {
        this.gameParser = gameParser;
        this.gamePrinter = gamePrinter;
    }

    /**
     * processes all games
     */
    public void process() {
        List<Game> games = gameParser.getGames();
        for(Integer i=0; i<games.size(); i++) {
            Game game = games.get(i);
            WinnerPokerPlayer winner = game.findWinner();
            if (winner == null) {
                gamePrinter.PrintTie();
            } else {
                gamePrinter.PrintWinnerScore(winner);
            }
        }
    }
}
