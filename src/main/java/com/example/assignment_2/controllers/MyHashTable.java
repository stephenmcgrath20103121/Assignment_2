package com.example.assignment_2.controllers;

//created using aid from https://aaronice.gitbook.io/lintcode/hash-table/design-hashmap

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable {

    private final int MAXLength = 10000; //amount of buckets
    private List<Pair<Integer, Integer>>[] map; //hash map implementation


    //returns given bucket index
    private int getIndex(int key){
        return key % MAXLength;
    }

    //search key in bucket
    private int getPos(int key, int index){
        //each bucket holds a list
        List<Pair<Integer, Integer>> temp=map[index];
        if (temp == null){
            return -1;
        }
        //iterating all elements in bucket for searching target key
        for (int i=0;i<temp.size();i++){
            if (temp.get(i).getKey() == key){
                return i;
            }
        }
        return -1;
    }

    // initializing data structure
    public MyHashTable(){
        map=(List<Pair<Integer, Integer>>[]) new ArrayList[MAXLength];
    }

    public void putHMap(int key, int value){
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos<0){
            //adding pair if key doesn't exist
            if (map[index] == null){
                map[index] = new ArrayList<Pair<Integer, Integer>>();
            }
            map[index].add(new Pair(key,value));
        } else{
            // value updated if exists
            map[index].set(pos, new Pair(key, value));
        }
    }
    // Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    public int getHMap(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            return -1;
        } else {
            return map[index].get(pos).getValue();
        }
    }

    //removes mapping to specified value key if it already exists
    public void removeHMap(int key){
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos>=0){
            map[index].remove(pos);
        }
    }
}

/*
    * **ADDITIONAL NOTES FROM AID**
    * Your MyHashMap(MYHashTable) object will be instantiated and called as such:
    * MyHashTable obj = new MyHashTable();
    * obj.put(key,value);
    * int param_2 = obj.get(key);
    * obj.remove(key);
    *
*/
