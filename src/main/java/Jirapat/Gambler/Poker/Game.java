package Jirapat.Gambler.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 This class is represent Poker game with multiple players
 */
public class Game {

    private List<PokerPlayer> players;

    public Game(PokerPlayer player1, PokerPlayer player2) {
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Players arguments could not be null");
        }

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
    }

    public List<PokerPlayer> getPlayers() { return this.players;}

    public WinnerPokerPlayer findWinner() {
        Collections.sort(players);
        WinnerPokerPlayer winner = null;
        for(Integer i=0; i<players.size()-1; i++) {
            Integer compare = players.get(i).compareTo(players.get(i+1));
            if (compare < 0) {
                PokerPlayer tempWinner = players.get(i);
                PokerPlayer loser = players.get(i+1);
                Card winningCard = findWinningCard(tempWinner, loser);
                winner = new WinnerPokerPlayer(tempWinner, winningCard);
                break;
            }
        }

        return winner;
    }

    private Card findWinningCard(PokerPlayer winner, PokerPlayer loser) {
        Card winningCard = null;
        RankType winnerRank = winner.getRank().getRankType();
        RankType loserRank = winner.getRank().getRankType();
        if (winnerRank == loserRank) {
            if (winnerRank == RankType.HighCard) {
                List<Card> winnerCards = winner.getCards();
                List<Card> loserCards = loser.getCards();
                for(Integer i=0; i<winnerCards.size(); i++) {
                    if (winnerCards.get(i).getValue() > loserCards.get(i).getValue()) {
                        winningCard =  winnerCards.get(i);
                        break;
                    }
                }
            }
        }
        return winningCard;
    }

}
