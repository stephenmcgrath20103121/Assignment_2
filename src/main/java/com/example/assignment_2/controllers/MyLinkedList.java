package com.example.assignment_2.controllers;
public class MyLinkedList<P> {
    protected MyNode<P> head=null;

    public void add(P n){
        MyNode<P> fn=new MyNode<>();
        fn.setContents(n);
        fn.next=head;
        head=fn;
    }

    public boolean remove(P n){
        MyNode<P> k=head;
        while(k.next!=null){
            if(k.next.getContents().equals(n)){
               k.next=k.next.next;
               return true;
            }
            k=k.next;
        }
        return false;
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

