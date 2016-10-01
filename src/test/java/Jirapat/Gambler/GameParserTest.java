package Jirapat.Gambler;

import Jirapat.Gambler.Poker.Game;
import Jirapat.Gambler.Poker.PokerPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public class GameParserTest {

    @Test
    public void itShouldThrowExceptionIfTextFileInputIsInvalidFormat() throws IOException {
        BufferedReader reader = org.mockito.Mockito.mock(BufferedReader.class);
        when(reader.readLine())
                .thenReturn("Chun: 2H 3D 5S 9C KD ")
                .thenReturn("Lee: 2C 3H 4S 8C");

        GameParser parser = new GameParser(reader);
        boolean hasException = false;
        try {
            List<Game> games = parser.getGames();
        } catch(Exception ex) {
            hasException = true;
        }
        Assert.isTrue(hasException, "It should throw exception if input file is invalid format");
    }

    //@Test
    public void itShouldParseGamesCorrectlyBasedOnInputFile() throws IOException {
        BufferedReader reader = org.mockito.Mockito.mock(BufferedReader.class);
        when(reader.readLine())
            .thenReturn("B: 2C 3H 4S 8C AH")
            .thenReturn("C: 2S 8S AS QS 3S")
            .thenReturn("D: 2H 4S 4C 2D 4H");

        GameParser parser = new GameParser(reader);
        List<Game> games = parser.getGames();
        Assert.isTrue(games.size() == 2);

        List<PokerPlayer> playersGame1 = games.get(0).getPlayers();
        Assert.isTrue(playersGame1.size() == 2);
        Assert.isTrue(playersGame1.get(0).getName().equals("A"));
        Assert.isTrue(playersGame1.get(0).getCards().get(0).getCardCode().equals("2H"));
        Assert.isTrue(playersGame1.get(0).getCards().get(0).getCardCode().equals("3D"));
        Assert.isTrue(playersGame1.get(0).getCards().get(0).getCardCode().equals("5S"));
        Assert.isTrue(playersGame1.get(0).getCards().get(0).getCardCode().equals("9C"));
        Assert.isTrue(playersGame1.get(0).getCards().get(0).getCardCode().equals("KD"));
        Assert.isTrue(playersGame1.get(1).getName().equals("B"));
        Assert.isTrue(playersGame1.get(1).getCards().get(0).getCardCode().equals("2C"));
        Assert.isTrue(playersGame1.get(1).getCards().get(0).getCardCode().equals("3H"));
        Assert.isTrue(playersGame1.get(1).getCards().get(0).getCardCode().equals("4S"));
        Assert.isTrue(playersGame1.get(1).getCards().get(0).getCardCode().equals("8C"));
        Assert.isTrue(playersGame1.get(1).getCards().get(0).getCardCode().equals("AH"));

        List<PokerPlayer> playersGame2 = games.get(0).getPlayers();
        Assert.isTrue(playersGame2.size() == 2);
        Assert.isTrue(playersGame2.get(0).getName().equals("A"));
        Assert.isTrue(playersGame2.get(0).getCards().get(0).getCardCode().equals("2S"));
        Assert.isTrue(playersGame2.get(0).getCards().get(0).getCardCode().equals("8S"));
        Assert.isTrue(playersGame2.get(0).getCards().get(0).getCardCode().equals("AS"));
        Assert.isTrue(playersGame2.get(0).getCards().get(0).getCardCode().equals("QS"));
        Assert.isTrue(playersGame2.get(0).getCards().get(0).getCardCode().equals("3S"));
        Assert.isTrue(playersGame2.get(1).getName().equals("B"));
        Assert.isTrue(playersGame2.get(1).getCards().get(0).getCardCode().equals("2H"));
        Assert.isTrue(playersGame2.get(1).getCards().get(0).getCardCode().equals("4S"));
        Assert.isTrue(playersGame2.get(1).getCards().get(0).getCardCode().equals("4C"));
        Assert.isTrue(playersGame2.get(1).getCards().get(0).getCardCode().equals("2D"));
        Assert.isTrue(playersGame2.get(1).getCards().get(0).getCardCode().equals("4H"));
    }
}
