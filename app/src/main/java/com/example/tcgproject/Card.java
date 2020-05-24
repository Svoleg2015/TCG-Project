package com.example.tcgproject;

public class Card {
    public int Attack;
    public int HP;
    public int Cost;
    public int Number;
    public String Pic;
     public Card(int atck,int hp,int cost,int num,String pic){
         Attack = atck;
         HP = hp;
         Cost = cost;
         Number = num;
         Pic = pic;}


     public int getHP(){
         return this.HP; }
         public String getPic(){
         return this.Pic; }
     public int getAttack(){
         return this.Attack; }
     public int getCost(){
         return this.Cost; }
     public int getNumber(){
         return this.Number; }



}
