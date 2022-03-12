package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BigGridTest {


    @Test
    void testEmptyBigGrid() {
        List<Grid> gridList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            gridList.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        }
        Grid emptyGrid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        BigGrid bigGrid = new BigGrid(emptyGrid, gridList);

        assertEquals(emptyGrid.getGrid(), bigGrid.getBigGrid().getGrid());
        assertEquals(gridList, bigGrid.getGridList());
        assertEquals(9, bigGrid.getGridList().size());

    }

    @Test
    void testAddMoveBigGrid() {
        Player player1 = new Player("p1","X");
        Player player2 = new Player("p2","O");

        Grid emptyGrid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        List<Grid> gridList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            gridList.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        }
        List<Grid> generalTesting = new ArrayList<>();
        generalTesting.add(new Grid(Arrays.asList("O", "O", "O", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList("X", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        generalTesting.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        BigGrid bigGrid = new BigGrid(emptyGrid, generalTesting);
        bigGrid.updateBigGrid(player1, player2);


        assertEquals("invalid index", bigGrid.addMoveBigGrid(-1, player2));
        bigGrid.updateBigGrid(player1, player2);
        assertEquals("invalid index", bigGrid.addMoveBigGrid(81, player2));
        bigGrid.updateBigGrid(player1, player2);
        assertEquals("invalid sector", bigGrid.addMoveBigGrid(4, player1));
        bigGrid.updateBigGrid(player1, player2);
        assertEquals("input received", bigGrid.addMoveBigGrid(10, player1));
        bigGrid.updateBigGrid(player1, player2);
        assertEquals("invalid input", bigGrid.addMoveBigGrid(9, player2));

    }

    @Test
    void testUpdateBigGrid() {
        List<Grid> gridList0 = new ArrayList<>();
        Grid emptyGrid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));
        gridList0.add(new Grid(Arrays.asList("X", "X", ".", "X", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList0.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));

        BigGrid test0 = new BigGrid(emptyGrid, gridList0);
        BigGrid results0 = new BigGrid(emptyGrid, gridList0);

        List<Grid> gridList1 = new ArrayList<>();
        gridList1.add(new Grid(Arrays.asList("O", "O", "O", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList1.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));

        BigGrid test1 = new BigGrid(emptyGrid, gridList1);
        BigGrid results1 = new BigGrid(emptyGrid, gridList1);

        List<Grid> gridList2 = new ArrayList<>();
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", "X", ".", ".", "X", ".", ".", "X")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        gridList2.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));

        BigGrid test2 = new BigGrid(emptyGrid, gridList2);
        BigGrid results2 = new BigGrid(emptyGrid, gridList2);

        Player player1 = new Player("p1", "X");
        Player player2 = new Player("p2", "O");

        assertEquals(results0.getBigGrid(), test0.updateBigGrid(player1, player2).getBigGrid());
        assertEquals(results1.getBigGrid(), test1.updateBigGrid(player1, player2).getBigGrid());
        assertEquals(results2.getBigGrid(), test2.updateBigGrid(player1, player2).getBigGrid());

        // convertSmallGrid tests
        List<String> completeX = Arrays.asList("X", ".", "X", ".", "X", ".", "X", ".", "X");
        List<String> completeO = Arrays.asList(".", "O", ".", "O", "O", "O", ".", "O", ".");
        List<String> normal = Arrays.asList("X", "X", ".", "X", ".", ".", ".", ".", ".");

        test1.convertSmallGrid(player1, player2);
        assertEquals(normal, test0.convertSmallGrid(player1, player2).getGridList().get(0).getGrid());
        assertEquals(completeO, test1.convertSmallGrid(player1, player2).getGridList().get(0).getGrid());
        assertEquals(completeX, test2.convertSmallGrid(player1, player2).getGridList().get(4).getGrid());

        Grid wonBigGrid = new Grid(Arrays.asList("X", ".", "X", ".", "X", ".", "X", ".", "X"));
        BigGrid test4 = new BigGrid(wonBigGrid, gridList0);
        test4.getBigGrid().gridState(player1, player2);
    }
}


