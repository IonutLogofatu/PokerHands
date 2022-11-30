public class Messages {

    public static void messageForHighCard(int player){
        System.out.println("Player " + player + " won with high card");
    }

    public static void messageForOnePair(int player){
        System.out.println("Player " + player + " won with one pair");
    }

    public static void messageForTwoPairs(int player){
        System.out.println("Player " + player + " won with two pairs");
    }

    public static void messageForThreeOfAKind(int player){
        System.out.println("Player " + player + " won with three of a kind");
    }

    public static void messageForStraight(int player){
        System.out.println("Player " + player + " won with straight");
    }

    public static void messageForFlush(int player){
        System.out.println("Player " + player + " won with flush");
    }

    public static void messageForFullHouse(int player){
        System.out.println("Player " + player + " won with full house");
    }

    public static void messageForFourOfAKind(int player){
        System.out.println("Player " + player + " won with four of a kind");
    }

    public static void messageForStraightFlush(int player){
        System.out.println("Player " + player + " won with straight flush");
    }

    public static void messageForTie(){
        System.out.println("Tie");
    }
}
