package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class GameTemplate extends GameTemplateUI {

    public GameTemplate() {
    }

    // EFFECTS: setsUp the game
    protected void setUp() {
        isGameOver = false;
        player1Turn = true;
    }

    // EFFECTS: loads the game turn of the save
    protected void loadTurn(Boolean player1Turn) {
        isGameOver = false;
        this.player1Turn = player1Turn;

    }

    //EFFECTS: return player1 if player1Turn is true, player2 otherwise
    protected Player turnToPlayer() {
        Player player;
        if (player1Turn) {
            player = player1;
        } else {
            player = player2;
        }
        return player;
    }

    // EFFECTS: create a popup that the game is over
    protected void gameOver(String gameState) {
        isGameOver = true;

        if (gameState.equals("draw")) {
            dialogBox("draw");
        } else {
            if (gameState.equals(player1.getPlayerSymbol())) {
                dialogBox("Player 1 Wins");
            } else {
                dialogBox("Player 2 Wins");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: updates the game
    protected void updateTurn(String moveState) {
        if (moveState.equals("input received")) {
            player1Turn = !player1Turn;
        }
    }

}
