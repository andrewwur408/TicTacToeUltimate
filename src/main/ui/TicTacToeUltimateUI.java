package ui;

import model.BigGrid;
import model.Grid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TicTacToeUltimateUI extends GameTemplate {
    protected BigGrid bigGrid;
    protected final List<JButton> buttonList = new ArrayList<>();

    public TicTacToeUltimateUI() {
        List<Grid> gridList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            gridList.add(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")));
        }
        bigGrid = new BigGrid(new Grid(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".")), gridList);
    }


    //EFFECTS: creates a List of Buttons with list of String,
    //       string which = "." become displayed as ""
    //       string valve that is not "." is displayed as is and the button is disabled
    protected void addButtons(JPanel gridPanel, List<JPanel> gridPanelList) {
        //buttons
        int counter = 0;
        GridLayout gridLayout = new GridLayout(3,3,10,10);
        GridLayout panelLayout = new GridLayout(3,3);

        for (JPanel panel: gridPanelList) {
            gridPanel.setLayout(gridLayout);
            panel.setLayout(panelLayout);

            gridPanel.add(panel);

            for (int i = 0; i <= 8; i++) {
                JButton button = new JButton();
                if (!bigGridWithIndex(counter).equals(".")) {
                    button.setText(bigGridWithIndex(counter));
                    button.setEnabled(false);
                } else {
                    button.setText("");
                }

                panel.add(button);
                buttonList.add(button);
                button.setActionCommand(String.valueOf(counter));
                button.addActionListener(this);

                counter++;
            }
        }
        disableButtonsBigGrid();
    }

    protected void disableButtonsBigGrid() {
        bigGrid.updateBigGrid(player1, player2);
        for (int i = 0; i <= 8; i++) {
            if (!bigGrid.getBigGrid().getGrid().get(i).equals(".")) {
                for (int j = 0; j <= 8; j++) {
                    buttonList.get(i * 9 + j).setEnabled(false);
                }
            }
        }
    }

    //EFFECTS: creates a List of JPanel for the TicTacToeClassic's UI
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
    protected List<JPanel> panel() {
        List<JPanel> panelList = new ArrayList<>();
        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        List<JPanel> gridPanelList = Arrays.asList(new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel());
        JPanel labelPanel = new JPanel(new GridLayout(1, 2));

        //labels
        JLabel gameLabel = new JLabel("TicTacToeUltimate");
        turnLabel = new JLabel(turnToPlayer().getPlayerName());
        labelPanel.add(gameLabel);
        labelPanel.add(turnLabel);
        addButtons(gridPanel, gridPanelList);

        //combining the JPanels into a list
        panelList.add(gridPanel);
        panelList.add(labelPanel);
        return panelList;
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

    protected String bigGridWithIndex(int index) {
        int gridListIndex = (index / 9);
        int gridIndex = (index % 9);
        return bigGrid.getGridList().get(gridListIndex).getGrid().get(gridIndex);
    }
}
