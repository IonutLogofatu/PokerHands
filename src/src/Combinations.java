import java.util.List;
public class Combinations {

    public boolean isPair(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        return ((card1 == card2 && card2 != card3) ||
                (card2 == card3 && card3 != card4 && card2 != card1) ||
                (card3 == card4 && card4 != card5 && card3 != card2) ||
                (card4 == card5 && card4 != card3));
    }

    public boolean isTwoPair(List<Card> cards){
        int card1 = cards.get(0).getRank().getRankIndex();
        int card2 = cards.get(1).getRank().getRankIndex();
        int card3 = cards.get(2).getRank().getRankIndex();
        int card4 = cards.get(3).getRank().getRankIndex();
        int card5 = cards.get(4).getRank().getRankIndex();

        return ((card1 == card2 && card3 == card4 && card2!=card3 && card4 != card5) ||
                (card1 != card2 && card2 == card3 && card3 != card4 && card4 == card5)
        );
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
}
