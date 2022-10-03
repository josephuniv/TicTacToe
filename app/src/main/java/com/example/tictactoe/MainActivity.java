package com.example.tictactoe;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Set;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button button00;
    private Button button01;
    private Button button02;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button20;
    private Button button21;
    private Button button22;
    private TextView textView;
    private Button buttonNew;

    private String[][] a = {{"","",""},{"","",""},{"","",""}};

    private int player = 1 ;
    private int count = 0 ;
    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);

        textView = findViewById(R.id.textView);

        buttonNew = findViewById(R.id.buttonNew);

        button00.setOnClickListener(this);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);

        buttonNew.setOnClickListener(this);

        savedValues = getPreferences(MODE_PRIVATE);

        reset();
    }

    public void onPause() {
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putString("b00", button00.getText().toString());
        editor.putString("b01", button01.getText().toString());
        editor.putString("b02", button02.getText().toString());
        editor.putString("b10", button10.getText().toString());
        editor.putString("b11", button11.getText().toString());
        editor.putString("b12", button12.getText().toString());
        editor.putString("b20", button20.getText().toString());
        editor.putString("b21", button21.getText().toString());
        editor.putString("b22", button22.getText().toString());

        editor.putString("tView", textView.getText().toString());

        editor.putInt("play", player);
        editor.putInt("counter", count);

        editor.commit();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        String b00 = savedValues.getString("b00", "");
        String b01 = savedValues.getString("b01", "");
        String b02 = savedValues.getString("b02", "");
        String b10 = savedValues.getString("b10", "");
        String b11 = savedValues.getString("b11", "");
        String b12 = savedValues.getString("b12", "");
        String b20 = savedValues.getString("b20", "");
        String b21 = savedValues.getString("b21", "");
        String b22 = savedValues.getString("b22", "");

        String tView = savedValues.getString("tView", "Player X's turn");

        button00.setText(String.valueOf(b00));
        button01.setText(String.valueOf(b01));
        button02.setText(String.valueOf(b02));
        button10.setText(String.valueOf(b10));
        button11.setText(String.valueOf(b11));
        button12.setText(String.valueOf(b12));
        button20.setText(String.valueOf(b20));
        button21.setText(String.valueOf(b21));
        button22.setText(String.valueOf(b22));

        textView.setText(String.valueOf(tView));

        player = savedValues.getInt("play", 1);
        count = savedValues.getInt("counter", 0);
    }

    public void reset() {
        button00.setText("");
        button01.setText("");
        button02.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");

        textView.setText("Player X's turn");

        count=0;
        player=1;

        int i,j;
        for(i = 0 ; i < 3 ; i++)
            for (j = 0 ; j < 3 ; j++)
                a[i][j]="";
    }

    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.buttonNew):
                reset();
                break;
            case (R.id.button00):
                if(button00.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button00.setText("X");
                        a[0][0]="X";
                    }
                    else {
                        button00.setText("O");
                        a[0][0]="O";
                    }
                    check();
                }
                break;
            case (R.id.button01):
                if(button01.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button01.setText("X");
                        a[0][1]="X";
                    }
                    else {
                        button01.setText("O");
                        a[0][1]="O";
                    }
                    check();
                }
                break;
            case (R.id.button02):
                if(button02.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button02.setText("X");
                        a[0][2]="X";
                    }
                    else {
                        button02.setText("O");
                        a[0][2]="O";
                    }
                    check();
                }
                break;
            case (R.id.button10):
                if(button10.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button10.setText("X");
                        a[1][0]="X";
                    }
                    else {
                        button10.setText("O");
                        a[1][0]="O";
                    }
                    check();
                }
                break;
            case (R.id.button11):
                if(button11.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button11.setText("X");
                        a[1][1]="X";
                    }
                    else {
                        button11.setText("O");
                        a[1][1]="O";
                    }
                    check();
                }
                break;
            case (R.id.button12):
                if(button12.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button12.setText("X");
                        a[1][2]="X";
                    }
                    else {
                        button12.setText("O");
                        a[1][2]="O";
                    }
                    check();
                }
                break;
            case (R.id.button20):
                if(button20.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button20.setText("X");
                        a[2][0]="X";
                    }
                    else {
                        button20.setText("O");
                        a[2][0]="O";
                    }
                    check();
                }
                break;
            case (R.id.button21):
                if(button21.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button21.setText("X");
                        a[2][1]="X";
                    }
                    else {
                        button21.setText("O");
                        a[2][1]="O";
                    }
                    check();
                }
                break;
            case (R.id.button22):
                if(button22.getText().toString() == "") {
                    count++;
                    if(player == 1) {
                        button22.setText("X");
                        a[2][2]="X";
                    }
                    else {
                        button22.setText("O");
                        a[2][2]="O";
                    }
                    check();
                }
                break;
        }
    }

    public void check(){
        if (win())
            if (player == 1)
                textView.setText("X wins!");
            else
                textView.setText("O wins!");
        else
        if (count == 9)
            textView.setText("Ends in a tie");
        else
        if (player == 1) {
            textView.setText("Player O's turn");
            player = 2;
        }
        else {
            textView.setText("Player X's turn");
            player = 1;
        }
    }

    public boolean win(){
        String s = (player == 1)? "X" : "O";
        int c;
        int i,j;
        for(i = 0 ; i < 3 ; i++) {
            c=0;
            for (j = 0 ; j < 3 ; j++)
                if(a[i][j]==s)
                    c++;
            if(c==3)
                return true;
        }
        for( i = 0 ; i < 3 ; i++) {
            c=0;
            for (j = 0 ; j < 3 ; j++)
                if(a[j][i]==s)
                    c++;
            if(c==3)
                return true;
        }
        c=0;
        for(i = 0 ; i < 3 ; i++) {

            for (j = 0 ; j < 3 ; j++)
                if(i==j && a[i][j]==s)
                    c++;
            if(c==3)
                return true;
        }
        c=0;
        for( i = 0 ; i < 3 ; i++) {
            for (j = 0 ; j < 3 ; j++)
                if((i+j)==(3-1)  && a[i][j]==s)
                    c++;
            if(c==3)
                return true;
        }
        return false;
    }

}