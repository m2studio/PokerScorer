package Jirapat.Gambler;

import Jirapat.Gambler.Poker.Card;
import Jirapat.Gambler.Poker.PokerPlayer;
import Jirapat.Gambler.Poker.WinnerPokerPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamePrinterTest {

    @Test
    public void itShouldPrintCorrectTieText() {
        IPrinter printer = mock(Printer.class);
        GamePrinter gamePrinter = new GamePrinter(printer);
        gamePrinter.PrintTie();
        verify(printer).print("Tie.");
    }

    @Test
    public void itShouldPrintCorrectWinnerTextWithHighCard() {
        IPrinter printer = mock(Printer.class);
        GamePrinter gamePrinter = new GamePrinter(printer);
        PokerPlayer player1 = new PokerPlayer("Lee");
        Card highCard = new Card("KD");
        player1.addCard(new Card("2H"));
        player1.addCard(new Card("3D"));
        player1.addCard(new Card("5S"));
        player1.addCard(new Card("9C"));
        player1.addCard(highCard);

        WinnerPokerPlayer winnerPokerPlayer = new WinnerPokerPlayer(player1, highCard);
        gamePrinter.PrintWinnerScore(winnerPokerPlayer);
        verify(printer).print(String.format("%s wins. - with %s: %s"
                , player1.getName()
                , player1.getRank().getRankType().toString()
                , highCard.toString()));
    }

    @Test
    public void itShouldPrintCorrectWinnerTextWithRanking() {
        IPrinter printer = mock(Printer.class);
        GamePrinter gamePrinter = new GamePrinter(printer);
        PokerPlayer player1 = new PokerPlayer("Lee");
        Card highCard = new Card("4S");
        player1.addCard(new Card("2H"));
        player1.addCard(new Card("4C"));
        player1.addCard(new Card("2D"));
        player1.addCard(new Card("4H"));
        player1.addCard(highCard);

        WinnerPokerPlayer winnerPokerPlayer = new WinnerPokerPlayer(player1, highCard);
        gamePrinter.PrintWinnerScore(winnerPokerPlayer);
        verify(printer).print(String.format("%s wins. - with %s",
                player1.getName(),
                player1.getRank().getRankType().toString()));
    }
}
