import org.junit.Assert;
import org.junit.Test;


public class Tests {
    @Test
    public void secondPlayerWins(){
        String[] cards = new String[]{"9C","TD","7H","8H","5H","9S","9D","8S","JH","9H"};
        Players players = new Players();
        Game game  = new Game();
        players.addCardsToPlayers(cards);
        Assert.assertEquals(2,game.startGame(players));
    }

    @Test
    public void firstPlayerWins(){
        String[] cards = new String[]{"9C","9D","7H","8H","5H","7S","6D","8S","JH","9H"};
        Players players = new Players();
        Game game  = new Game();
        players.addCardsToPlayers(cards);
        Assert.assertEquals(1,game.startGame(players));
    }

    @Test
    public void tie(){
        String[] cards = new String[]{"9C","9D","8H","8S","5H","9S","8D","8C","5D","9H"};
        Players players = new Players();
        Game game  = new Game();
        players.addCardsToPlayers(cards);
        Assert.assertEquals(0,game.startGame(players));
    }
}
