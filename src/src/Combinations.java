import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Combinations {

    public int determineTheWinner(Players players, int handRank){
        switch (handRank){
            case 1:
                return compareHighCard(players);
            case 2:
                return comparePair(players);
            case 3:
                return compareTwoPairs(players);
            case 4:
                return compareThreeOfAKind(players);
            case 5:
            case 9:
                return compareStraight(players);
            case 6:
                Messages.messageForTie();
                return 0;
            case 7:
                return compareFullHouse(players);
            case 8:
                return compareFourOfAKind(players);
        }
        return 0;
    }

    private int getThePair(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        if(card1 == card2){
            return card1;
        }else if(card2 == card3){
            return card2;
        }else if(card3 == card4){
            return card3;
        }else if(card4 == card5){
            return card5;
        }
        return 0;
    }

    public boolean isPair(List<Card> cards){
        return getThePair(cards) != 0;
    }

    private List<Integer> getTwoPair(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();
        if(card1 == card2 && card3 == card4 && card2!=card3 && card4 != card5){
            List<Integer> list = Arrays.asList(card1,card3);
            return  Arrays.asList(card1,card3);
        }else if(card1 != card2 && card2 == card3 && card3 != card4 && card4 == card5){
            return Arrays.asList(card2,card4);
        }
        return Arrays.asList(0,0);
    }

    public boolean isTwoPair(List<Card> cards){
        return getTwoPair(cards).get(0) != 0;
    }


    public int getThreeOfAKind(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        if(card1 == card3){
            return card1;
        }else if(card2 == card4){
            return card2;
        }else if(card3 == card5){
            return card3;
        }
        return 0;
    }
   public boolean isThreeOfAKind(List<Card> cards){
       return getThreeOfAKind(cards) != 0;
    }

    public boolean isStraight(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card3 = cards.get(3).getRank().getRankIndex();
        int card4 = cards.get(4).getRank().getRankIndex();
        if(card4 - card1 == 4){
            return true;
        }else if((card3 - card1 == 3) && (card1 == 2 && card4 == 14)){
            return true;
        }
        return false;
    }

    public boolean isFlush(List<Card> cards){
        for (int i=0;i<cards.size()-1;i++){
            if (cards.get(i+1).getSuit() != cards.get(i).getSuit()) return false;
        }
        return true;
    }

    private List<Integer> getFullHouse(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        if(card1 == card2 && card2 != card3 && card3 == card5){
            return Arrays.asList(card3,card1);
        }else if(card1 == card3 && card3 != card4 && card4 == card5){
            return Arrays.asList(card1, card4);
        }
        return Arrays.asList(0,0);
    }

    public boolean isFullHouse(List<Card> cards){
        return getFullHouse(cards).get(0) != 0;
    }

    public int getFourOfAKind(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        if(card1 == card4){
            return card1;
        }else if(card2 == card5){
            return card2;
        }
        return 0;
    }

    public boolean isFourOfAKind(List<Card> cards){
        return getFourOfAKind(cards) != 0;
    }

    public boolean isStraightFlush(List<Card> cards){

        return isStraight(cards) && isFlush(cards);
    }

    private int compareHighCard(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        for(int i = firstPlayer.size()-1; i >= 0; i--){
            int firstPlayerCard = firstPlayer.get(i).getRank().getRankIndex();
            int secondPlayerCard = secondPlayer.get(i).getRank().getRankIndex();
            if(firstPlayerCard > secondPlayerCard){
                Messages.messageForHighCard(1);
                return 1;
            }else if(secondPlayerCard > firstPlayerCard){
                Messages.messageForHighCard(2);
                return 2;
            }
        }
        Messages.messageForTie();
        return 0;

    }

    public int comparePair(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        int firstPlayerPair = getThePair(firstPlayer);
        int secondPlayerPair = getThePair(secondPlayer);
        if(firstPlayerPair > secondPlayerPair){
            Messages.messageForOnePair(1);
            return 1;
        }else if(secondPlayerPair > firstPlayerPair){
            Messages.messageForOnePair(2);
            return 2;
        }else {
            return compareHighCard(players);
        }
    }

    public int compareTwoPairs(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        List<Integer> firstPlayerPair =  getTwoPair(firstPlayer);
        List<Integer> secondPlayerPair = getTwoPair(secondPlayer);
        if(firstPlayerPair.get(1) > secondPlayerPair.get(1)){
            Messages.messageForTwoPairs(1);
            return 1;
        }else if(secondPlayerPair.get(1) > firstPlayerPair.get(1)){
            Messages.messageForTwoPairs(2);
            return 2;
        }else if(firstPlayerPair.get(0) > secondPlayerPair.get(0)){
            Messages.messageForTwoPairs(1);
            return 1;
        }else if(secondPlayerPair.get(0) > firstPlayerPair.get(0)){
            Messages.messageForTwoPairs(2);
            return 2;
        }else {
            return compareHighCard(players);
        }
    }

    private int compareThreeOfAKind(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        int firstPlayerThreeOfAKind = getThreeOfAKind(firstPlayer);
        int secondPlayerThreeOfAKind = getThreeOfAKind(secondPlayer);
        if(firstPlayerThreeOfAKind > secondPlayerThreeOfAKind){
            Messages.messageForOnePair(1);
            return 1;
        }else if(secondPlayerThreeOfAKind > firstPlayerThreeOfAKind){
            Messages.messageForOnePair(2);
            return 2;
        }else {
            return compareHighCard(players);
        }
    }

    private int compareStraight(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        int firstCardFirstPlayer = firstPlayer.get(0).getRank().getRankIndex();
        int firstCardSecondPlayer = secondPlayer.get(0).getRank().getRankIndex();

        if( firstCardFirstPlayer > firstCardSecondPlayer){
            Messages.messageForStraight(1);
            return 1;
        }else if(firstCardSecondPlayer > firstCardFirstPlayer){
            Messages.messageForStraight(2);
            return 2;
        }
        Messages.messageForTie();
        return 0;
    }

    private int compareFullHouse(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        List<Integer> firstPlayerFullHouse =  getFullHouse(firstPlayer);
        List<Integer> secondPlayerFullHouse = getFullHouse(secondPlayer);
        if(firstPlayerFullHouse.get(0) > secondPlayerFullHouse.get(0)){
            Messages.messageForFullHouse(1);
            return 1;
        }else if(secondPlayerFullHouse.get(0) > firstPlayerFullHouse.get(0)){
            Messages.messageForFullHouse(2);
            return 2;
        }else if(firstPlayerFullHouse.get(1) > secondPlayerFullHouse.get(1)){
            Messages.messageForFullHouse(1);
            return 1;
        }else if(secondPlayerFullHouse.get(1) > firstPlayerFullHouse.get(1)){
            Messages.messageForFullHouse(2);
            return 2;
        }
        Messages.messageForTie();
        return 0;
    }

    private int compareFourOfAKind(Players players){
        List<Card> firstPlayer = players.getFirstPlayer();
        List<Card> secondPlayer = players.getSecondPlayer();
        int firstPlayerThreeOfAKind = getFourOfAKind(firstPlayer);
        int secondPlayerThreeOfAKind = getFourOfAKind(secondPlayer);
        if(firstPlayerThreeOfAKind > secondPlayerThreeOfAKind){
            Messages.messageForFourOfAKind(1);
            return 1;
        }else if(secondPlayerThreeOfAKind > firstPlayerThreeOfAKind){
            Messages.messageForFourOfAKind(2);
            return 2;
        }else {
            return compareHighCard(players);
        }
    }

}
