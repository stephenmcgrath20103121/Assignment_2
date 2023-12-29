package com.example.assignment_2.controllers;

import com.example.assignment_2.ServiceApplication;
import com.example.assignment_2.models.Game;
import com.example.assignment_2.models.GamesMachine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GameController {
    private MyLinkedList<Game> allGames=new MyLinkedList<>();

    @FXML
    private TextField addName,addPublisher, addDescription, addOriginalDeveloper, addOriginalGamesMachine, addLaunchYear, addCoverArt;
    @FXML
    private Button display;

    @FXML
    protected void addGames(){
        String name=addName.getText();
        String publisher=addPublisher.getText();
        String description=addDescription.getText();
        String originalDeveloper=addOriginalDeveloper.getText();
        GamesMachine originalGamesMachine=;
        int launchYear=Integer.parseInt(addLaunchYear.getText());
        String coverArt=addCoverArt.getText();

        Game g =new Game(name, publisher,description,originalDeveloper,originalGamesMachine,launchYear,coverArt);
        g.setName(name);
        g.setPublisher(publisher);
        g.setDescription(description);
        g.setOriginalDeveloper(originalDeveloper);
        g.setOriginalGamesMachine(originalGamesMachine);
        g.setLaunchYear(launchYear);
        g.setCoverArt(coverArt);

        allGames.add(g);

        addName.clear();
        addPublisher.clear();
        addDescription.clear();
        addOriginalDeveloper.clear();
        addOriginalGamesMachine.clear();
        addLaunchYear.clear();
        addCoverArt.clear();
    }

    public MyLinkedList<Game> getAllGames() {
        return allGames;
    }

    public void setAllGames(MyLinkedList<Game> allGames) {
        this.allGames = allGames;
    }

    @FXML
    protected void clearGames(){
        allGames.clear();
    }

    @FXML
    protected void display(){
        display.setText(allGames.display());
    }

    @FXML
    protected void switchSceneGameToGamesMachine(){
        ServiceApplication.switchScene1();
    }

    @FXML
    protected void switchSceneGameToGamePort(){
        ServiceApplication.switchScene3();
    }
}
