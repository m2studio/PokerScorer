package Jirapat.Gambler.Poker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Hashtable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PokerPlayerTest {

    @Test
    public void pokerPlayerConstructorInitiailizeCorrectly() {
        String name = "OAD";
        PokerPlayer player = new PokerPlayer(name);
        Assert.isTrue(player.getName().equals(name));
        Assert.isTrue(player.getCards().size() == 0);
    }

    @Test
    public void addCardMethodShouldWorkCorrectly() {
        PokerPlayer player = new PokerPlayer("name");
        Card card = new Card("AS");
        player.addCard(card);
        Assert.isTrue(player.getCards().size() == 1);
        Assert.isTrue(player.getCards().get(0) == card);
    }
}
