package ui;


import model.BigGrid;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

// The Game TicTacToeClassic uses Classes: Grid, BigGrid and Player
public class TicTacToeUltimate extends TicTacToeUltimateUI {


    public TicTacToeUltimate() {
        setUp();
        displayGame();
    }

    // loads TicTacToeUltimate game
    public TicTacToeUltimate(BigGrid bigGrid, boolean player1Turn) {
        this.bigGrid = bigGrid;
        bigGrid.getBigGrid().gridState(player1, player2);
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
            case "9": {
                index = 9;
                update(index);
                break;
            }
            case "10": {
                index = 10;
                update(index);
                break;
            }
            case "11": {
                index = 11;
                update(index);
                break;
            }
            case "12": {
                index = 12;
                update(index);
                break;
            }
            case "13": {
                index = 13;
                update(index);
                break;
            }
            case "14": {
                index = 14;
                update(index);
                break;
            }
            case "15": {
                index = 15;
                update(index);
                break;
            }
            case "16": {
                index = 16;
                update(index);
                break;
            }
            case "17": {
                index = 17;
                update(index);
                break;
            }
            case "18": {
                index = 18;
                update(index);
                break;
            }
            case "19": {
                index = 19;
                update(index);
                break;
            }
            case "20": {
                index = 20;
                update(index);
                break;
            }
            case "21": {
                index = 21;
                update(index);
                break;
            }
            case "22": {
                index = 22;
                update(index);
                break;
            }
            case "23": {
                index = 23;
                update(index);
                break;
            }
            case "24": {
                index = 24;
                update(index);
                break;
            }
            case "25": {
                index = 25;
                update(index);
                break;
            }
            case "26": {
                index = 26;
                update(index);
                break;
            }
            case "27": {
                index = 27;
                update(index);
                break;
            }
            case "28": {
                index = 28;
                update(index);
                break;
            }
            case "29": {
                index = 29;
                update(index);
                break;
            }
            case "30": {
                index = 30;
                update(index);
                break;
            }
            case "31": {
                index = 31;
                update(index);
                break;
            }
            case "32": {
                index = 32;
                update(index);
                break;
            }
            case "33": {
                index = 33;
                update(index);
                break;
            }
            case "34": {
                index = 34;
                update(index);
                break;
            }
            case "35": {
                index = 35;
                update(index);
                break;
            }
            case "36": {
                index = 36;
                update(index);
                break;
            }
            case "37": {
                index = 37;
                update(index);
                break;
            }
            case "38": {
                index = 38;
                update(index);
                break;
            }
            case "39": {
                index = 39;
                update(index);
                break;
            }
            case "40": {
                index = 40;
                update(index);
                break;
            }
            case "41": {
                index = 41;
                update(index);
                break;
            }
            case "42": {
                index = 42;
                update(index);
                break;
            }
            case "43": {
                index = 43;
                update(index);
                break;
            }
            case "44": {
                index = 44;
                update(index);
                break;
            }
            case "45": {
                index = 45;
                update(index);
                break;
            }
            case "46": {
                index = 46;
                update(index);
                break;
            }
            case "47": {
                index = 47;
                update(index);
                break;
            }
            case "48": {
                index = 48;
                update(index);
                break;
            }
            case "49": {
                index = 49;
                update(index);
                break;
            }
            case "50": {
                index = 50;
                update(index);
                break;
            }
            case "51": {
                index = 51;
                update(index);
                break;
            }
            case "52": {
                index = 52;
                update(index);
                break;
            }
            case "53": {
                index = 53;
                update(index);
                break;
            }
            case "54": {
                index = 54;
                update(index);
                break;
            }
            case "55": {
                index = 55;
                update(index);
                break;
            }
            case "56": {
                index = 56;
                update(index);
                break;
            }
            case "57": {
                index = 57;
                update(index);
                break;
            }
            case "58": {
                index = 58;
                update(index);
                break;
            }
            case "59": {
                index = 59;
                update(index);
                break;
            }
            case "60": {
                index = 60;
                update(index);
                break;
            }
            case "61": {
                index = 61;
                update(index);
                break;
            }
            case "62": {
                index = 62;
                update(index);
                break;
            }
            case "63": {
                index = 63;
                update(index);
                break;
            }
            case "64": {
                index = 64;
                update(index);
                break;
            }
            case "65": {
                index = 65;
                update(index);
                break;
            }
            case "66": {
                index = 66;
                update(index);
                break;
            }
            case "67": {
                index = 67;
                update(index);
                break;
            }
            case "68": {
                index = 68;
                update(index);
                break;
            }
            case "69": {
                index = 69;
                update(index);
                break;
            }
            case "70": {
                index = 70;
                update(index);
                break;
            }
            case "71": {
                index = 71;
                update(index);
                break;
            }
            case "72": {
                index = 72;
                update(index);
                break;
            }
            case "73": {
                index = 73;
                update(index);
                break;
            }
            case "74": {
                index = 74;
                update(index);
                break;
            }
            case "75": {
                index = 75;
                update(index);
                break;
            }
            case "76": {
                index = 76;
                update(index);
                break;
            }
            case "77": {
                index = 77;
                update(index);
                break;
            }
            case "78": {
                index = 78;
                update(index);
                break;
            }
            case "79": {
                index = 79;
                update(index);
                break;
            }
            case "80": {
                index = 80;
                update(index);
                break;
            }
            case "help": {
                new Instructions();
                break;
            }
            case "save": {
                try {
                    new JsonWriter("./data/gameSave.json", bigGrid, player1Turn);
                    JOptionPane.showMessageDialog(frame, "Game Saved");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "ERROR: invalid save location for TiTacToeUltimate");
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

            //updating grids
            updateTurn(bigGrid.addMoveBigGrid(index, turnToPlayer()));
            bigGrid.convertSmallGrid(player1, player2);

            //updating buttons
            for (int i = 0; i <= 80; i++) {
                if (bigGridWithIndex(i).equals(".")) {
                    buttonList.get(i).setText("");
                } else {
                    buttonList.get(i).setText(bigGridWithIndex(i));
                }
            }
            buttonList.get(index).setEnabled(false);
            disableButtonsBigGrid();

            //updating turnLabel
            turnLabel.setText(turnToPlayer().getPlayerName());

            //check if game is over
            if (!bigGrid.getBigGrid().gridState(player1, player2).equals(".")) {
                gameOver(bigGrid.getBigGrid().gridState(player1, player2));
            }
        }
    }
}
