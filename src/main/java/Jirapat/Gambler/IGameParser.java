package Jirapat.Gambler;

import Jirapat.Gambler.Poker.Game;

import java.util.List;

/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public interface IGameParser {

    /**
     * gets Poker games
     * @return Poker games
     */
    List<Game> getGames();
}
