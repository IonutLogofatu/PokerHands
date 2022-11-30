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
            case 4 -> Messages.messageForThreeOfAKind(player);
            case 5 -> Messages.messageForStraight(player);
            case 6 -> Messages.messageForFlush(player);
            case 7 -> Messages.messageForFullHouse(player);
            case 8 -> Messages.messageForFourOfAKind(player);
            case 9 -> Messages.messageForStraightFlush(player);
        }
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

   public boolean isThreeOfAKind(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        return (card1 == card3 || card2 == card4 || card3 == card5);
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

    public boolean isFullHouse(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        return ((card1 == card2 && card2 != card3 && card3 == card5) ||
                (card1 == card3 && card3 != card4 && card4 == card5));
    }

    public boolean isFourOfAKind(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();
        return (card1 == card4 ||
                card2 == card5);
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
        }
        Messages.messageForTie();
        return 0;
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
        }
        Messages.messageForTie();
        return 0;
    }
}
