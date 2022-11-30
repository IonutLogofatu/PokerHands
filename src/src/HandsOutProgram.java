import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HandsOutProgram {
    public static void writeInFile(int numberOfTimes){
        Random random = new Random();
        try {
            FileWriter myWriter = new FileWriter("/Users/ionutlogofatu/Documents/GitHub/PokerHands/src/src/poker.txt");
            for(int i =0; i < numberOfTimes; i++){
                List<String> cards = new ArrayList<>();
                int numberOfCards = 10;
                for(int j =0; j < numberOfCards; j++){
                    String card = getCard(random.nextInt(13)+2,random.nextInt(4)+1);
                    if(!cards.contains(card)){
                        cards.add(card);
                    }else{
                        numberOfCards++;
                    }
                }
                for(String card: cards){
                    myWriter.write(card + " ");
                }
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static String getCard(int rank, int suit){
        StringBuilder card = new StringBuilder();
        card.append(getRank(rank));
        card.append(getSuit(suit));
        return card.toString();
    }

    public static String getSuit(int suit){
        switch (suit){
            case 1:
                return "D";
            case 2:
                return "C";
            case 3:
                return "H";
            case 4:
                return "S";
        }
        return null;
    }

    public static String getRank(int rank){
        if(rank < 10){
            return String.valueOf(rank);
        }else if(rank == 10){
            return "T";
        }else if(rank == 11){
            return "J";
        }else if(rank == 12){
            return "Q";
        }else if(rank == 13){
            return "K";
        }else if(rank == 14){
            return "A";
        }
        return null;
    }
}
