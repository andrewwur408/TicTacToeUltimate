package ui;

import exceptions.CorruptedSaveException;
import model.EventLog;
import persistence.JsonReader;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Iterator;

// Main act as a Menu for the TicTacToe Machine
public class MainMenu extends JPanel implements ActionListener {
    private final JButton classic = new JButton("Classic");
    private final JButton ultimate = new JButton("Ultimate");
    private final JButton loadSave = new JButton("Load Save");
    private final JButton instructions = new JButton("Instructions");
    private final JButton quit = new JButton("Quit");

    private final JFrame frame = new JFrame("TicTacToe Machine");

    public MainMenu(Container pane) {
        // buttons
        makeButton(classic, "classic");
        makeButton(ultimate, "ultimate");
        makeButton(instructions, "instructions");
        makeButton(loadSave, "loadSave");
        makeButton(quit, "quit");

        //UI layout
        pane.setLayout(new GridLayout(0,1, 200, 10));
        pane.add(classic);
        pane.add(ultimate);
        pane.add(instructions);
        pane.add(loadSave);
        pane.add(quit);
    }

    //EFFECTS: given a button and actionCommand
    //        - setFocusable() as false
    //        - setActionCommand() with actionCommand
    private void makeButton(JButton button, String actionCommand) {
        button.setFocusable(false);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
        //Create and set up the window.
        JFrame frame = new JFrame("TicTacToe Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainMenu newContentPane = new MainMenu(frame.getContentPane());
        newContentPane.setOpaque(true); //content panes must be opaque

        //Display the window.
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    // run the corresponding code depending on the button pressed
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void actionPerformed(ActionEvent a) {
        switch (a.getActionCommand()) {
            case "classic": {
                new TicTacToeClassic();
                break;
            }
            case "ultimate": {
                new TicTacToeUltimate();
                break;
            }
            case "instructions": {
                new Instructions();
                break;
            }
            case "loadSave": {
                loadSave();
                break;
            }
            case "quit": {
                for (model.Event event : EventLog.getInstance()) {
                    System.out.println(event.getDescription());
                }
                System.exit(0);
            }
        }
    }

    //EFFECT: loads game with Saved data deals with IOException and CorruptedSaveException
    private void loadSave() {
        JsonReader savedGame = new JsonReader("./data/gameSave.json");
        try {
            savedGame.read();
            if (savedGame.read().getIsClassic()) {
                new TicTacToeClassic(savedGame.read().getGrid(), savedGame.read().getPlayer1Turn());
            } else {
                new TicTacToeUltimate(savedGame.read().getBigGrid(), savedGame.read().getPlayer1Turn());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "No Save Found");
            e.printStackTrace();
        } catch (CorruptedSaveException e) {
            JOptionPane.showMessageDialog(frame, "ERROR: save is corrupted");
        }
    }
}
