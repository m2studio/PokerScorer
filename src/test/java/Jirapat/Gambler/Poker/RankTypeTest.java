package Jirapat.Gambler.Poker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public class RankTypeTest {
    @Test
    public void itShouldReturnCorrectStringFromToStringMethod() {
        Assert.isTrue(RankType.RoyalStraightFlush.toString().equals("royal straight flush"));
        Assert.isTrue(RankType.StraightFlush.toString().equals("straight flush"));
        Assert.isTrue(RankType.FourOfAKind.toString().equals("four of a kind"));
        Assert.isTrue(RankType.FullHouse.toString().equals("full house"));
        Assert.isTrue(RankType.Flush.toString().equals("flush"));
        Assert.isTrue(RankType.Straight.toString().equals("straight"));
        Assert.isTrue(RankType.Triple.toString().equals("triple"));
        Assert.isTrue(RankType.TwoPairs.toString().equals("two pairs"));
        Assert.isTrue(RankType.Pair.toString().equals("one pair"));
        Assert.isTrue(RankType.HighCard.toString().equals("high card"));
    }

    @Test
    public void itShouldReturnCorrectValue() {
        Assert.isTrue(RankType.RoyalStraightFlush.getValue() == 10);
        Assert.isTrue(RankType.StraightFlush.getValue() == 9);
        Assert.isTrue(RankType.FourOfAKind.getValue() == 8);
        Assert.isTrue(RankType.FullHouse.getValue() == 7);
        Assert.isTrue(RankType.Flush.getValue() == 6);
        Assert.isTrue(RankType.Straight.getValue() == 5);
        Assert.isTrue(RankType.Triple.getValue() == 4);
        Assert.isTrue(RankType.TwoPairs.getValue() == 3);
        Assert.isTrue(RankType.Pair.getValue() == 2);
        Assert.isTrue(RankType.HighCard.getValue() == 1);
    }
}
