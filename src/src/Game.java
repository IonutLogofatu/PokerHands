import java.util.Collections;
import java.util.List;

public class Game {
    Players players = new Players();
    public int startGame(Players players){
        this.players = players;
        Collections.sort(players.getFirstPlayer(),new CustomComparator());
        Collections.sort(players.getSecondPlayer(),new CustomComparator());
        Combinations combinations = new Combinations();
        return playPoker(players,combinations);
    }

    private int playPoker(Players players, Combinations combinations){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        int firstPlayerHandRank = getHandRank(combinations,firstPlayer).getHandRankIndex();
        int secondPlayerHandRank = getHandRank(combinations,secondPlayer).getHandRankIndex();
        if(firstPlayerHandRank > secondPlayerHandRank){
            DetermineTheMessage.determineWhatMessageToDisplay(1,firstPlayerHandRank);
            return 1;
        }else if(secondPlayerHandRank > firstPlayerHandRank){
            DetermineTheMessage.determineWhatMessageToDisplay(2,secondPlayerHandRank);
            return 2;
        }else{
            return combinations.determineTheWinner(players,firstPlayerHandRank);
        }
    }

    private HandRank getHandRank(Combinations combinations, List<Card> cards){
        if (combinations.isStraightFlush(cards)) return HandRank.STRAIGHTFLUSH;
        else if (combinations.isFourOfAKind(cards)) return HandRank.FOUROFAKIND;
        else if (combinations.isFullHouse(cards)) return HandRank.FULLHOUSE;
        else if (combinations.isFlush(cards)) return HandRank.FLUSH;
        else if (combinations.isStraight(cards)) return HandRank.STRAIGHT;
        else if (combinations.isThreeOfAKind(cards)) return HandRank.THREEOFAKIND;
        else if (combinations.isTwoPair(cards)) return HandRank.TWOPAIR;
        else if (combinations.isPair(cards)) return HandRank.PAIR;
        else return HandRank.HIGHCARD;
    }
}
