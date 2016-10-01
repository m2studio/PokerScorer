package Jirapat.Gambler.Poker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public class GameTest {

    @Test
    public void findWinnerMethodShouldReturnCorrectWinner() {
        // Flush
        PokerPlayer player1 = new PokerPlayer("name1");
        player1.addCard(new Card("3S"));
        player1.addCard(new Card("JS"));
        player1.addCard(new Card("QS"));
        player1.addCard(new Card("KS"));
        player1.addCard(new Card("AS"));

        // Straight
        PokerPlayer player2 = new PokerPlayer("name2");
        player2.addCard(new Card("10S"));
        player2.addCard(new Card("JH"));
        player2.addCard(new Card("QD"));
        player2.addCard(new Card("KC"));
        player2.addCard(new Card("AD"));

        Game game = new Game(player1, player2);
        WinnerPokerPlayer winner = game.findWinner();
        Assert.isTrue(winner.getWinner() == player1);
    }

    @Test
    public void findWinnerMethodShouldReturnCorrectWinnerAndWinningCard() {
        PokerPlayer player1 = new PokerPlayer("name1");
        player1.addCard(new Card("2H"));
        player1.addCard(new Card("3D"));
        player1.addCard(new Card("5S"));
        player1.addCard(new Card("9C"));
        player1.addCard(new Card("KD"));

        PokerPlayer player2 = new PokerPlayer("name2");
        player2.addCard(new Card("2C"));
        player2.addCard(new Card("3H"));
        player2.addCard(new Card("4S"));
        player2.addCard(new Card("8C"));
        player2.addCard(new Card("KH"));

        Game game = new Game(player1, player2);
        WinnerPokerPlayer winner = game.findWinner();
        Assert.isTrue(winner.getWinner() == player1);
        Assert.isTrue(winner.WinningCard().toString().equals("9"));
    }

    @Test
    public void findWinnerMethodShouldReturnNullIfTheRankOfAllPlayersIsTheSame() {
        // High card
        PokerPlayer player1 = new PokerPlayer("name1");
        player1.addCard(new Card("2D"));
        player1.addCard(new Card("3H"));
        player1.addCard(new Card("5C"));
        player1.addCard(new Card("9S"));
        player1.addCard(new Card("KH"));

        // High card
        PokerPlayer player2 = new PokerPlayer("name2");
        player2.addCard(new Card("2H"));
        player2.addCard(new Card("3D"));
        player2.addCard(new Card("5S"));
        player2.addCard(new Card("9C"));
        player2.addCard(new Card("KD"));

        Game game = new Game(player1, player2);
        WinnerPokerPlayer winner = game.findWinner();
        Assert.isNull(winner);
    }

    @Test
    public void itShouldReturnCorrectPlayerInGame() {
        PokerPlayer player1 = new PokerPlayer("p1");
        PokerPlayer player2 = new PokerPlayer("p2");
        Game game = new Game(player1, player2);
        List<PokerPlayer> actualPlayers = game.getPlayers();
        Assert.isTrue(actualPlayers.size() == 2);
        Assert.isTrue(actualPlayers.get(0) == player1);
        Assert.isTrue(actualPlayers.get(1) == player2);
    }
}
