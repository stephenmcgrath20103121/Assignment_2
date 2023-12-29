package com.example.assignment_2.models;

import com.example.assignment_2.controllers.GameController;

public class GamePort {
    private Game portedGame;
    private GamesMachine gamesMachinePortedTo;
    private String portDeveloper="";
    private int launchYear=1970;
    private String coverArt="";

    public GamePort(Game portedGame, GamesMachine gamesMachinePortedTo, String portDeveloper, int launchYear, String coverArt) {
        setPortedGame(portedGame);
        setGamesMachinePortedTo(gamesMachinePortedTo);
        setPortDeveloper(portDeveloper);
        setLaunchYear(launchYear);
        setCoverArt(coverArt);
    }

    public Game getPortedGame() {
        return portedGame;
    }
    public String getPortedGameByName(String name){
        if(GameController.){

        }else{
            return "Game not in System"
        }
    }

    public void setPortedGame(Game portedGame) {
        this.portedGame = portedGame;
    }

    public GamesMachine getGamesMachinePortedTo() {
        return gamesMachinePortedTo;
    }

    public void setGamesMachinePortedTo(GamesMachine gamesMachinePortedTo) {
        this.gamesMachinePortedTo = gamesMachinePortedTo;
    }

    public String getPortDeveloper() {
        return portDeveloper;
    }

    public void setPortDeveloper(String portDeveloper) {
        this.portDeveloper = portDeveloper;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    @Override
    public String toString() {
        return "GamePort{" +
                "portedGame=" + portedGame +
                ", gamesMachinePortedTo=" + gamesMachinePortedTo +
                ", portDeveloper='" + portDeveloper + '\'' +
                ", launchYear=" + launchYear +
                ", coverArt='" + coverArt + '\'' +
                '}';
    }
}
