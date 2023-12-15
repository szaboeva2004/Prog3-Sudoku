package main.java.gha.controllers;

import main.java.gha.models.MainPanelModel;
import main.java.gha.views.MainPanel;

import javax.swing.*;

public class MainPanelController {
    private final MainPanel mainPanel;
    private final MainPanelModel mainPanelModel;

    public MainPanelController(MainPanel mainPanel, MainPanelModel mainPanelModel){
        this.mainPanel = mainPanel;
        this.mainPanelModel = mainPanelModel;


        mainPanel.setTimer(new Timer(1000, e -> {
            mainPanelModel.setSeconds(mainPanelModel.getSeconds()+1);
            mainPanelModel.updateTimerLabel(mainPanel.getTimerLabel());
        }));

        mainPanel.getVeryEasyButton().addActionListener(e -> {
            mainPanelModel.startTimer(mainPanel.getTimer());
        });

        mainPanel.getEasyButton().addActionListener(e -> {
            mainPanelModel.startTimer(mainPanel.getTimer());
        });

        mainPanel.getNormalButton().addActionListener(e -> {
            mainPanelModel.startTimer(mainPanel.getTimer());
        });

        mainPanel.getHardButton().addActionListener(e -> {
            mainPanelModel.startTimer(mainPanel.getTimer());
        });

        mainPanel.getRestartButton().addActionListener(e -> {
            mainPanelModel.restartTimer(mainPanel.getTimer(), mainPanel.getTimerLabel());
        });

        mainPanel.getClearAllButton().addActionListener(e -> {
            mainPanelModel.stopTimer(mainPanel.getTimer());
            mainPanelModel.resetTimer(mainPanel.getTimerLabel());
        });
    }
}
