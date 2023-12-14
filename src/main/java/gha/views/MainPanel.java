package main.java.gha.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
public class MainPanel extends JPanel {
    private JButton veryEasyButton = new JButton("Very Easy");
    private JButton easyButton = new JButton("Easy");
    private JButton normalButton = new JButton("Normal");
    private JButton hardButton = new JButton("Hard");
    private JButton restartButton = new JButton("Restart");
    private JButton clearAllButton = new JButton("Clear All");
    private Timer timer;
    private JLabel timerLabel;
    private int seconds;

    public MainPanel() {
        this.setBackground(Color.pink);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(20));

        // SUDOKU
        JPanel sudokuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sudokuPanel.setBackground(Color.pink);
        JLabel sudokuSign = new JLabel("SUDOKU");
        sudokuSign.setFont(sudokuSign.getFont().deriveFont(40f));
        sudokuPanel.add(sudokuSign);
        add(sudokuPanel);

        // NEXT GAME
        JLabel nextGameLabel = new JLabel("NEXT GAME");
        nextGameLabel.setFont(nextGameLabel.getFont().deriveFont(18f));
        nextGameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(nextGameLabel);

        JPanel nextGamePanel = new JPanel();
        nextGamePanel.setLayout(new GridLayout(2, 2, 5, 5));
        nextGamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextGamePanel.setBackground(Color.pink);
        nextGamePanel.add(veryEasyButton);
        nextGamePanel.add(easyButton);
        nextGamePanel.add(normalButton);
        nextGamePanel.add(hardButton);
        add(nextGamePanel);

        add(Box.createVerticalStrut(40));

        // CLEAR
        JLabel clearLabel = new JLabel("CLEAR");
        clearLabel.setFont(clearLabel.getFont().deriveFont(18f));
        clearLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(clearLabel);

        JPanel clearPanel = new JPanel();
        clearPanel.setLayout(new GridLayout(2, 1, 5, 10));
        clearPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearPanel.setBackground(Color.pink);
        clearPanel.add(restartButton);
        clearPanel.add(clearAllButton);
        add(clearPanel);

        add(Box.createVerticalStrut(40));

        // Timer
        JLabel timerSectionLabel = new JLabel("Timer");
        timerSectionLabel.setFont(timerSectionLabel.getFont().deriveFont(18f));
        timerSectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(timerSectionLabel);

        timerLabel = new JLabel("00:00");
        timerLabel.setFont(timerLabel.getFont().deriveFont(24f));
        timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(timerLabel);


        setButtonStyle(veryEasyButton);
        setButtonStyle(easyButton);
        setButtonStyle(normalButton);
        setButtonStyle(hardButton);
        setButtonStyle(restartButton);
        setButtonStyle(clearAllButton);

        timer = new Timer(1000, e -> {
            seconds++;
            updateTimerLabel();
        });

        veryEasyButton.addActionListener(e -> {
            startTimer();
        });

        easyButton.addActionListener(e -> {
            startTimer();
        });

        normalButton.addActionListener(e -> {
            startTimer();
        });

        hardButton.addActionListener(e -> {
            startTimer();
        });

        restartButton.addActionListener(e -> {
            restartTimer();
        });

        clearAllButton.addActionListener(e -> {
            stopTimer();
            resetTimer();
        });
    }
    private void setButtonStyle(JButton button) {
        button.setBackground(new Color(187,133,171));
        button.setForeground(Color.black);
        button.setBorder(new LineBorder(Color.pink));
        button.setFocusPainted(false);
    }
    private void startTimer() {
        timer.start();
    }

    private void stopTimer() {
        timer.stop();
    }

    private void restartTimer() {
        stopTimer();
        resetTimer();
        startTimer();
    }

    private void resetTimer() {
        seconds = 0;
        updateTimerLabel();
    }

    private void updateTimerLabel() {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, remainingSeconds));
    }
}

