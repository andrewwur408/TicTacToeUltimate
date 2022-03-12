package persistence;

import exceptions.CorruptedSaveException;
import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
//todo: test json file for
    // CorruptedSaveException
    // - no/incorrect game type name
    // - no player turn data
    // - incorrect number of grid data || classic = 9, ultimate = 81



    @Test
    void testCorruptedClassicClassic() {
        JsonReader wrongGameType = new JsonReader("./data/testWrongGameTypeClassic.json");
        JsonReader noPlayerTurnData = new JsonReader("./data/testNoPlayerTurnDataClassic.json");
        JsonReader incorrectGridData = new JsonReader("./data/testIncorrectGridDataClassic.json");
        JsonReader invalidGridData = new JsonReader("./data/testInvalidGridDataClassic.json");

        try {
            wrongGameType.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }

        try {
            noPlayerTurnData.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }

        try {
            incorrectGridData.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }

        try {
            invalidGridData.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }
    }

    @Test
    void testCorruptedUltimate() {
        JsonReader wrongGameType = new JsonReader("./data/testWrongGameTypeUltimate.json");
        JsonReader noPlayerTurnData = new JsonReader("./data/testNoPlayerTurnDataUltimate.json");
        JsonReader incorrectGridData = new JsonReader("./data/testIncorrectGridDataUltimate.json");
        JsonReader invalidGridData = new JsonReader("./data/testInvalidGridDataUltimate.json");
        try {
            wrongGameType.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }

        try {
            noPlayerTurnData.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }

        try {
            incorrectGridData.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }

        try {
            invalidGridData.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (CorruptedSaveException e) {
            // pass
        }
    }

    @Test
    void testNormalGame() {
        JsonReader classicGame = new JsonReader("./data/testClassicGame.json");
        JsonReader ultimateGame = new JsonReader("./data/testUltimateGame.json");
        List<String> classicGrid = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid1 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid2 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid3 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid4 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid5 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid6 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid7 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid8 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<String> grid9 = Arrays.asList(".",".",".","X",".",".","O",".",".");
        List<Grid> ultimateGrid = Arrays.asList(new Grid(grid1), new Grid(grid2), new Grid(grid3), new Grid(grid4), new Grid(grid5), new Grid(grid6), new Grid(grid7), new Grid(grid8), new Grid(grid9));

        try {
            assertTrue(classicGame.read().getIsClassic());
            assertEquals(classicGrid, classicGame.read().getGrid().getGrid());
            assertNull(classicGame.read().getBigGrid());
            assertTrue(classicGame.read().getPlayer1Turn());
            //pass
        } catch (IOException e) {
            fail("did not expect IOException");
        } catch (CorruptedSaveException e) {
            fail("did not expect CorruptedSaveException");
        }

        try {
            assertFalse(ultimateGame.read().getIsClassic());
            assertNull(ultimateGame.read().getGrid());
            assertEquals(ultimateGrid.get(0).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(0).getGrid());
            assertEquals(ultimateGrid.get(1).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(1).getGrid());
            assertEquals(ultimateGrid.get(2).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(2).getGrid());
            assertEquals(ultimateGrid.get(3).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(3).getGrid());
            assertEquals(ultimateGrid.get(4).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(4).getGrid());
            assertEquals(ultimateGrid.get(5).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(5).getGrid());
            assertEquals(ultimateGrid.get(6).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(6).getGrid());
            assertEquals(ultimateGrid.get(7).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(7).getGrid());
            assertEquals(ultimateGrid.get(8).getGrid(), ultimateGame.read().getBigGrid().getGridList().get(8).getGrid());

            assertFalse(ultimateGame.read().getPlayer1Turn());
            //pass
        } catch (IOException e) {
            fail("did not expect IOException");
        } catch (CorruptedSaveException e) {
            fail("did not expect CorruptedSaveException");
        }
    }
}
