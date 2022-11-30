import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        handsOut();
    }


    public static void handsOut(){
            HandsOutProgram.writeInFile(10);
            readCardsFromFileAndStartTheGame();
    }

    public static void readCardsFromFileAndStartTheGame(){
        try{
            int[] counterOfWins = new int[3];
            File fileFromRead = new File("poker.txt");
            Scanner scanner = new Scanner(fileFromRead);
            while (scanner.hasNextLine()) {
                Players players = new Players();
                Game game  = new Game();
                String[] cards = scanner.nextLine().split(" ");
                players.addCardsToPlayers(cards);
                int whoWon = game.startGame(players);
                counterOfWins[whoWon]++;
            }
            System.out.println("\n\nPlayer 1 won " + counterOfWins[1] + " times");
            System.out.println(counterOfWins[0] + " times was tie");
            System.out.println("Player 2 won " + counterOfWins[2] + " times");
            scanner.close();
        }catch (FileNotFoundException exception){
            System.out.println("An error occured");
            exception.printStackTrace();
        }
    }
}