package com.example.tcgproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class Main3Activity extends AppCompatActivity {
    int HandPicSwitch = 1;
    int MoveP;
    int moveC;
    int resID1,resID2,resID3,resID4,resID5,resID6,resID7,resID8,resID9,resID10,field;
    Game game;
    int pa1,pa2,pa3,pa4,pa5,po1,po2,po3,po4,po5;
    int Pdeck;
    int back;
    DBHelper dbf;
    Card ac1,ac2,ac3,ac4,ac5,op1,op2,op3,op4,op5;
    ImageView opcard1,opcard2,opcard3,opcard4,opcard5,accard1,accard2,accard3,accard4,accard5,acfield1,acfield2,acfield3,opfield1,opfield2,opfield3;
    TextView turn,hp,manacost,opturn,ophp,opmanacost,ac1mana,ac2mana,ac3mana,ac4mana,ac5mana,op1mana,op2mana,op3mana,op4mana,op5mana;
    Button endturn;
    boolean[] AcCondH = {true,true,true,true,true};
    boolean[] OpCondH = {true,true,true,true,true};
    boolean[] AcCondF = {false,false,false};
    boolean[] OpCondF = {false,false,false};
    int[] AcID = new int[5];
    int[] OpID = new int[5];
    String[] AcPic = new String[5];
    String[] OpPic = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int deck = (int)getIntent().getSerializableExtra("p1deck");
        int deck2 = (int)getIntent().getSerializableExtra("p2deck");
        Pdeck = deck;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final String backCard = "back";
        dbf = new DBHelper(this);




    game = new Game(Pdeck,deck2,dbf);
        game.getHandID(AcID,game.activePlayer);
        game.getHandID(OpID,game.opponentPlayer);
        game.getHandPic(AcPic,game.activePlayer);
        game.getHandPic(OpPic,game.opponentPlayer);



        resID1 = getResources().getIdentifier(AcPic[0] , "drawable", getPackageName());
        ac1 = dbf.select(AcID[0]);
        resID2 = getResources().getIdentifier(AcPic[1] , "drawable", getPackageName());
        ac2 = dbf.select(AcID[1]);
         resID3 = getResources().getIdentifier(AcPic[2] , "drawable", getPackageName());
        ac3 = dbf.select(AcID[2]);
        resID4 = getResources().getIdentifier(AcPic[3] , "drawable", getPackageName());
        ac4 = dbf.select(AcID[3]);
        resID5 = getResources().getIdentifier(AcPic[4] , "drawable", getPackageName());
        ac5 = dbf.select(AcID[4]);
         resID6 = getResources().getIdentifier(OpPic[0] , "drawable", getPackageName());
        op1 = dbf.select(OpID[0]);
         resID7 = getResources().getIdentifier(OpPic[1] , "drawable", getPackageName());
        op2 = dbf.select(OpID[1]);
         resID8 = getResources().getIdentifier(OpPic[2] , "drawable", getPackageName());
        op3 = dbf.select(OpID[2]);
        resID9 = getResources().getIdentifier(OpPic[3] , "drawable", getPackageName());
        op4 = dbf.select(OpID[3]);
         resID10 = getResources().getIdentifier(OpPic[4] , "drawable", getPackageName());
        op5 = dbf.select(OpID[4]);
       final int resBack = getResources().getIdentifier(backCard , "drawable", getPackageName());
     back = resBack;
        field = getResources().getIdentifier("field" , "drawable", getPackageName());





turn = findViewById(R.id.turn);
hp = findViewById(R.id.hp);
manacost = findViewById(R.id.manacost);
opturn = findViewById(R.id.Opturn);
ophp = findViewById(R.id.Ophp);
opmanacost = findViewById(R.id.Opmanacost);
ac1mana = findViewById(R.id.ManaAc1);
ac2mana = findViewById(R.id.ManaAc2);
ac3mana = findViewById(R.id.ManaAc3);
ac4mana = findViewById(R.id.ManaAc4);
ac5mana = findViewById(R.id.ManaAc5);
op1mana = findViewById(R.id.ManaOp1);
op2mana = findViewById(R.id.ManaOp2);
op3mana = findViewById(R.id.ManaOp3);
op4mana = findViewById(R.id.ManaOp4);
op5mana = findViewById(R.id.ManaOp5);
        acfield1 = findViewById(R.id.field1Ac);
        acfield1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (MoveP){
                    case 1:if(pa1 == 1 && game.activePlayer.hand[0] != null){
                        AcCondF[0] = true;
                        acfield1.setImageResource(moveC);
                        accard1.setImageResource(resBack);
                    AcCondH[0] = false;
                        game.activePlayer.hand[0] = null;
                        game.activePlayer.field[0] = ac1;
                    break;}
                    else
                        break;
                    case 2:
                        if(pa2 == 1 && game.activePlayer.hand[1] != null){
                        AcCondF[0] = true;
                        acfield1.setImageResource(moveC);
                        accard2.setImageResource(resBack);
                        AcCondH[1] = false;
                        game.activePlayer.hand[1] = null;
                        game.activePlayer.field[0] = ac2;
                    break;}
                        else
                            break;
                    case 3:
                        if(pa3 == 1 && game.activePlayer.hand[2] != null){
                        AcCondF[0] = true;
                        acfield1.setImageResource(moveC);
                        accard3.setImageResource(resBack);
                        AcCondH[2] = false;
                        game.activePlayer.hand[2] = null;
                        game.activePlayer.field[0] = ac3;
                    break;}
                        else
                            break;
                    case 4:
                        if(pa4 == 1 && game.activePlayer.hand[3] != null){
                        AcCondF[0] = true;
                        acfield1.setImageResource(moveC);
                        accard4.setImageResource(resBack);
                        AcCondH[3] = false;
                        game.activePlayer.hand[3] = null;
                        game.activePlayer.field[0] = ac4;
                    break;}
                        else
                            break;
                    case 5:
                        if(pa5 == 1 && game.activePlayer.hand[4] != null){
                        AcCondF[0] = true;
                        acfield1.setImageResource(moveC);
                        accard5.setImageResource(resBack);
                        AcCondH[4] = false;
                        game.activePlayer.hand[4] = null;
                        game.activePlayer.field[0] = ac5;
                    break;}
                        else
                            break;

                }


            }
        });
        opfield1 = findViewById(R.id.field1Op);
        opfield1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (MoveP){
                    case 6:if(po1 == 1 && game.opponentPlayer.hand[0] != null){
                        opfield1.setImageResource(moveC);
                        opcard1.setImageResource(resBack);
                        game.opponentPlayer.hand[0] = null;
                        game.opponentPlayer.field[0] = op1;
                    break;}
                    else
                        break;
                    case 7:if(po2 == 1 && game.opponentPlayer.hand[1] != null){
                        opfield1.setImageResource(moveC);
                        opcard2.setImageResource(resBack);
                        game.opponentPlayer.hand[1] = null;
                        game.opponentPlayer.field[0] = op2;
                    break;}
                    else
                        break;
                    case 8:if(po3 == 1 && game.opponentPlayer.hand[2] != null){
                        opfield1.setImageResource(moveC);
                        opcard3.setImageResource(resBack);
                        game.opponentPlayer.hand[2] = null;
                        game.opponentPlayer.field[0] = op3;
                    break;}
                    else
                        break;
                    case 9:if(po4 == 1 && game.opponentPlayer.hand[3] != null){
                        opfield1.setImageResource(moveC);
                        opcard4.setImageResource(resBack);
                        game.opponentPlayer.hand[3] = null;
                        game.opponentPlayer.field[0] = op4;
                    break;}
                    else
                        break;
                    case 10:if(po5 == 1 && game.opponentPlayer.hand[4] != null){
                        opfield1.setImageResource(moveC);
                        opcard5.setImageResource(resBack);
                        game.opponentPlayer.hand[4] = null;
                        game.opponentPlayer.field[0] = op5;
                    break;}
                    else
                        break;

                }


            }
        });
        opfield2 = findViewById(R.id.field2Op);
        opfield2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (MoveP){
                    case 6:if(po1 == 1 && game.opponentPlayer.hand[0] != null){
                        OpCondF[1] = true;
                        opfield2.setImageResource(moveC);
                        opcard1.setImageResource(resBack);
                        OpCondH[0] = false;
                        game.opponentPlayer.hand[0] = null;
                        game.opponentPlayer.field[1] = op1;
                    break;}
                    else
                        break;
                    case 7:if(po2 == 1 && game.opponentPlayer.hand[1] != null){
                        OpCondF[1] = true;
                        opfield2.setImageResource(moveC);
                        opcard2.setImageResource(resBack);
                        OpCondH[1] = false;
                        game.opponentPlayer.hand[1] = null;
                        game.opponentPlayer.field[1] = op2;
                    break;}
                    else
                        break;
                    case 8:if(po3 == 1 && game.opponentPlayer.hand[2] != null){
                        OpCondF[1] = true;
                        opfield2.setImageResource(moveC);
                        opcard3.setImageResource(resBack);
                        OpCondH[2] = false;
                        game.opponentPlayer.hand[2] = null;
                        game.opponentPlayer.field[1] = op3;
                    break;}
                    else
                        break;
                    case 9:if(po4 == 1 && game.opponentPlayer.hand[3] != null){
                        OpCondF[1] = true;
                        opfield2.setImageResource(moveC);
                        opcard4.setImageResource(resBack);
                        OpCondH[3] = false;
                        game.opponentPlayer.hand[3] = null;
                        game.opponentPlayer.field[1] = op4;
                    break;}
                    else
                        break;
                    case 10:if(po5 == 1 && game.opponentPlayer.hand[4] != null){
                        OpCondF[1] = true;
                        opfield2.setImageResource(moveC);
                        opcard5.setImageResource(resBack);
                        OpCondH[4] = false;
                        game.opponentPlayer.hand[4] = null;
                        game.opponentPlayer.field[1] = op5;
                    break;}
                    else
                        break;

                }


            }
        });
        opfield3 = findViewById(R.id.field3Op);
        opfield3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (MoveP){
                    case 6:if(po1 == 1 && game.opponentPlayer.hand[0] != null){
                        OpCondF[2] = true;
                        opfield3.setImageResource(moveC);
                        opcard1.setImageResource(resBack);
                        OpCondH[0] = false;
                        game.opponentPlayer.hand[0] = null;
                        game.opponentPlayer.field[2] = op1;
                        break;}
                        else
                            break;
                    case 7:if(po2 == 1 && game.opponentPlayer.hand[1] != null){
                        OpCondF[2] = true;
                        opfield3.setImageResource(moveC);
                        opcard2.setImageResource(resBack);
                        OpCondH[1] = false;
                        game.opponentPlayer.hand[1] = null;
                        game.opponentPlayer.field[2] = op2;
                        break;}
                        else
                            break;
                    case 8:if(po3 == 1 && game.opponentPlayer.hand[2] != null){
                        OpCondF[2] = true;
                        opfield3.setImageResource(moveC);
                        opcard3.setImageResource(resBack);
                        OpCondH[2] = false;
                        game.opponentPlayer.hand[2] = null;
                        game.opponentPlayer.field[2] = op3;
                        break;}
                        else
                            break;
                    case 9:if(po4 == 1 && game.opponentPlayer.hand[3] != null){
                        OpCondF[2] = true;
                        opfield3.setImageResource(moveC);
                        opcard4.setImageResource(resBack);
                        OpCondH[3] = false;
                        game.opponentPlayer.hand[3] = null;
                        game.opponentPlayer.field[2] = op4;
                        break;}
                        else
                            break;
                    case 10:if(po5 == 1 && game.opponentPlayer.hand[4] != null){
                        opfield3.setImageResource(moveC);
                        opcard5.setImageResource(resBack);
                        game.opponentPlayer.hand[4] = null;
                        game.opponentPlayer.field[2] = op5;
                        break;}
                        else
                            break;

                }


            }
        });
        endturn = findViewById(R.id.button);
        endturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


EndTurn();}

        });
         acfield2 = findViewById(R.id.field2Ac);
         acfield2.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             switch (MoveP) {
                                                 case 1:
                                                     if(pa1 == 1 && game.activePlayer.hand[0] != null){
                                                     acfield2.setImageResource(moveC);
                                                     accard1.setImageResource(resBack);
                                                     game.activePlayer.hand[0] = null;
                                                     game.activePlayer.field[1] = ac1;
                                                     break;}
                                                     else
                                                         break;
                                                 case 2:if(pa2 == 1 && game.activePlayer.hand[1] != null){

                                                     acfield2.setImageResource(moveC);
                                                     game.activePlayer.hand[1] = null;
                                                     game.activePlayer.field[1] = ac2;
                                                     accard2.setImageResource(resBack);
                                                     break;}
                                                     else break;
                                                 case 3:
                                                     if(pa3 == 1 && game.activePlayer.hand[2] != null){
                                                     acfield2.setImageResource(moveC);
                                                     game.activePlayer.hand[2] = null;
                                                     game.activePlayer.field[1] = ac3;
                                                     accard3.setImageResource(resBack);
                                                     break;}
                                                     else
                                                         break;
                                                 case 4:
                                                     if(pa4 == 1 && game.activePlayer.hand[3] != null){
                                                     acfield2.setImageResource(moveC);
                                                     game.activePlayer.hand[3] = null;
                                                     game.activePlayer.field[1] = ac4;
                                                     accard4.setImageResource(resBack);
                                                     break;}
                                                     else
                                                         break;
                                                 case 5:
                                                     if(pa5 == 1 && game.activePlayer.hand[4] != null){
                                                     acfield2.setImageResource(moveC);
                                                     game.activePlayer.hand[4] = null;
                                                     game.activePlayer.field[1] = ac5;
                                                     accard5.setImageResource(resBack);
                                                     break;}
                                                     else
                                                         break;

                                             }
                                         }
                                     });
         acfield3 = findViewById(R.id.field3Ac);
         acfield3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 switch (MoveP) {
                     case 1:
                         if(pa1 == 1 && game.activePlayer.hand[0] != null){
                         acfield3.setImageResource(moveC);
                         game.activePlayer.hand[0] = null;
                         game.activePlayer.field[2] = ac1;
                         accard1.setImageResource(resBack);
                         break;}
                         else
                             break;
                     case 2:
                         if(pa2 == 1 && game.activePlayer.hand[1] != null){
                         acfield3.setImageResource(moveC);
                         game.activePlayer.hand[1] = null;
                         game.activePlayer.field[2] = ac2;
                         accard2.setImageResource(resBack);
                         break;}
                         else
                             break;
                     case 3:
                         if(pa3 == 1 && game.activePlayer.hand[2] != null){
                         acfield3.setImageResource(moveC);
                         game.activePlayer.hand[2] = null;
                         game.activePlayer.field[2] = ac3;
                         accard3.setImageResource(resBack);
                         break;}
                         else
                             break;
                     case 4:
                         if(pa4 == 1 && game.activePlayer.hand[3] != null){
                         acfield3.setImageResource(moveC);
                         game.activePlayer.hand[3] = null;
                         game.activePlayer.field[2] = ac4;
                         accard4.setImageResource(resBack);
                         break;}
                         else
                             break;
                     case 5:
                         if(pa5 == 1 && game.activePlayer.hand[4] != null){
                         acfield3.setImageResource(moveC);
                         game.activePlayer.hand[4] = null;
                         game.activePlayer.field[2] = ac5;
                         accard5.setImageResource(resBack);
                         break;}
                         else
                             break;

                 }
             }
         });


        opcard1 = findViewById(R.id.opCard1);
        opcard1.setImageResource(resID6);
        opcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(op1,game.opponentPlayer) == 1){
                    po1 = 1;
                    }else{
                po1 = 0;}
                moveC = resID6;
                MoveP = 6;



            }
        });
        opcard2 = findViewById(R.id.opCard2);
        opcard2.setImageResource(resID7);
        opcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(op2,game.opponentPlayer) == 1){
                    po2 = 1;
                    }else{
               po2 = 0;}
                moveC = resID7;
                MoveP = 7;

            }
        });
        opcard3 = findViewById(R.id.opCard3);
        opcard3.setImageResource(resID8);
        opcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(op3,game.opponentPlayer) == 1){
                    po3 = 1;
                    }else{
                po3 = 0;}
                moveC = resID8;
                MoveP = 8;

            }
        });
        opcard4 = findViewById(R.id.opCard4);
        opcard4.setImageResource(resID9);
        opcard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(op4,game.opponentPlayer) == 1){
                    po4 = 1;
                   }else{
                    po4 = 0;
                }
                moveC = resID9;
                MoveP = 9;
            }
        });
        opcard5 = findViewById(R.id.opCard5);
        opcard5.setImageResource(resID10);
        opcard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(op5,game.opponentPlayer) == 1){
                    po5 = 1;
                    }else{
                po5 = 0;}
                moveC = resID10;
                MoveP = 10;
            }
        });

        accard1 = findViewById(R.id.acCard1);
        accard1.setImageResource(resID1);
        accard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(game.PlaceCard(ac1,game.activePlayer) == 1){
                    pa1 = 1;
                }
                else{
                    pa1 = 0;
                }
                moveC = resID1;
                MoveP = 1;



            }
        });
        accard2 = findViewById(R.id.acCard2);
        accard2.setImageResource(resID2);
        accard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(ac2,game.activePlayer) == 1){
                    pa2 = 1;
                    }
                else{
                pa2 = 0;}
                moveC = resID2;
                MoveP = 2;


            }
        });
        accard3 = findViewById(R.id.acCard3);
        accard3.setImageResource(resID3);
        accard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(ac3,game.activePlayer) == 1){
                    pa3 = 1;
                    }
                else{
                pa3 = 0;}
                moveC = resID3;
                MoveP = 3;


            }
        });
        accard4 = findViewById(R.id.acCard4);
        accard4.setImageResource(resID4);
        accard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.PlaceCard(ac4,game.activePlayer) == 1){
                    pa4 = 1;
                   }
                else{
                pa4 = 0;}
                moveC = resID4;
                MoveP = 4;



            }
        });
        accard5 = findViewById(R.id.acCard5);
        accard5.setImageResource(resID5);
        accard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(game.PlaceCard(ac5,game.activePlayer) == 1){
                    pa5 = 1;
                }else{
                pa5 = 0;}
                moveC = resID5;
                MoveP = 5;


            }


        });
        updateCardMana();
        SwitchPlayer(HandPicSwitch);
    }
public void newturn(int Switch,TextView v,TextView g){
    int k = Switch%2;
    if(k == 0) {
        game.opponentPlayer.turn = game.opponentPlayer.turn +1;
        int x = game.opponentPlayer.getTurn();
        String l = Integer.toString(x);
        v.setText(l);
    }
    else{
        game.activePlayer.turn = game.activePlayer.turn +1;
        int x = game.activePlayer.getTurn();
        String l = Integer.toString(x);
        g.setText(l);
    }


    }
                public void Updatehp(TextView v,Player player){
        int x = player.getHealth();
        String g = Integer.toString(x);
        v.setText(g);

                }

public void EndTurn(){
        HandPicSwitch = HandPicSwitch + 1;
    AtkHpComp(field);
    CheckWinner();
    game.beginTurn();
    newturn(HandPicSwitch,opturn,turn);
    updateManacost(manacost,game.activePlayer);
    updateManacost(opmanacost,game.opponentPlayer);
    Updatehp(hp,game.activePlayer);
    Updatehp(ophp,game.opponentPlayer);
    game.DrawCard(dbf,Pdeck,game.activePlayer.hand);
    game.DrawCard(dbf,2,game.opponentPlayer.hand);
    game.getHandID(AcID,game.activePlayer);
    game.getHandID(OpID,game.opponentPlayer);
    game.getHandPic(AcPic,game.activePlayer);
    game.getHandPic(OpPic,game.opponentPlayer);
    updateCards();
  updateCardMana();
  SwitchPlayer(HandPicSwitch);
}
   public void updateCards(){
       if(AcPic[0] != null){
            resID1 = getResources().getIdentifier(AcPic[0] , "drawable", getPackageName());
            ac1 = dbf.select(AcID[0]);
           accard1.setImageResource(resID1);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           accard1.setImageResource(a);
       }
       if(AcPic[1] != null){
           resID2 = getResources().getIdentifier(AcPic[1] , "drawable", getPackageName());
           ac2 = dbf.select(AcID[1]);
           accard2.setImageResource(resID2);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           accard2.setImageResource(a);
       }
       if(AcPic[2] != null){
           resID3 = getResources().getIdentifier(AcPic[2] , "drawable", getPackageName());
           ac3 = dbf.select(AcID[2]);
           accard3.setImageResource(resID3);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           accard3.setImageResource(a);
       }
       if(AcPic[3] != null){
           resID4 = getResources().getIdentifier(AcPic[3] , "drawable", getPackageName());
           ac4 = dbf.select(AcID[3]);
           accard4.setImageResource(resID4);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           accard4.setImageResource(a);
       }
       if(AcPic[4] != null){
           resID5 = getResources().getIdentifier(AcPic[4] , "drawable", getPackageName());
           ac5 = dbf.select(AcID[4]);
           accard5.setImageResource(resID5);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           accard5.setImageResource(a);
       }
       if(OpPic[0] != null){
           resID6 = getResources().getIdentifier(OpPic[0] , "drawable", getPackageName());
           op1 = dbf.select(OpID[0]);
           opcard1.setImageResource(resID6);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           opcard1.setImageResource(a);}
       if(OpPic[1] != null){
           resID7 = getResources().getIdentifier(OpPic[1] , "drawable", getPackageName());
           op2 = dbf.select(OpID[1]);
           opcard2.setImageResource(resID7);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           opcard2.setImageResource(a);}
       if(OpPic[2] != null){
           resID8 = getResources().getIdentifier(OpPic[2] , "drawable", getPackageName());
           op3 = dbf.select(OpID[2]);
           opcard3.setImageResource(resID8);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           opcard3.setImageResource(a);}
       if(OpPic[3] != null){
           resID9 = getResources().getIdentifier(OpPic[3] , "drawable", getPackageName());
           op4 = dbf.select(OpID[3]);
           opcard4.setImageResource(resID9);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           opcard2.setImageResource(a);}
       if(OpPic[4] != null){
           resID10 = getResources().getIdentifier(OpPic[4] , "drawable", getPackageName());
           op5 = dbf.select(OpID[4]);
           opcard5.setImageResource(resID10);
       }
       else{
           int a = getResources().getIdentifier("back" , "drawable", getPackageName());
           opcard2.setImageResource(a);}



   }
        public void updateManacost(TextView v,Player player){

            int x = player.getCurrentMana();
            String k = Integer.toString(x);
                    v.setText(k);

        }
        public void updateCardMana(){
       int x = ac1.getCost();
       String g = Integer.toString(x);
       ac1mana.setText(g);
            int x1 = ac2.getCost();
            String g1 = Integer.toString(x1);
            ac2mana.setText(g1);
            int x2 = ac3.getCost();
            String g2 = Integer.toString(x2);
            ac3mana.setText(g2);
            int x3 = ac4.getCost();
            String g3 = Integer.toString(x3);
            ac4mana.setText(g3);
            int x4 = ac5.getCost();
            String g4 = Integer.toString(x4);
            ac5mana.setText(g4);
            int y = op1.getCost();
            String j = Integer.toString(y);
            op1mana.setText(j);
            int y1 = op2.getCost();
            String j1 = Integer.toString(y1);
            op2mana.setText(j1);
            int y2 = op3.getCost();
            String j2 = Integer.toString(y2);
            op3mana.setText(j2);
            int y3 = op4.getCost();
            String j3 = Integer.toString(y3);
            op4mana.setText(j3);
            int y4 = op5.getCost();
            String j4 = Integer.toString(y4);
            op5mana.setText(j4);


        }

        public void AtkHpComp(int j){
            int x = game.getFieldAttack(game.activePlayer.field[0],game.activePlayer.field[1],game.activePlayer.field[2]);
            int y = game.getFieldAttack(game.opponentPlayer.field[0],game.opponentPlayer.field[1],game.opponentPlayer.field[2]);
            int g = game.getFieldHP(game.activePlayer.field[0],game.activePlayer.field[1],game.activePlayer.field[2]);
            int f = game.getFieldHP(game.opponentPlayer.field[0],game.opponentPlayer.field[1],game.opponentPlayer.field[2]);
            int z = g - y;
            int h = f - x;
            if(z<0){
                game.activePlayer.AttackPlayer(-z);
                Arrays.fill(game.activePlayer.field,null);
                acfield1.setImageResource(j);
                acfield2.setImageResource(j);
                acfield3.setImageResource(j);}
            if(h<0){
                game.opponentPlayer.AttackPlayer(-h);
                Arrays.fill(game.opponentPlayer.field,null);
                opfield1.setImageResource(j);
                opfield2.setImageResource(j);
                opfield3.setImageResource(j);}

                }
            public void CheckWinner()
            {
              int x = game.getWinner();
              switch(x){
                  case 1:
                      Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                      i.putExtra("Winner",1);
                      startActivity(i);
                      break;
                  case 2:
                      Intent i1 = new Intent(Main3Activity.this, Main4Activity.class);
                      i1.putExtra("Winner",2);
                      startActivity(i1);
                      break;
                  case 3:
                      break;
                        }
            }
            public void SwitchPlayer(int a){
        int x = a%2;
        if(x == 0){
accard1.setImageResource(back);
accard2.setImageResource(back);
accard3.setImageResource(back);
accard4.setImageResource(back);
accard5.setImageResource(back);
        }
        else{
            opcard1.setImageResource(back);
            opcard2.setImageResource(back);
            opcard3.setImageResource(back);
            opcard4.setImageResource(back);
            opcard5.setImageResource(back);
        }


            }
}
