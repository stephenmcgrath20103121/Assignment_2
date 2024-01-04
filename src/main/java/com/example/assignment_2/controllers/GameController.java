package com.example.assignment_2.controllers;

import com.example.assignment_2.ServiceApplication;
import com.example.assignment_2.models.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameController {
    private static MyLinkedList<Game> allGames=new MyLinkedList<>();

    @FXML
    private TextField addName,addPublisher, addDescription, addOriginalDeveloper, addOriginalGamesMachine, addLaunchYear, addCoverArt, removeName, editName;
    @FXML
    private Button display;

    @FXML
    protected void addGames(){
        String name=addName.getText();
        String publisher=addPublisher.getText();
        String description=addDescription.getText();
        String originalDeveloper=addOriginalDeveloper.getText();
        String originalGamesMachine = addOriginalGamesMachine.getText();
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

    public static Game getGameByName(String name) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !temp.getContents().getName().equals(name)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static Game getGameByPublisher(String publisher) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !temp.getContents().getPublisher().equals(publisher)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static Game getGameByDescription(String description) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !temp.getContents().getDescription().equals(description)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static Game getGameByOriginalDeveloper(String originalDeveloper) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !temp.getContents().getOriginalDeveloper().equals(originalDeveloper)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static Game getGameByOriginalGamesMachine(String originalGamesMachine) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !temp.getContents().getOriginalGamesMachine().equals(originalGamesMachine)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static Game getGameByLaunchYear(int launchYear) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !(temp.getContents().getLaunchYear()==launchYear)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static Game getGameByCoverArt(String coverArt) {
        MyNode<Game> temp =allGames.head;

        while (temp != null && !temp.getContents().getCoverArt().equals(coverArt)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public void setAllGames(MyLinkedList<Game> allGames) {
        this.allGames = allGames;
    }

    @FXML
    protected void editGame(){
        String nameOfGameToEdit= editName.getText();
        String name=addName.getText();
        String publisher=addPublisher.getText();
        String description=addDescription.getText();
        String originalDeveloper=addOriginalDeveloper.getText();
        String originalGamesMachine = addOriginalGamesMachine.getText();
        int launchYear=Integer.parseInt(addLaunchYear.getText());
        String coverArt=addCoverArt.getText();

        Game g =getGameByName(nameOfGameToEdit);
        g.setName(name);
        g.setPublisher(publisher);
        g.setDescription(description);
        g.setOriginalDeveloper(originalDeveloper);
        g.setOriginalGamesMachine(originalGamesMachine);
        g.setLaunchYear(launchYear);
        g.setCoverArt(coverArt);

        addName.clear();
        addPublisher.clear();
        addDescription.clear();
        addOriginalDeveloper.clear();
        addOriginalGamesMachine.clear();
        addLaunchYear.clear();
        addCoverArt.clear();
    }

    @FXML
    protected void removeGame(){
        Game g = getGameByName(removeName.getText());

        if (g != null){
            allGames.remove(g);
        }
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
    public void loadGames() throws Exception {
        Class<?>[] classes = new Class[] { Game.class };

        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(fileName()));
        allGames = (MyLinkedList<Game>) is.readObject();
        is.close();
    }

    @FXML
    protected void saveGames() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(allGames);
        out.close();
    }

    public String fileName(){
        return "savedGames.xml";
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
