package ui;

import model.Grid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TicTacToeClassicUI extends GameTemplate {
    protected Grid grid;
    protected final List<JButton> buttonList = new ArrayList<>();

    public TicTacToeClassicUI() {
        grid = new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));

    }

    // EFFECTS: builds the graphical user interface with the data from the classic game using the given JFrame
    protected void displayGame() {
        //Create and set up the content pane.
        frame.add(BorderLayout.NORTH, menuBar());
        frame.add(BorderLayout.CENTER, panel().get(0)); //grid
        frame.add(BorderLayout.SOUTH, panel().get(1)); //game label
        //Display the window.
        frame.setSize(600, 800);
        frame.setVisible(true);

    }

    //EFFECTS: creates a List of JPanel for the TicTacToeClassic's UI
    protected java.util.List<JPanel> panel() {
        java.util.List<String> getGrid = grid.getGrid();
        java.util.List<JPanel> panelList = new ArrayList<>();
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        JPanel labelPanel = new JPanel(new GridLayout(1, 2));

        //labels
        JLabel gameLabel = new JLabel("TicTacToeClassic");
        turnLabel = new JLabel(turnToPlayer().getPlayerName());
        labelPanel.add(gameLabel);
        labelPanel.add(turnLabel);
        addButtons(getGrid, gridPanel);

        //combining the JPanels into a list
        panelList.add(gridPanel);
        panelList.add(labelPanel);
        return panelList;
    }

    //EFFECTS: creates a List of Buttons with list of String,
    //       string which = "." become displayed as ""
    //       string valve that is not "." is displayed as is and the button is disabled
    protected void addButtons(List<String> getGrid, JPanel gridPanel) {
        //buttons
        for (int i = 0; i <= 8; i++) {
            JButton button = new JButton();

            if (!getGrid.get(i).equals(".")) {
                button.setText(getGrid.get(i));
                button.setEnabled(false);
            }

            gridPanel.add(button);
            buttonList.add(button);
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);

        }
    }
}
