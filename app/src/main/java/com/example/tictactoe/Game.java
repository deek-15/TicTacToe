package com.example.tictactoe;

import android.view.View;
import android.widget.Button;

public class Game {
    public static char[] a = new char[9];
    public static int count = 0;
    MainActivity mout;
    public Game(MainActivity out){
        mout=out;
    }

    public void game(View v){
        Button b = (Button)v;
        String tag = b.getTag().toString();
        char name = getPlayer();
        String text = b.getText().toString();
        verify(text,b,name);
        if(playerWon(name)){
            mout.finalResult(name);
        }
        else if(count==9){
            mout.noResult();
        }
    }

    public char getPlayer(){
        if(count%2==0)
            return 'X';
        else
            return 'O';
    }

    public void verify(String text, Button b, char name){
        if(text.equals(" ")){
            count++;
            updateValues(b,name);
            mout.setTextbutton(b,name);
            mout.setPlayerName(name);
        }
    }

    public void updateValues(Button b, char name){
        String tag = b.getTag().toString();
        int i = Integer.parseInt(tag);
        a[i-1] = name;
    }
    public boolean playerWon(char name){
        if(a[0]==name && a[1]==name && a[2]==name)
            return true;
        else if(a[3]==name && a[4]==name && a[5]==name)
            return true;
        else if(a[6]==name && a[7]==name && a[8]==name)
            return true;
        else if(a[0]==name && a[3]==name && a[6]==name)
            return true;
        else if(a[1]==name && a[4]==name && a[7]==name)
            return true;
        else if(a[2]==name && a[5]==name && a[8]==name)
            return true;
        else if(a[0]==name && a[4]==name && a[8]==name)
            return true;
        else if(a[2]==name && a[4]==name && a[6]==name)
            return true;
        else
            return false;
    }

    public void newGame(){
        count = 0;
        for(int i=0;i<9;i++){
            a[i] = ' ';
        }
    }
}
