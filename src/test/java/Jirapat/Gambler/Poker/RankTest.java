package Jirapat.Gambler.Poker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Created by Windows 10 Pro on 1/10/2559.
 */
public class RankTest {

    @Test
    public void itShouldReturnRoyalStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("10S"));
        cards.add(new Card("JS"));
        cards.add(new Card("QS"));
        cards.add(new Card("KS"));
        cards.add(new Card("AS"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.RoyalStraightFlush);
    }

    @Test
    public void itShouldReturnStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("5S"));
        cards.add(new Card("4S"));
        cards.add(new Card("6S"));
        cards.add(new Card("3S"));
        cards.add(new Card("7S"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.StraightFlush);
    }

    @Test
    public void itShouldReturnFourOfAKind() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3S"));
        cards.add(new Card("3H"));
        cards.add(new Card("3D"));
        cards.add(new Card("3C"));
        cards.add(new Card("AS"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.FourOfAKind);
    }

    @Test
    public void itShouldReturnFullHouse() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3S"));
        cards.add(new Card("3H"));
        cards.add(new Card("3D"));
        cards.add(new Card("5C"));
        cards.add(new Card("5S"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.FullHouse);
    }

    @Test
    public void itShouldReturnFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AD"));
        cards.add(new Card("5D"));
        cards.add(new Card("6D"));
        cards.add(new Card("JD"));
        cards.add(new Card("QD"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.Flush);
    }

    @Test
    public void itShouldReturnStraight() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S"));
        cards.add(new Card("8D"));
        cards.add(new Card("9C"));
        cards.add(new Card("10D"));
        cards.add(new Card("JH"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.Straight);
    }

    @Test
    public void itShouldReturnStraightIfAIsTheLowestValueInCardSet() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("2D"));
        cards.add(new Card("3D"));
        cards.add(new Card("4D"));
        cards.add(new Card("5D"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.Straight);
    }

    @Test
    public void itShouldReturnTripple() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S"));
        cards.add(new Card("7H"));
        cards.add(new Card("7D"));
        cards.add(new Card("3D"));
        cards.add(new Card("8H"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.Triple);
    }

    @Test
    public void itShouldReturnTwoPairs() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("4S"));
        cards.add(new Card("9H"));
        cards.add(new Card("4D"));
        cards.add(new Card("9D"));
        cards.add(new Card("AH"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.TwoPairs);
    }

    @Test
    public void itShouldReturnPair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2S"));
        cards.add(new Card("3H"));
        cards.add(new Card("4D"));
        cards.add(new Card("9D"));
        cards.add(new Card("9H"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.Pair);
    }

    @Test
    public void itShouldReturnHighCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("5S"));
        cards.add(new Card("3H"));
        cards.add(new Card("7D"));
        cards.add(new Card("9D"));
        cards.add(new Card("JH"));

        Rank rank = new Rank(cards);
        Assert.isTrue(rank.getRankType() == RankType.HighCard);
    }

    @Test
    public void compareRoyalStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("10S"));
        cards.add(new Card("JS"));
        cards.add(new Card("QS"));
        cards.add(new Card("KS"));
        cards.add(new Card("AS"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("10H"));
        cards2.add(new Card("JH"));
        cards2.add(new Card("QH"));
        cards2.add(new Card("KH"));
        cards2.add(new Card("AH"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7H"));
        cards.add(new Card("8H"));
        cards.add(new Card("9H"));
        cards.add(new Card("10H"));
        cards.add(new Card("JH"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("2S"));
        cards2.add(new Card("3S"));
        cards2.add(new Card("4S"));
        cards2.add(new Card("5S"));
        cards2.add(new Card("6S"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareFourOfAKind() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("AH"));
        cards.add(new Card("AD"));
        cards.add(new Card("AC"));
        cards.add(new Card("2H"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("KS"));
        cards2.add(new Card("KH"));
        cards2.add(new Card("KD"));
        cards2.add(new Card("KC"));
        cards2.add(new Card("3S"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareFullHouse() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("10S"));
        cards.add(new Card("10H"));
        cards.add(new Card("10D"));
        cards.add(new Card("AC"));
        cards.add(new Card("AH"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("8S"));
        cards2.add(new Card("8H"));
        cards2.add(new Card("8D"));
        cards2.add(new Card("AC"));
        cards2.add(new Card("AS"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AH"));
        cards.add(new Card("2H"));
        cards.add(new Card("5H"));
        cards.add(new Card("7H"));
        cards.add(new Card("9H"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("KS"));
        cards2.add(new Card("3S"));
        cards2.add(new Card("4S"));
        cards2.add(new Card("JS"));
        cards2.add(new Card("QS"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareStraight() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("5H"));
        cards.add(new Card("6H"));
        cards.add(new Card("7S"));
        cards.add(new Card("8S"));
        cards.add(new Card("9S"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("3S"));
        cards2.add(new Card("4S"));
        cards2.add(new Card("5H"));
        cards2.add(new Card("6C"));
        cards2.add(new Card("7C"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareStraightIfAIsTheLowestValue() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2H"));
        cards.add(new Card("3H"));
        cards.add(new Card("4S"));
        cards.add(new Card("5S"));
        cards.add(new Card("6S"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("AS"));
        cards2.add(new Card("2S"));
        cards2.add(new Card("3H"));
        cards2.add(new Card("4H"));
        cards2.add(new Card("5H"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareTripple() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S"));
        cards.add(new Card("7H"));
        cards.add(new Card("7C"));
        cards.add(new Card("2D"));
        cards.add(new Card("3D"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("3S"));
        cards2.add(new Card("3H"));
        cards2.add(new Card("3C"));
        cards2.add(new Card("AD"));
        cards2.add(new Card("KD"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareTwoPair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("AH"));
        cards.add(new Card("2C"));
        cards.add(new Card("2D"));
        cards.add(new Card("3D"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("KS"));
        cards2.add(new Card("KH"));
        cards2.add(new Card("QC"));
        cards2.add(new Card("QD"));
        cards2.add(new Card("JD"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareTwoPairIfHasSameOnePair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("JS"));
        cards.add(new Card("JH"));
        cards.add(new Card("7C"));
        cards.add(new Card("7D"));
        cards.add(new Card("3D"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("JD"));
        cards2.add(new Card("JC"));
        cards2.add(new Card("5C"));
        cards2.add(new Card("5D"));
        cards2.add(new Card("KD"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareTwoPairIfHasSameTwoPairs() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("KS"));
        cards.add(new Card("KH"));
        cards.add(new Card("9S"));
        cards.add(new Card("9H"));
        cards.add(new Card("JD"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("KC"));
        cards2.add(new Card("KD"));
        cards2.add(new Card("9C"));
        cards2.add(new Card("9D"));
        cards2.add(new Card("10S"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareOnePair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("AH"));
        cards.add(new Card("7C"));
        cards.add(new Card("8D"));
        cards.add(new Card("9D"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("5S"));
        cards2.add(new Card("5H"));
        cards2.add(new Card("JC"));
        cards2.add(new Card("QD"));
        cards2.add(new Card("KD"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareOnePairIfHasSamePair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("JS"));
        cards.add(new Card("JH"));
        cards.add(new Card("AD"));
        cards.add(new Card("2D"));
        cards.add(new Card("3D"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("JD"));
        cards2.add(new Card("JC"));
        cards2.add(new Card("KS"));
        cards2.add(new Card("QS"));
        cards2.add(new Card("5S"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareHighCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2S"));
        cards.add(new Card("3H"));
        cards.add(new Card("4C"));
        cards.add(new Card("5D"));
        cards.add(new Card("KD"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("2H"));
        cards2.add(new Card("3C"));
        cards2.add(new Card("4D"));
        cards2.add(new Card("5S"));
        cards2.add(new Card("QS"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareHighCardIfTheFirstHighestValueIsTheSame() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("6S"));
        cards.add(new Card("7H"));
        cards.add(new Card("8C"));
        cards.add(new Card("9D"));
        cards.add(new Card("KD"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("2H"));
        cards2.add(new Card("3C"));
        cards2.add(new Card("4D"));
        cards2.add(new Card("5S"));
        cards2.add(new Card("KS"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void compareHighCardInCaseOfTie() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("4S"));
        cards.add(new Card("5H"));
        cards.add(new Card("6C"));
        cards.add(new Card("10D"));
        cards.add(new Card("QD"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("7H"));
        cards2.add(new Card("8C"));
        cards2.add(new Card("9D"));
        cards2.add(new Card("10S"));
        cards2.add(new Card("QS"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue == 0);
    }

    @Test
    public void compareHighCardInCaseHasSameValueInSet() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2D"));
        cards.add(new Card("3H"));
        cards.add(new Card("5C"));
        cards.add(new Card("9S"));
        cards.add(new Card("KH"));
        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("2H"));
        cards2.add(new Card("3D"));
        cards2.add(new Card("5S"));
        cards2.add(new Card("9C"));
        cards2.add(new Card("KD"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue == 0);
    }

    @Test
    public void RoyalStraightFlushShouldBeHigherRankThanStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("10S"));
        cards.add(new Card("JS"));
        cards.add(new Card("QS"));
        cards.add(new Card("KS"));
        cards.add(new Card("AS"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("5S"));
        cards2.add(new Card("4S"));
        cards2.add(new Card("6S"));
        cards2.add(new Card("3S"));
        cards2.add(new Card("7S"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void StraightFlushShouldBeHigherRankThanFourOfAKind() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("5S"));
        cards.add(new Card("4S"));
        cards.add(new Card("6S"));
        cards.add(new Card("3S"));
        cards.add(new Card("7S"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("3S"));
        cards2.add(new Card("3H"));
        cards2.add(new Card("3D"));
        cards2.add(new Card("3C"));
        cards2.add(new Card("AS"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void FourOfAKindShouldBeHigherRankThanFullHouse() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3S"));
        cards.add(new Card("3H"));
        cards.add(new Card("3D"));
        cards.add(new Card("3C"));
        cards.add(new Card("AS"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("KS"));
        cards2.add(new Card("KH"));
        cards2.add(new Card("KD"));
        cards2.add(new Card("5C"));
        cards2.add(new Card("5S"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void FullHouseShouldBeHigherRankThanFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("KS"));
        cards.add(new Card("KH"));
        cards.add(new Card("KD"));
        cards.add(new Card("5C"));
        cards.add(new Card("5S"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("AD"));
        cards2.add(new Card("5D"));
        cards2.add(new Card("6D"));
        cards2.add(new Card("JD"));
        cards2.add(new Card("QD"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void FlushShouldBeHigherRankThanTripple() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AD"));
        cards.add(new Card("5D"));
        cards.add(new Card("6D"));
        cards.add(new Card("JD"));
        cards.add(new Card("QD"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("7S"));
        cards2.add(new Card("7H"));
        cards2.add(new Card("7D"));
        cards2.add(new Card("3D"));
        cards2.add(new Card("8H"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void TrippleShouldBeHigherRankThanTwoPairs() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S"));
        cards.add(new Card("7H"));
        cards.add(new Card("7D"));
        cards.add(new Card("3D"));
        cards.add(new Card("8H"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("4S"));
        cards2.add(new Card("9H"));
        cards2.add(new Card("4D"));
        cards2.add(new Card("9D"));
        cards2.add(new Card("AH"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void TwoPairsShouldBeHigherRankThanOnePair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("4S"));
        cards.add(new Card("9H"));
        cards.add(new Card("4D"));
        cards.add(new Card("9D"));
        cards.add(new Card("AH"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("AS"));
        cards2.add(new Card("AH"));
        cards2.add(new Card("5D"));
        cards2.add(new Card("7D"));
        cards2.add(new Card("9H"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }

    @Test
    public void OnePairShouldBeHigherRankThanHighCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3S"));
        cards.add(new Card("3H"));
        cards.add(new Card("4D"));
        cards.add(new Card("6D"));
        cards.add(new Card("8H"));

        Rank rank1 = new Rank(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card("2S"));
        cards2.add(new Card("5H"));
        cards2.add(new Card("7D"));
        cards2.add(new Card("9D"));
        cards2.add(new Card("AH"));
        Rank rank2 = new Rank(cards2);

        Integer compareValue = rank1.compareTo(rank2);
        Assert.isTrue(compareValue < 0);
    }
}
