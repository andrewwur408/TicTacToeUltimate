package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Instruction for games TicTacToe Classic, TicTacToe Ultimate as well as how to enter inputs.
public class Instructions implements ActionListener {
    private final JFrame frame = new JFrame();
    
    public Instructions() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        getInstructions();
        
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings", "checkstyle:LineLength"})
    private void getInstructions() {
        JButton exit = new JButton("Close");
        exit.setActionCommand("exit");
        exit.addActionListener(this);
        exit.setFocusable(false);

        frame.setLayout(new GridLayout(0,1,0,10));
        frame.add(BorderLayout.CENTER, new JLabel("------------------------------ TicTacToe Classic ------------------------------"));
        frame.add(BorderLayout.CENTER, new JLabel("In TicTacToe Classic the goal is the be the first to create a 1x3 line with your symbol"));
        frame.add(BorderLayout.CENTER, new JLabel("which can be horizontal vertical and diagonal"));
        frame.add(BorderLayout.CENTER, new JLabel(""));
        frame.add(BorderLayout.CENTER, new JLabel("------------------------------ TicTacToe Ultimate ------------------------------"));
        frame.add(BorderLayout.CENTER, new JLabel("In TicTacToe Ultimate the goal is the be the first to create a 1x3 line in the larger 3x3"));
        frame.add(BorderLayout.CENTER, new JLabel("sector which can be horizontal vertical and diagonal, each sector contain a 3x3 grid"));
        frame.add(BorderLayout.CENTER, new JLabel("which behaves similar to a TicTacToe grid. Sector can be only won if you win the"));
        frame.add(BorderLayout.CENTER, new JLabel("TicTacToe game at the given sector"));
        frame.add(BorderLayout.CENTER, new JLabel(""));
        frame.add(BorderLayout.CENTER, new JLabel(""));
        frame.add(BorderLayout.CENTER, exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "exit": {
                frame.dispose();
                break;
            }
        }

    }
}
