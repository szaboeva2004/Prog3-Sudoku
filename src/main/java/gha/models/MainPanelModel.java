package main.java.gha.models;

import javax.swing.*;

public class MainPanelModel {
    private int seconds;
    public void startTimer(Timer timer) {
        timer.start();
    }

    public void stopTimer(Timer timer) {
        timer.stop();
    }

    public void restartTimer(Timer timer, JLabel timerLabel) {
        stopTimer(timer);
        resetTimer(timerLabel);
        startTimer(timer);
    }

    public void resetTimer(JLabel timerLabel) {
        seconds = 0;
        updateTimerLabel(timerLabel);
    }

    public void updateTimerLabel(JLabel timerLabel) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, remainingSeconds));
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
