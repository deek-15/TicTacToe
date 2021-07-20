package com.example.tictactoe;

//import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    public Game g;
    private TextView playerName;
    private TextView finalResultDisplay;
    private Button reset;
    public boolean buttonVisible;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = new Game(this);
        playerName = (TextView)findViewById(R.id.playername);
        finalResultDisplay = (TextView)findViewById(R.id.finalResult);
        reset = (Button)findViewById(R.id.resetGame);
        reset.setVisibility(View.INVISIBLE);
        buttonVisible = false;
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);

    }
    public void tic(View v){
        if(!buttonVisible)
            g.game(v);
    }
    public void setTextbutton(Button b,char s){
        b.setText(""+s);
    }
    public void setPlayerName(char name){
        if(name == 'X')
            playerName.setText("Player "+2+":");
        else if(name == 'O')
            playerName.setText("Player "+1+":");
    }
    public void finalResult(char name){
        if(name=='X') {
            finalResultDisplay.setText("Player " + 1 + " wins!");
            playerName.setText(" ");
        }
        else if(name=='O') {
            finalResultDisplay.setText("Player " + 2 + " wins!");
            playerName.setText(" ");
        }
        reset.setVisibility(View.VISIBLE);
        buttonVisible = true;
    }
    public void noResult(){
        finalResultDisplay.setText("No Result");
        playerName.setText(" ");
        reset.setVisibility(View.VISIBLE);
        buttonVisible = true;
    }
    public void resetGame(View v){
        Button b = (Button)v;
        b.setVisibility(View.INVISIBLE);
        buttonVisible = false;
        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");
        playerName.setText("Player 1:");
        finalResultDisplay.setText(" ");
        g.newGame();

    }
}