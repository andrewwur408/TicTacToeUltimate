package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class GameTemplateUI implements ActionListener {
    protected final Player player1;
    protected final Player player2;
    protected boolean isGameOver;
    protected boolean player1Turn;
    protected JLabel turnLabel;
    protected JFrame frame = new JFrame();

    public GameTemplateUI() {
        player1 = new Player("player 1", "X");
        player2 = new Player("player 2", "O");
    }

    //MODIFIES: this
    //EFFECTS: create a menuBar
    protected JMenuBar menuBar() {
        //creating the menu buttons
        JMenuBar menuBar = new JMenuBar();
        JMenu menuItemGame = new JMenu("Game");
        menuBar.add(menuItemGame);
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem help = new JMenuItem("Help");
        menuItemGame.add(quit);
        menuItemGame.add(save);
        menuBar.add(help);

        // menu actionListener
        quit.setActionCommand("quit");
        save.setActionCommand("save");
        help.setActionCommand("help");

        quit.addActionListener(this);
        save.addActionListener(this);
        help.addActionListener(this);

        return menuBar;
    }

    protected void dialogBox(String message) {
        JDialog dialog = new JDialog(frame, "", true);
        dialog.add(new JLabel(message));
        dialog.setLayout(new FlowLayout());

        JButton quit = new JButton("Quit");
        JButton playAgain = new JButton("playAgain");

        quit.setActionCommand("quit");
        playAgain.setActionCommand("replay");

        quit.addActionListener(this);
        playAgain.addActionListener(this);

        dialog.add(quit);
        //dialog.add(playAgain);

        dialog.setSize(300, 100);
        dialog.setVisible(true);
    }
}
