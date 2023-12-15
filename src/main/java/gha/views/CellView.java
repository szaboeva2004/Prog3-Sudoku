package main.java.gha.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CellView extends JPanel{
    public CellView(){
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(Color.lightGray);

        for (int i = 0; i < 9; i++) {
            JTextField textField = new JTextField();
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setBackground(Color.white);
            textField.setBorder(new LineBorder(Color.lightGray));
            textField.setFont(new Font("Roboto", Font.PLAIN, 20));
            this.add(textField);
        }
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        this.setVisible(true);
    }
}
