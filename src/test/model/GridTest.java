package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
public class GridTest {

    @Test
    void testEmptyGrid(){
        Grid grid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        Player player1 = new Player("p1", "X");
        Player player2 = new Player("p2", "O");

        assertEquals(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."), grid.getGrid());
        assertEquals(grid.gridState(player1, player2),".");

    }

    @Test
    void testGridState(){
        //TBA
        Player player1 = new Player("p1", "X");
        Player player2 = new Player("p2", "O");
        Grid tbaDiagonal1P1 = new Grid(Arrays.asList("f", "f", "X", "f", ".", "f", ".", "f", "f"));
        Grid tbaDiagonal2P1 = new Grid(Arrays.asList("X", "f", "f", "f", ".", "f", "f", "f", "."));
        Grid tbaDiagonal1P2 = new Grid(Arrays.asList("f", "f", "O", "f", ".", "f", ".", "f", "f"));
        Grid tbaDiagonal2P2 = new Grid(Arrays.asList("O", "f", "-", "f", ".", "f", "f", "f", "."));

        Grid tbaHorizontalP1 = new Grid(Arrays.asList("X", ".", ".", "f", "f", "f", "f", "f", "f"));
        Grid tbaHorizontalP2 = new Grid(Arrays.asList("X", ".", ".", "f", "f", "f", "f", "f", "f"));
        Grid tbaVerticalP1 = new Grid(Arrays.asList("X", "f", "f", ".", "f", "f", ".", "f", "f"));
        Grid tbaVerticalP2 = new Grid(Arrays.asList("O", "f", "f", ".", "f", "f", ".", "f", "f"));


        assertEquals(".", tbaDiagonal1P1.gridState(player1, player2));
        assertEquals(".", tbaDiagonal2P1.gridState(player1, player2));
        assertEquals(".", tbaDiagonal1P2.gridState(player1, player2));
        assertEquals(".", tbaDiagonal2P2.gridState(player1, player2));
        assertEquals(".", tbaHorizontalP1.gridState(player1, player2));
        assertEquals(".", tbaHorizontalP2.gridState(player1, player2));
        assertEquals(".", tbaVerticalP1.gridState(player1, player2));
        assertEquals(".", tbaVerticalP2.gridState(player1, player2));

        //Winner
        List <String> testGridDiagonal1P1 = Arrays.asList(".", ".", "X", ".", "X", ".", "X", ".", ".");
        List <String> testGridDiagonal1P2 = Arrays.asList(".", ".", "O", ".", "O", ".", "O", ".", ".");
        List <String> testGridDiagonal2P2 = Arrays.asList("O", ".", ".", ".", "O", ".", ".", ".", "O");
        List <String> testGridDiagonal2P1 = Arrays.asList("X", ".", ".", ".", "X", ".", ".", ".", "X");
        List <String> testGridHorizontalP1 = Arrays.asList("X", "X", "X", ".", ".", ".", ".", ".", ".");
        List <String> testGridHorizontalP2 = Arrays.asList("O", "O", "O", ".", ".", ".", ".", ".", ".");
        List <String> testGridVerticalP1 = Arrays.asList("X", ".", ".", "X", ".", ".", "X", ".", ".");
        List <String> testGridVerticalP2 = Arrays.asList("O", ".", ".", "O", ".", ".", "O", ".", ".");

        Grid gridDiagonal1P1 = new Grid(Arrays.asList(".", ".", "X", ".", "X", ".", "X", ".", "."));
        assertEquals(gridDiagonal1P1.getGrid(),testGridDiagonal1P1);

        Grid gridDiagonal1P2 = new Grid(Arrays.asList(".", ".", "O", ".", "O", ".", "O", ".", "."));
        assertEquals(gridDiagonal1P2.getGrid(),testGridDiagonal1P2);

        Grid gridDiagonal2P1 = new Grid(Arrays.asList("X", ".", ".", ".", "X", ".", ".", ".", "X"));
        assertEquals(gridDiagonal2P1.getGrid(),testGridDiagonal2P1);

        Grid gridDiagonal2P2 = new Grid(Arrays.asList("O", ".", ".", ".", "O", ".", ".", ".", "O"));
        assertEquals(gridDiagonal2P2.getGrid(),testGridDiagonal2P2);

        Grid gridHorizontalP1 = new Grid(Arrays.asList("X", "X", "X", ".", ".", ".", ".", ".", "."));
        assertEquals(gridHorizontalP1.getGrid(),testGridHorizontalP1);

        Grid gridHorizontalP2 = new Grid(Arrays.asList("O", "O", "O", ".", ".", ".", ".", ".", "."));
        assertEquals(gridHorizontalP2.getGrid(),testGridHorizontalP2);

        Grid gridVerticalP1 = new Grid(Arrays.asList("X", ".", ".", "X", ".", ".", "X", ".", "."));
        assertEquals(gridVerticalP1.getGrid(),testGridVerticalP1);

        Grid gridVerticalP2 = new Grid(Arrays.asList("O", ".", ".", "O", ".", ".", "O", ".", "."));
        assertEquals(gridVerticalP2.getGrid(),testGridVerticalP2);

        assertEquals(gridDiagonal1P1.gridState(player1, player2),"X");
        assertEquals(gridDiagonal1P2.gridState(player1, player2),"O");
        assertEquals(gridDiagonal2P1.gridState(player1, player2),"X");
        assertEquals(gridDiagonal2P2.gridState(player1, player2),"O");
        assertEquals(gridVerticalP1.gridState(player1, player2),"X");
        assertEquals(gridVerticalP2.gridState(player1, player2),"O");
        assertEquals(gridHorizontalP1.gridState(player1, player2),"X");
        assertEquals(gridHorizontalP2.gridState(player1, player2),"O");

        //Tie
        Grid tieGrid1 = new Grid(Arrays.asList("X", "X", "O", "O", "O", "X", "X", "O", "."));
        assertEquals(tieGrid1.gridState(player1, player2),"draw");

    }

    @Test
    void testAddMove(){
        Grid grid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        Grid gridA1 = new Grid(Arrays.asList("X", ".", ".", ".", ".", ".", ".", ".", "."));
        Grid gridA2 = new Grid(Arrays.asList("X", "X", ".", ".", ".", ".", ".", ".", "."));
        Grid gridA3 = new Grid(Arrays.asList("X", "X", "X", ".", ".", ".", ".", ".", "."));
        Grid gridB1 = new Grid(Arrays.asList("X", "X", "X", "X", ".", ".", ".", ".", "."));
        Grid gridB2 = new Grid(Arrays.asList("X", "X", "X", "X", "X", ".", ".", ".", "."));
        Grid gridB3 = new Grid(Arrays.asList("X", "X", "X", "X", "X", "X", ".", ".", "."));
        Grid gridC1 = new Grid(Arrays.asList("X", "X", "X", "X", "X", "X", "X", ".", "."));
        Grid gridC2 = new Grid(Arrays.asList("X", "X", "X", "X", "X", "X", "X", "X", "."));
        Grid gridC3 = new Grid(Arrays.asList("X", "X", "X", "X", "X", "X", "X", "X", "X"));
        Player player = new Player("p1", "X");

        assertEquals("input received", grid.addMove(0, player));
        assertEquals(gridA1.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(0, player));
        assertEquals(gridA1.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(1, player));
        assertEquals(gridA2.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(1, player));
        assertEquals(gridA2.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(2, player));
        assertEquals(gridA3.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(2, player));
        assertEquals(gridA3.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(3, player));
        assertEquals(gridB1.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(3, player));
        assertEquals(gridB1.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(4, player));
        assertEquals(gridB2.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(4, player));
        assertEquals(gridB2.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(5, player));
        assertEquals(gridB3.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(5, player));
        assertEquals(gridB3.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(6, player));
        assertEquals(gridC1.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(6, player));
        assertEquals(gridC1.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(7, player));
        assertEquals(gridC2.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(7, player));
        assertEquals(gridC2.getGrid(),grid.getGrid());
        assertEquals("input received", grid.addMove(8, player));
        assertEquals(gridC3.getGrid(),grid.getGrid());
        assertEquals("existing input", grid.addMove(8, player));
        assertEquals(gridC3.getGrid(),grid.getGrid());

        assertEquals("invalid grid", grid.addMove(-1, player));
        assertEquals(gridC3.getGrid(),grid.getGrid());
        assertEquals("invalid grid", grid.addMove(9, player));
        assertEquals(gridC3.getGrid(),grid.getGrid());
    }
}
