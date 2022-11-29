import java.util.ArrayList;

public class Players {
    private ArrayList<Card> firstPlayer;
    private ArrayList<Card> secondPlayer;

    public ArrayList<Card> getFirstPlayer() {
        return firstPlayer;
    }

    public ArrayList<Card> getSecondPlayer() {
        return secondPlayer;
    }

    Players(){
        firstPlayer = new ArrayList<>();
        secondPlayer = new ArrayList<>();
    }

    public void addCardsToPlayers(String[] cards){
        int numberOfCards = 0;
        for(String card : cards){
            if(numberOfCards < 5){
                putCardsOnArray(card, firstPlayer);
            }else{
                putCardsOnArray(card, secondPlayer);
            }
            numberOfCards++;
        }
    }

    private void putCardsOnArray(String card, ArrayList<Card> player){
        player.add(getCardFromString(card));
    }

    private Card getCardFromString(String card){
        String rank = card.substring(0,0);
        String suit = card.substring(1,1);
        return new Card(getRankFromCard(rank),getSuitFromCard(suit));
    }

    private Suit getSuitFromCard(String suit){
        Suit suitToReturn = null;
        switch (suit){
            case "D":
                suitToReturn = Suit.DIAMONDS;
                break;
            case "C":
                suitToReturn = Suit.CLUBS;
                break;
            case "H":
                suitToReturn = Suit.HEARTS;
                break;
            case "S":
                suitToReturn = Suit.SPADES;
                break;
        }
        return suitToReturn;
    }

    private Rank getRankFromCard(String rank){
        Rank rankToReturn = null;
        switch (rank){
            case "2":
                rankToReturn =  Rank.TWO;
                break;
            case "3":
                rankToReturn =  Rank.THREE;
                break;
            case "4":
                rankToReturn = Rank.FOUR;
                break;
            case "5":
                rankToReturn =  Rank.FIVE;
                break;
            case "6":
                rankToReturn =  Rank.SIX;
                break;
            case "7":
                rankToReturn =  Rank.SEVEN;
                break;
            case "8":
                rankToReturn =  Rank.EIGHT;
                break;
            case "9":
                rankToReturn =  Rank.NINE;
                break;
            case "10":
                rankToReturn =  Rank.TEN;
                break;
            case "J":
                rankToReturn =  Rank.JACK;
                break;
            case "Q":
                rankToReturn =  Rank.QUEEN;
                break;
            case "K":
                rankToReturn =  Rank.KING;
                break;
            case "A":
                rankToReturn =  Rank.ACE;
                break;
        }
        return rankToReturn;
    }


}
