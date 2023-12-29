package com.example.assignment_2.controllers;

import com.example.assignment_2.ServiceApplication;
import com.example.assignment_2.models.GamesMachine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GamesMachineController {
    private MyLinkedList<GamesMachine> allGamesMachines=new MyLinkedList<>();

    @FXML
    private TextField addName,addManufacturer, addDescription, addType, addMedia, addLaunchYear, addRetailPrice, addImage;
    @FXML
    private Button display;

    @FXML
    protected void addGamesMachines(){
        String name=addName.getText();
        String manufacturer=addManufacturer.getText();
        String description=addDescription.getText();
        String type=addType.getText();
        String media=addMedia.getText();
        int launchYear=Integer.parseInt(addLaunchYear.getText());
        float retailPrice=Float.parseFloat(addRetailPrice.getText());
        String image=addImage.getText();

        GamesMachine m =new GamesMachine(name, manufacturer,description,type,media,launchYear,retailPrice,image);
        m.setName(name);
        m.setManufacturer(manufacturer);
        m.setDescription(description);
        m.setType(type);
        m.setMedia(media);
        m.setLaunchYear(launchYear);
        m.setRetailPrice(retailPrice);
        m.setImage(image);

        allGamesMachines.add(m);

        addName.clear();
        addManufacturer.clear();
        addDescription.clear();
        addType.clear();
        addMedia.clear();
        addLaunchYear.clear();
        addRetailPrice.clear();
        addImage.clear();
    }

    public MyLinkedList<GamesMachine> getAllGamesMachines() {
        return allGamesMachines;
    }

    public void setAllGamesMachines(MyLinkedList<GamesMachine> allGamesMachines) {
        this.allGamesMachines = allGamesMachines;
    }

    @FXML
    protected void clearGamesMachines(){
        allGamesMachines.clear();
    }

    @FXML
    protected void display(){
        display.setText(allGamesMachines.display());
    }

    @FXML
    protected void switchSceneGamesMachineToGame(){
        ServiceApplication.switchScene2();
    }
}
