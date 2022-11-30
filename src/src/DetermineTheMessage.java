public class DetermineTheMessage {

    public static void determineWhatMessageToDisplay(int player, int handRank){
        switch (handRank){
            case 1 -> Messages.messageForHighCard(player);
            case 2 -> Messages.messageForOnePair(player);
            case 3 -> Messages.messageForTwoPairs(player);
            case 4 -> Messages.messageForThreeOfAKind(player);
            case 5 -> Messages.messageForStraight(player);
            case 6 -> Messages.messageForFlush(player);
            case 7 -> Messages.messageForFullHouse(player);
            case 8 -> Messages.messageForFourOfAKind(player);
            case 9 -> Messages.messageForStraightFlush(player);
        }
    }
}
