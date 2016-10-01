package Jirapat.Gambler;

import Jirapat.Gambler.Poker.Card;
import Jirapat.Gambler.Poker.Game;
import Jirapat.Gambler.Poker.PokerPlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 This class is responsible for parsing input text files to be Poker games.
 */
public class GameParser implements IGameParser {

    private final Integer PLAYER_NUMBER = 2;
    private final BufferedReader reader;

    /**
     * Instantiates GameParser object
     * @param reader BufferedReader
     */
    public GameParser(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public List<Game> getGames() throws IllegalFormatException {
        List<Game> games = new ArrayList<>();
        try
        {
            String sCurrentLine;
            List<PokerPlayer> players = new ArrayList<>();
            Integer playerCount = 0;
            while ((sCurrentLine = reader.readLine()) != null) {

                if (sCurrentLine.trim().length() != 0) {
                    String[] input = sCurrentLine.split(":");
                    //System.out.println("new player name : " + input[0]);
                    PokerPlayer player = new PokerPlayer(input[0]);
                    String[] cardInputs = input[1].trim().split(" ", 0);
                    if (cardInputs.length != 5) {
                        throw new IllegalArgumentException("File format was incorrect");
                    }

                    for(Integer i=0; i<cardInputs.length; i++) {
                        //System.out.println("adding card: " + cardInputs[i]);
                        player.addCard(new Card(cardInputs[i].trim()));
                    }
                    players.add(player);
                    playerCount++;

                    if (playerCount == PLAYER_NUMBER) {
                        games.add(new Game(players.get(0), players.get(1)));
                        players.clear();
                        playerCount = 0;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (this.reader != null) {
                try {
                    this.reader.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }

        return games;
    }
}
