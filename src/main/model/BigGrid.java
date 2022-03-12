package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// BigGrid data, stores, checks and adds data for a 9 3x3 TicTacToe grid arranged into a 3x3 sectors/BigGrids
public class BigGrid {
    private final List<Grid> gridList;
    private final Grid bigGrid;

    // Constructs a big 3x3 grid with each grid contain a smaller 3x3 grid
    public BigGrid(Grid bigGrid, List<Grid> gridList) {
        this.bigGrid = bigGrid;
        this.gridList = gridList;
    }

    // REQUIRES: all Grid's contains a 9 element array, gridList contain 9 Grids
    // MODIFIES: this
    // EFFECTS: add playerSymbol to smallGrids in the bigGrid only if the current value is null
    // and bigGrid indicates that gird does not have a winner or is "draw"
    // returns "invalid grid" if bigGrid's location is invalid
    // returns "sector won/drawn" if bigGrid's location is valid but not equals to "."
    // returns result of addMove() of the gird if above statements are not used.
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
    public String addMoveBigGrid(int index, Player player) {
        int gridListIndex = (index / 9);
        int gridIndex = (index % 9);

        if (index <= -1 || index >= 81) {
            return "invalid index";
        } else if (!bigGrid.getGrid().get(gridListIndex).equals(".")) {
            return "invalid sector";
        } else if (gridList.get(gridListIndex).getGrid().get(gridIndex).equals(".")) {
            EventLog.getInstance().logEvent(new Event(player.getPlayerName() + " added their symbol on sector " + (gridIndex + 1)  + " grid " + (gridIndex + 1)));
            gridList.get(gridListIndex).getGrid().set(gridIndex, player.getPlayerSymbol());
            return "input received";
        } else  {
            return "invalid input";
        }
    }

    // REQUIRES: Gird contains a 9 element array
    // MODIFIES: this
    // EFFECTS: copies the value of a small grid's gridState to its location on bigGrid
    public BigGrid updateBigGrid(Player player1, Player player2) {
        for (int i = 0; i <= 8; i++) {
            String gridState = gridList.get(i).gridState(player1, player2);
            if (!gridState.equals(".")) {
                bigGrid.getGrid().set(i,gridState);
            }
        }
        return new BigGrid(bigGrid, gridList);
    }

    // REQUIRES: Gird contains a 9 element array
    // MODIFIES: this
    // EFFECTS: convert a Won or Drawn Sector into a specific arrangement for display
    public BigGrid convertSmallGrid(Player player1,Player player2) {
        for (int i = 0; i <= 8; i++) {
            String getGridState = gridList.get(i).gridState(player1, player2);
            if (getGridState.equals(player1.getPlayerSymbol())) {
                gridList.set(i, new Grid(Arrays.asList("X", ".", "X", ".", "X", ".", "X", ".", "X")));
                EventLog.getInstance().logEvent(new Event(player1.getPlayerName() + " won sector " + (i + 1)));
            } else if (getGridState.equals(player2.getPlayerSymbol())) {
                gridList.set(i, new Grid(Arrays.asList(".", "O", ".", "O", "O", "O", ".", "O", ".")));
                EventLog.getInstance().logEvent(new Event(player2.getPlayerName() + " won sector " + (i + 1)));
            }
        }
        return new BigGrid(bigGrid,gridList);
    }

    public List<Grid> getGridList() {
        return gridList;
    }

    public Grid getBigGrid() {
        return bigGrid;
    }

}
