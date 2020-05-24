package com.example.tcgproject;
//import android.util.Log;

import java.util.Random;
public class Game {
    //public static final String LOG_TAG = "Main_Activity";
    Random rnd = new Random();
    public Player activePlayer;
    public Player opponentPlayer;
    public Game(int deck,int deck2,DBHelper db){
        activePlayer = new Player(20,new Card[5],new Card [3],1,1);
        opponentPlayer = new Player(20,new Card[5],new Card[3],1,1);
        generateHand(activePlayer,deck,db);
        generateHand(opponentPlayer,2,db);

    }
    public int getFieldHP(Card c1,Card c2,Card c3){
        int x,y,z;
        if (c1 != null){
            x = c1.getHP();
        }else{
            x = 0;
        }if(c2!=null){
            y = c2.getHP();
        }else{
            y = 0;
        }if(c3!=null){
            z = c3.getHP();
        }else{
            z = 0;
        }
        int g = x+y+z;
        return g;
    }
    public int getFieldAttack(Card c1,Card c2,Card c3){
        int x,y,z;
        if (c1 != null){
          x = c1.getAttack();
        }else{
            x = 0;
        }if(c2!=null){
            y = c2.getAttack();
        }else{
            y = 0;
        }if(c3!=null){
            z = c3.getAttack();
        }else{
            z = 0;
        }
        int g = x+y+z;
        return g;
    }
    public String[] getHandPic(String[] s,Player player){
        Card[] a = player.hand;
        for(int i =0;i<5;i++){
            if(a[i]!= null){
           s[i] = a[i].getPic();}
            else s[i] = null;
        }
        return s;
    }
    public int[] getHandID(int[] f,Player player){
        Card[] b = player.hand;
        for(int i = 0;i<5;i++){
            if(b[i] != null){
            f[i] = b[i].getNumber();}
            else f[i] = -1;
        }
        return f;
    }
    public void generateHand(Player player, int deck, DBHelper db) {
        switch (deck) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    int num = 1 + rnd.nextInt(20);
                   // String clog = Integer.toString(num);
                    //Log.e(LOG_TAG,"card" + clog + " " + i);
                    Card x = db.select(num);
                   // Log.e(LOG_TAG,"Card Created");
                    player.hand[i] = x;
                   // Log.e(LOG_TAG,"Got the Card");
                }
                break;
            case 2:
                for (int i = 0; i < 5; i++) {
                    int num = 21 + rnd.nextInt(20);
                    String clog = Integer.toString(num);
                   // Log.e(LOG_TAG,"card" + clog);
                    Card x = db.select(num);
                   // Log.e(LOG_TAG,"Card Created");
                    player.hand[i] = x;
                   // Log.e(LOG_TAG,"Got the Card");
                }
                break;
            case 3:
                for (int i = 0; i < 5; i++) {
                    int num = 41 + rnd.nextInt(20);
                    String clog = Integer.toString(num);
                  //  Log.e(LOG_TAG,"card" + clog);
                    Card x = db.select(num);
                   // Log.e(LOG_TAG,"Card Created");
                    player.hand[i] = x;
                   // Log.e(LOG_TAG,"Got the Card");
                }
                break;
        }

    }
public void beginTurn(){
activePlayer.ManaRefil();
opponentPlayer.ManaRefil();
}

public int getWinner(){
        if (activePlayer.getHealth() <1){
            return 2;}
            else if(opponentPlayer.getHealth() <1 ){
                return 1;
            }
            else{
                return 3;
            }
        }
    public void DrawCard(DBHelper db,int deck,Card[] a){
        Card x;
        switch (deck){
            case 1:
                int g3 = 1 + rnd.nextInt(20);
                x = db.select(g3);
                for(int i = 0;i<5;i++){
                    if(a[i] == null){
                        a[i] = x;
                    }
                }break;
            case 2:
                int g2 = 21 + rnd.nextInt(20);
                    x = db.select(g2);
                    for(int i = 0;i<5;i++){
                        if(a[i] == null){
                            a[i] = x;
                        }
                    }
                break;
            case 3: int g = 41 + rnd.nextInt(20);
                    x = db.select(g);
                    for(int i = 0;i<5;i++){
                        if(a[i] == null){
                            a[i] = x;

                    }
                }
                break;
        }}
        public int PlaceCard(Card card,Player player){
            int x = card.getCost();
            int y = player.getCurrentMana();
            int z = y - x;
        if(z>=0){return 1;}
        else return 0;
        }

}



