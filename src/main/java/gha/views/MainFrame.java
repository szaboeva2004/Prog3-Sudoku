package main.java.gha.views;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1052, 552));
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.pink);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.ipadx = 200;
        gbc.ipady = 200;
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new SudokuPanel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(new MainPanel(), gbc);

        ImageIcon icon = new ImageIcon("C:\\repos\\Prog3-Sudoku\\src\\main\\resources\\sudoku_icon.png");

        setIconImage(icon.getImage());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}