package com.example.tcgproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

public class DBHelper {
    //public static final String LOG_TAG = "Main_Activity";
    public static  final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "cards1.db";
    public static final String TABLE_CONTACTS = "contacts";
    public static final String KEY_ID = "id";
    public static final String KEY_ATTACK ="attack";
    public static final String KEY_HP = "hp";
    public static final String KEY_COST = "cost";
    public static final String KEY_CARDPIC = "picture";
    private static final int NUM_KEY_ATTACK = 1;
    private static final int NUM_KEY_HP = 2;
    private static final int NUM_KEY_COST = 3;
    private static final int NUM_KEY_CARDPIC = 4;
    private SQLiteDatabase mDataBase;


    public DBHelper(Context context){
        OpenHelper mOpenHelper = new OpenHelper(context);
    mDataBase = mOpenHelper.getWritableDatabase();}
    public Card select(int id){
        Cursor mCursor = mDataBase.query(TABLE_CONTACTS, null, KEY_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        mCursor.moveToFirst();
        int atck = mCursor.getInt(NUM_KEY_ATTACK);
       // String clog = Integer.toString(atck);
        //Log.e(LOG_TAG,"Attack:" +clog);
        int hp = mCursor.getInt(NUM_KEY_HP);
        //String clog1 = Integer.toString(hp);
       // Log.e(LOG_TAG,"HP:"+ clog1);
        int cost = mCursor.getInt(NUM_KEY_COST);
       // String clog2 = Integer.toString(cost);
       // Log.e(LOG_TAG,"Cost:" + clog2);
        String pic = mCursor.getString(NUM_KEY_CARDPIC);
       // Log.e(LOG_TAG,"Picture:"+ pic);
        return new Card(atck, hp, cost, id,pic); }
    private class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public int atck[] = new int[]{2,1,3,7,3,8,5,2,3,6,2,4,2,2,1,6,2,1,1,2,2,1,3,7,3,8,5,2,3,6,2,4,2,2,1,6,2,1,1,2,2,1,3,7,3,8,5,2,3,6,2,4,2,2,1,6,2,1,1,2};
        public int hp[] = new int[]{2,1,3,7,3,7,5,1,2,4,3,3,1,1,5,6,3,2,2,3,2,1,3,7,3,7,5,1,2,4,3,3,1,1,5,6,3,2,2,3,2,1,3,7,3,7,5,1,2,4,3,3,1,1,5,6,3,2,2,3};
        public int id[] = new int []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
        public int cost[] = new int[]{1,0,2,6,2,6,6,2,4,6,3,5,3,2,3,6,4,2,1,3,1,0,2,6,2,6,6,2,4,6,3,5,3,2,3,6,4,2,1,3,1,0,2,6,2,6,6,2,4,6,3,5,3,2,3,6,4,2,1,3};
        public String pic[] = new String[]{"c01","c02","c03","c04","c05","c06","c07","c08","c09","c10","c11","c12","c13","c14","c15","c16","c17","c18","c19","c20","c21","c22","c23","c24","c25","c26","c27","c28","c29","c30","c31","c32","c33","c34","c35","c36","c37","c38","c39","c40","c41","c42","c43","c44","c45","c46","c47","c48","c49","c50","c51","c52","c53","c54","c55","c56","c57","c58","c59","c60"};
        @Override
            public void onCreate(SQLiteDatabase db) {
                String query = ("create table " + TABLE_CONTACTS + "(" + KEY_ID
                        + " integer primary key," + KEY_ATTACK + "  integer, " + KEY_HP + " integer, "+ KEY_COST + " integer, " + KEY_CARDPIC + " text " +")");
            db.execSQL(query);
            insert(db,id,atck,hp,cost,pic);
        }
        public void insert(SQLiteDatabase db,int id[],int atck[],int hp[],int cost[],String pict[]){
            for(int i = 0;i<60;i++) {
                ContentValues cv = new ContentValues();
                cv.put(KEY_ID, id[i]);
                cv.put(KEY_ATTACK, atck[i]);
                cv.put(KEY_HP, hp[i]);
                cv.put(KEY_COST, cost[i]);
                cv.put(KEY_CARDPIC, pict[i]);
                db.insert(TABLE_CONTACTS, null, cv);}}

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            onCreate(db);
        }
    }}



