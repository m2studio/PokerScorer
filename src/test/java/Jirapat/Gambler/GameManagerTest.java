package Jirapat.Gambler;

import Jirapat.Gambler.Poker.Card;
import Jirapat.Gambler.Poker.Game;
import Jirapat.Gambler.Poker.PokerPlayer;
import Jirapat.Gambler.Poker.WinnerPokerPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GameManagerTest {

    @Test
    public void gameManagerShouldPrintWinnerScore() {

        IGameParser gameParser = mock(GameParser.class);
        IGamePrinter gamePrinter = mock(GamePrinter.class);

        List<Game> games = new ArrayList<>();
        //p1: 2H 3D 5S 9C KD
        //p2: 2C 3H 4S 8C AH
        PokerPlayer player1 = new PokerPlayer("p1");
        player1.addCard(new Card("2H"));
        player1.addCard(new Card("3D"));
        player1.addCard(new Card("5S"));
        player1.addCard(new Card("9C"));
        player1.addCard(new Card("KD"));
        PokerPlayer player2 = new PokerPlayer("p2");
        player2.addCard(new Card("2C"));
        player2.addCard(new Card("3H"));
        player2.addCard(new Card("4S"));
        player2.addCard(new Card("8C"));
        player2.addCard(new Card("AH"));
        Game game1 = new Game(player1, player2);
        games.add(game1);

        when(gameParser.getGames()).thenReturn(games);
        GameManager gameManager = new GameManager(gameParser, gamePrinter);
        gameManager.process();
        verify(gameParser).getGames();
        verify(gamePrinter).PrintWinnerScore(any(WinnerPokerPlayer.class));
        verify(gamePrinter, never()).PrintTie();
    }

    @Test
    public void gameManagerShouldPrintTieIfThereIsNoWinner() {

        IGameParser gameParser = mock(GameParser.class);
        IGamePrinter gamePrinter = mock(GamePrinter.class);

        List<Game> games = new ArrayList<>();
        //p1: 2D 3H 5C 9S KH
        //p2: 2H 3D 5S 9C KD
        PokerPlayer player1 = new PokerPlayer("p1");
        player1.addCard(new Card("2D"));
        player1.addCard(new Card("3H"));
        player1.addCard(new Card("5C"));
        player1.addCard(new Card("9S"));
        player1.addCard(new Card("KH"));
        PokerPlayer player2 = new PokerPlayer("p2");
        player2.addCard(new Card("2H"));
        player2.addCard(new Card("3D"));
        player2.addCard(new Card("5S"));
        player2.addCard(new Card("9C"));
        player2.addCard(new Card("KD"));
        Game game1 = new Game(player1, player2);
        games.add(game1);

        when(gameParser.getGames()).thenReturn(games);
        GameManager gameManager = new GameManager(gameParser, gamePrinter);
        gameManager.process();
        verify(gameParser).getGames();
        verify(gamePrinter).PrintTie();
        verify(gamePrinter, never()).PrintWinnerScore(any(WinnerPokerPlayer.class));
    }
}
