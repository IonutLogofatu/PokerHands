import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readCardsFromFile();
    }

    public static void readCardsFromFile(){
        try{
            File fileFromRead = new File("/Users/ionutlogofatu/Documents/GitHub/PokerHands/src/src/poker.txt");
            Scanner scanner = new Scanner(fileFromRead);
            while (scanner.hasNextLine()) {
                String[] cards = scanner.nextLine().split(" ");
                Players players = new Players();
                players.addCardsToPlayers(cards);
            }
            scanner.close();
        }catch (FileNotFoundException exception){
            System.out.println("An error occured");
            exception.printStackTrace();
        }
    }
}