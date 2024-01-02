package com.example.assignment_2.models;

public class Game {
    private String name="";
    private String publisher="";
    private String description="";
    private String originalDeveloper="";
    private String originalGamesMachine;
    private int launchYear=1970;
    private String coverArt="";

    public Game(String name, String publisher, String description, String originalDeveloper, String originalGamesMachine, int launchYear, String coverArt) {
        setName(name);
        setPublisher(publisher);
        setDescription(description);
        setOriginalDeveloper(originalDeveloper);
        setOriginalGamesMachine(originalGamesMachine);
        setLaunchYear(launchYear);
        setCoverArt(coverArt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalDeveloper() {
        return originalDeveloper;
    }

    public void setOriginalDeveloper(String originalDeveloper) {
        this.originalDeveloper = originalDeveloper;
    }

    public String getOriginalGamesMachine() {
        return originalGamesMachine;
    }

    public void setOriginalGamesMachine(String originalGamesMachine) {
        this.originalGamesMachine = originalGamesMachine;
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
        return
                "name: " + name + '\'' +
                " publisher: " + publisher + '\'' +
                " description: " + description + '\'' +
                " originalDeveloper: " + originalDeveloper + '\'' +
                " originalGamesMachine: " + originalGamesMachine +
                " launchYear: " + launchYear + '\'' +
                " coverArtURL: " + coverArt
                ;
    }
}
