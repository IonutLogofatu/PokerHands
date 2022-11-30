public class DetermineTheMessage {

    public static void determineWhatMessageToDisplay(int player, int handRank){
        switch (handRank){
            case 1:
                Messages.messageForHighCard(player);
                break;
            case 2:
                Messages.messageForOnePair(player);
                break;
            case 3:
                Messages.messageForTwoPairs(player);
                break;
            case 4:
                Messages.messageForThreeOfAKind(player);
                break;
            case 5:
                Messages.messageForStraight(player);
                break;
            case 6:
                Messages.messageForFlush(player);
                break;
            case 7:
                Messages.messageForFullHouse(player);
                break;
            case 8:
                Messages.messageForFourOfAKind(player);
                break;
            case 9:
                Messages.messageForStraightFlush(player);
                break;
        }
    }
}
