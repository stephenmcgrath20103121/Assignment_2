package com.example.assignment_2.controllers;

import com.example.assignment_2.ServiceApplication;
import com.example.assignment_2.models.Game;
import com.example.assignment_2.models.GamePort;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GamePortController {
    private static MyLinkedList<GamePort> allGamePorts=new MyLinkedList<>();

    @FXML
    private TextField addPortedGame,addGamesMachinePortedTo, addPortDeveloper, addLaunchYear, addCoverArt, removeName, editName;
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

    public static GamePort getGamePortByName(String name) {
        MyNode<GamePort> temp =allGamePorts.head;

        while (temp != null && !temp.getContents().getPortedGame().equals(name)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static GamePort getGamePortByMachinePortedTo(String machinePortedTo) {
        MyNode<GamePort> temp =allGamePorts.head;

        while (temp != null && !temp.getContents().getGamesMachinePortedTo().equals(machinePortedTo)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static GamePort getGamePortByPortDeveloper(String portDeveloper) {
        MyNode<GamePort> temp =allGamePorts.head;

        while (temp != null && !temp.getContents().getPortDeveloper().equals(portDeveloper)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static GamePort getGamePortByLaunchYear(int launchYear) {
        MyNode<GamePort> temp =allGamePorts.head;

        while (temp != null && !(temp.getContents().getLaunchYear()==launchYear)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public static GamePort getGamePortByCoverArt(String coverArt) {
        MyNode<GamePort> temp =allGamePorts.head;

        while (temp != null && !temp.getContents().getCoverArt().equals(coverArt)) {
            temp = temp.next;
        }
        return temp == null ? null : temp.getContents();
    }

    public void setAllGamePorts(MyLinkedList<GamePort> allGamePorts) {
        this.allGamePorts = allGamePorts;
    }

    @FXML
    protected void editGamePort(){
        String nameOfPortToEdit= editName.getText();
        String portedGame= Game.class.getName();
        String gamesMachinePortedTo= addGamesMachinePortedTo.getText();
        String portDeveloper=addPortDeveloper.getText();
        int launchYear=Integer.parseInt(addLaunchYear.getText());
        String coverArt=addCoverArt.getText();

        GamePort p =getGamePortByName(nameOfPortToEdit);
        p.setPortedGame(portedGame);
        p.setGamesMachinePortedTo(gamesMachinePortedTo);
        p.setPortDeveloper(portDeveloper);
        p.setLaunchYear(launchYear);
        p.setCoverArt(coverArt);

        addPortedGame.clear();
        addGamesMachinePortedTo.clear();
        addPortDeveloper.clear();
        addLaunchYear.clear();
        addCoverArt.clear();
    }

    @FXML
    protected void removeGamePort(){
        GamePort p = getGamePortByName(removeName.getText());

        if (p != null){
            allGamePorts.remove(p);
        }
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
    public void loadGamePorts() throws Exception {
        Class<?>[] classes = new Class[] { GamePort.class };

        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(fileName()));
        allGamePorts = (MyLinkedList<GamePort>) is.readObject();
        is.close();
    }

    @FXML
    protected void saveGamePorts() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(allGamePorts);
        out.close();
    }

    public String fileName(){
        return "savedGamePorts.xml";
    }

    @FXML
    protected void switchSceneGamePortToGame(){
        ServiceApplication.switchScene2();
    }
}
