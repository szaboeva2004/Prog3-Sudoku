package main.java.gha.views;

import javax.swing.*;
import java.awt.*;

public class SudokuPanel extends JPanel{

    public SudokuPanel()
    {
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(3,3));
        for(int i =0; i<9;i++)
        {
            CellView cellView = new CellView();
            this.add(cellView);
        }
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setVisible(true);
    }
}
