package model;

// used to save data read from json files in JsonReader Class
public class Data {
    private final boolean isClassic;
    private final boolean player1Turn;
    private Grid grid;
    private BigGrid bigGrid;

    //constructor for TicTacToe Classic
    public Data(boolean isClassic, Grid grid, boolean player1Turn) {

        this.isClassic = isClassic;
        this.grid = grid;
        this.player1Turn = player1Turn;
    }

    //constructor for TicTacToe Classic
    public Data(boolean isClassic, BigGrid bigGrid, boolean player1Turn) {
        this.isClassic = isClassic;
        this.bigGrid = bigGrid;
        this.player1Turn = player1Turn;
    }

    public boolean getIsClassic() {
        return isClassic;
    }

    public Grid getGrid() {
        return grid;
    }

    public BigGrid getBigGrid() {
        return bigGrid;
    }

    public boolean getPlayer1Turn() {
        return player1Turn;
    }
}
