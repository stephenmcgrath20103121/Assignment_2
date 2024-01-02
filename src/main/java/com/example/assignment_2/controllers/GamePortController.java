package com.example.assignment_2.controllers;

import com.example.assignment_2.ServiceApplication;
import com.example.assignment_2.models.Game;
import com.example.assignment_2.models.GamePort;
import com.example.assignment_2.models.GamesMachine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GamePortController {
    private MyLinkedList<GamePort> allGamePorts=new MyLinkedList<>();

    @FXML
    private TextField addPortedGame,addGamesMachinePortedTo, addPortDeveloper, addLaunchYear, addCoverArt;
    @FXML
    private Button display;

    @FXML
    protected void addGamePorts(){
        String portedGame= Game.class.getName();
        String gamesMachinePortedTo= addGamesMachinePortedTo.getText();
        String portDeveloper=addPortDeveloper.getText();
        int launchYear=Integer.parseInt(addLaunchYear.getText());
        String coverArt=addCoverArt.getText();

        GamePort p =new GamePort(portedGame, gamesMachinePortedTo, portDeveloper, launchYear, coverArt);
        p.setPortedGame(portedGame);
        p.setGamesMachinePortedTo(gamesMachinePortedTo);
        p.setPortDeveloper(portDeveloper);
        p.setLaunchYear(launchYear);
        p.setCoverArt(coverArt);

        allGamePorts.add(p);

        addPortedGame.clear();
        addGamesMachinePortedTo.clear();
        addPortDeveloper.clear();
        addLaunchYear.clear();
        addCoverArt.clear();
    }

    public MyLinkedList<GamePort> getAllGamePorts() {
        return allGamePorts;
    }

    public void setAllGamePorts(MyLinkedList<GamePort> allGamePorts) {
        this.allGamePorts = allGamePorts;
    }

    @FXML
    protected void clearGamePorts(){
        allGamePorts.clear();
    }

    @FXML
    protected void display(){
        display.setText(allGamePorts.display());
    }

    @FXML
    protected void switchSceneGamePortToGame(){
        ServiceApplication.switchScene2();
    }
}
