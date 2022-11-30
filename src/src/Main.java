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
                Players players = new Players();
                Game game  = new Game();
                String[] cards = scanner.nextLine().split(" ");
                players.addCardsToPlayers(cards);
                game.startGame(players);
            }
            scanner.close();
        }catch (FileNotFoundException exception){
            System.out.println("An error occured");
            exception.printStackTrace();
        }
    }
}