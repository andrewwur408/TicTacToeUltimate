package ui;

import model.Grid;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The Game TicTacToeClassic uses Classes: Grid and Player
public class TicTacToeClassic extends TicTacToeClassicUI {

    public TicTacToeClassic() {
        setUp();
        displayGame();
    }

    // loads TicTacToeClassic game
    public TicTacToeClassic(Grid grid, boolean player1Turn) {
        this.grid = grid;
        loadTurn(player1Turn);
        displayGame();
    }

    // EFFECTS: resets the game for a new game
    private void newGame() {
        isGameOver = false;
        player1Turn = true;
        buttonList.clear();
        isGameOver = false;
        frame = new JFrame();
        displayGame();
    }

    //EFFECTS: run code according the button pressed
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void actionPerformed(ActionEvent a) {
        int index;

        switch (a.getActionCommand()) {
            case "0": {
                index = 0;
                update(index);
                break;
            }
            case "1": {
                index = 1;
                update(index);
                break;
            }
            case "2": {
                index = 2;
                update(index);
                break;
            }
            case "3": {
                index = 3;
                update(index);
                break;
            }
            case "4": {
                index = 4;
                update(index);
                break;
            }
            case "5": {
                index = 5;
                update(index);
                break;
            }
            case "6": {
                index = 6;
                update(index);
                break;
            }
            case "7": {
                index = 7;
                update(index);
                break;
            }
            case "8": {
                index = 8;
                update(index);
                break;
            }
            case "help": {
                new Instructions();
                break;
            }
            case "save": {
                try {
                    new JsonWriter("./data/gameSave.json", grid, player1Turn);
                    JOptionPane.showMessageDialog(frame, "Game Saved");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "ERROR: invalid save location for TiTacToeClassic");
                    e.printStackTrace();
                }
                frame.dispose();

                break;
            }

            case "quit": {
                frame.dispose();
                break;
            }

            case "replay": {
                newGame();
                break;
            }
            default: {
                JOptionPane.showMessageDialog(frame, "ERROR: did not find the button");
                break;
            }
        }
    }

    // EFFECTS: updates the buttons to it's corresponding grid after a button press
    private void update(int index) {
        if (!isGameOver) {
            updateTurn(grid.addMove(index, turnToPlayer()));
            buttonList.get(index).setText(grid.getGrid().get(index));
            buttonList.get(index).setEnabled(false);
            turnLabel.setText(turnToPlayer().getPlayerName());
            //check if game is over
            if (!grid.gridState(player1, player2).equals(".")) {
                gameOver(grid.gridState(player1, player2));
            }
        }
    }
}
