package com.example.assignment_2.controllers;
public class MyLinkedList<P> {
    private MyNode<P> head=null;

    public void add(P n){
        MyNode<P> fn=new MyNode<>();
        fn.setContents(n);
        fn.next=head;
        head=fn;
    }

    public void remove(P n){
        MyNode<P> k=head;
        while(k!=n){
            k=k.next;
        }
    }

    public void clear(){head=null;}

    public String display(){
        String list="";
        MyNode<P> k=head;
        while(k!=null){
            list += k.getContents() + "\n";
            k=k.next;
        }
        return list;
    }

    public P find(String n){
        MyNode<P> k=head;
        while(k!=null){
            if(k.getContents().toString().contains(n)){
                return k.getContents();
            }
            k=k.next;
        }
        return null;
    }
}

