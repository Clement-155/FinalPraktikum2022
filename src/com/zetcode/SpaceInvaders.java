package com.zetcode;

import java.awt.EventQueue;
import javafx.embed.swing.SwingNode;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class SpaceInvaders extends JFrame  {

    public SpaceInvaders(int score) {

        initUI(score);
    }

    private void initUI(int score) {

        add(new Board(score));

        setTitle("Space Invaders");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setResizable(false);
        setLocationRelativeTo(null);
    }



}
