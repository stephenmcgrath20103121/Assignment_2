package com.example.assignment_2.controllers;

public class MyNode<P> {
    public MyNode<P> next=null;
    private P contents;

    public P getContents(){
        return contents;
    }

    public void setContents(P contents){
        this.contents=contents;
    }
}
