package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Grid data, stores, check and adds data for a 3x3 TicTacToe grid
public class Grid {
    private final List<String> grid;

    // Constructs a 3x3 grid for tic toe
    public Grid(List<String> grid) {
        this.grid = grid;
    }

    // REQUIRES: Gird contains a 9 element array
    // MODIFIES: this
    // EFFECTS: add playerName to the grid only if the current value is "
    // returns "invalid grid" index >= 9 or <= -1
    // returns "input received" if location contains value of "."
    // returns "existing input" otherwise
    public String addMove(int index, Player player) {
        if (index >= 9 || index <= -1) {
            return "invalid grid";
        } else if (grid.get(index).equals(".")) {
            grid.set(index, player.getPlayerSymbol());
            EventLog.getInstance().logEvent(new Event(player.getPlayerName() + " added their symbol on grid " + index));
            return "input received";
        } else {
            return "existing input";
        }
    }

    // REQUIRES: Gird to contain a 9 element array
    // EFFECTS: a 1x3 line can vertical horizontal and diagonal
    //         return the winning playerName if 1x3 line has been completed by a player
    //         return "draw" if no more 1x3 lines can be created by both players
    //         return "." if all above are false
    public String gridState(Player player1, Player player2) {
        List<String> player1Grid = new ArrayList<>(grid);
        List<String> player2Grid = new ArrayList<>(grid);
        List<String> gridState =  new ArrayList<>();
        replaceTbaWithPlayer(player1Grid, player1);
        replaceTbaWithPlayer(player2Grid, player2);

        gridState.add(gridStateVertical(player1Grid, player2Grid, player1, player2));
        gridState.add(gridStateHorizontal(player1Grid, player2Grid, player1, player2));
        gridState.add(gridStateDiagonal(player1Grid, player2Grid, player1, player2));

        if (gridState.contains(player1.getPlayerSymbol())) {
            return player1.getPlayerSymbol();
        } else if (gridState.contains(player2.getPlayerSymbol())) {
            return player2.getPlayerSymbol();
        } else if (gridState.contains(".")) {
            return ".";
        } else {
            EventLog.getInstance().logEvent(new Event(" draw!"));
            return "draw";
        }
    }

    private void replaceTbaWithPlayer(List<String> playerGrid, Player player) {
        for (int i = 0; i <= 8; i++) {
            if (playerGrid.get(i).equals(".")) {
                playerGrid.set(i, player.getPlayerSymbol());
            }
        }
    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
    private String gridStateVertical(List<String> player1Grid, List<String> player2Grid, Player player1, Player player2) {
        for (int i = 0; i <= 2; i++) {
            if (Stream.of(grid.get(i * 3), grid.get(i * 3 + 1), grid.get(i * 3 + 2)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
                return player1.getPlayerSymbol();
            }
            if (Stream.of(grid.get(i * 3), grid.get(i * 3 + 1), grid.get(i * 3 + 2)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
                return player2.getPlayerSymbol();
            }
        }
        for (int i = 0; i <= 2; i++) {

            if (Stream.of(player1Grid.get(i * 3), player1Grid.get(i * 3 + 1), player1Grid.get(i * 3 + 2)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
                return ".";
            }
            if (Stream.of(player2Grid.get(i * 3), player2Grid.get(i * 3 + 1), player2Grid.get(i * 3 + 2)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
                return ".";
            }
        }
        return "draw";
    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
    private String gridStateHorizontal(List<String> player1Grid, List<String> player2Grid, Player player1, Player player2) {
        for (int i = 0; i <= 2; i++) {
            if (Stream.of(grid.get(i), grid.get(i + 3), grid.get(i + 6)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
                return player1.getPlayerSymbol();
            }
            if (Stream.of(grid.get(i), grid.get(i + 3), grid.get(i + 6)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
                return player2.getPlayerSymbol();
            }
        }
        for (int i = 0; i <= 2; i++) {
            if (Stream.of(player1Grid.get(i), player1Grid.get(i + 3), player1Grid.get(i + 6)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
                return ".";
            }
            if (Stream.of(player2Grid.get(i), player2Grid.get(i + 3), player2Grid.get(i + 6)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
                return ".";
            }
        }
        return "draw";
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings", "checkstyle:LineLength"})
    private String gridStateDiagonal(List<String> player1Grid, List<String> player2Grid, Player player1, Player player2) {
        if (Stream.of(grid.get(0), grid.get(4), grid.get(8)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
            return player1.getPlayerSymbol();
        }
        if (Stream.of(grid.get(0), grid.get(4), grid.get(8)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
            return player2.getPlayerSymbol();
        }
        if (Stream.of(grid.get(2), grid.get(4), grid.get(6)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
            return player1.getPlayerSymbol();
        }
        if (Stream.of(grid.get(2), grid.get(4), grid.get(6)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
            return player2.getPlayerSymbol();
        }
        if (Stream.of(player1Grid.get(2), player1Grid.get(4), player1Grid.get(6)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
            return ".";
        }
        if (Stream.of(player2Grid.get(2), player2Grid.get(4), player2Grid.get(6)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
            return ".";
        }
        if (Stream.of(player1Grid.get(0), player1Grid.get(4), player1Grid.get(8)).allMatch(player1.getPlayerSymbol()::equalsIgnoreCase)) {
            return ".";
        }
        if (Stream.of(player2Grid.get(0), player2Grid.get(4), player2Grid.get(8)).allMatch(player2.getPlayerSymbol()::equalsIgnoreCase)) {
            return ".";
        }
        return "draw";
    }

    public List<String> getGrid() {
        return grid;
    }
}
