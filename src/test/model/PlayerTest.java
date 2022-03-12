package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void testPlayers(){
        Player player1 = new Player("p1", "X");
        Player player2 = new Player("p2", "O");
        assertEquals("p1",player1.getPlayerName());
        assertEquals("p2",player2.getPlayerName());
        assertEquals("X",player1.getPlayerSymbol());
        assertEquals("O",player2.getPlayerSymbol());
    }
}
