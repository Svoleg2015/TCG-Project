package com.example.tcgproject;

import java.util.Random;

public class Player {
    public Player(int HP,Card hand[],Card field[],int turn,int mana){
        this.health = HP;
       this.hand = hand;
       this.CurrentMana = mana;
        this.field = field;
    this.turn = turn;}
    public int CurrentMana = 0;
    public int health = 20;
    public int turn = 0;
    public Card hand[];
    public Card field[];

    public int getCurrentMana(){
        return this.CurrentMana;
    }
    public void ManaRefil(){
        CurrentMana = CurrentMana + 1;
    }


    public int getHealth(){
        return this.health;
    }
    public int getTurn(){
        return this.turn;
    }
    public void AttackPlayer(int z ){
        int x =health;
        int g = x - z;
        health = g;
    }


    }

