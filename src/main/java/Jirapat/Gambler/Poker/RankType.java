package Jirapat.Gambler.Poker;

/**
 Represents POKER HAND RANKING based on http://www.pokerlistings.com/poker-rules
 */
public enum RankType {
    RoyalStraightFlush(10),
    StraightFlush(9),
    FourOfAKind(8),
    FullHouse(7),
    Flush(6),
    Straight(5),
    Triple(4),
    TwoPairs(3),
    Pair(2),
    HighCard(1);

    private final int value;

    RankType(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    @Override
    public String toString() {
        if (this == RankType.RoyalStraightFlush) {
            return "royal straight flush";
        } else if (this == RankType.StraightFlush) {
            return "straight flush";
        } else if (this == RankType.FourOfAKind) {
            return "four of a kind";
        } else if (this == RankType.FullHouse) {
            return "full house";
        } else if (this == RankType.Flush) {
            return "flush";
        } else if (this == RankType.Straight) {
            return "straight";
        } else if (this == RankType.Triple) {
            return "triple";
        } else if (this == RankType.TwoPairs) {
            return "two pairs";
        } else if (this == RankType.Pair) {
            return "one pair";
        } else {
            //this == RankType.HighCard
            return "high card";
        }
    }
}
