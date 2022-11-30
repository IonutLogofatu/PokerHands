import java.util.Collection;
import java.util.Collections;

public class Game {
    Players players = new Players();
    public void startGame(Players players){
        this.players = players;
        Collections.sort(players.getFirstPlayer(),new CustomComparator());
        Collections.sort(players.getSecondPlayer(),new CustomComparator());
    }
}
