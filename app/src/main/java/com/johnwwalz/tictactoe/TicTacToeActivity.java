package com.johnwwalz.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TicTacToeActivity extends AppCompatActivity {
    private TicTacToeGame game;
    private String[] dictionary = {"a","b","c","d","e","f","g","h","i"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        playGame();
        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"The game has been reset", Toast.LENGTH_LONG).show();
                playGame();
            }
        });
    }

    public void playGame(){
        game = new TicTacToeGame();
        updateUI();
    }

    public void pressButton(View button){
        String tag = button.getTag().toString();
        int boardIndex = Integer.parseInt(tag);
        game.updateGameBoardAt(boardIndex);
        updateUI();
        if(game.checkGame()){
            Toast.makeText(getApplicationContext(),game.getCurrentTurn() + " wins!", Toast.LENGTH_LONG).show();
        }
    }

    public void updateUI(){
        for(int i = 0; i < 9; i++){
            int buttonId = getResources().getIdentifier(dictionary[i], "id", "com.johnwwalz.tictactoe");
            Button button = (Button) findViewById(buttonId);
            if(game.gameBoard()[i] == "x"){
                button.setBackgroundColor(Color.parseColor("red"));
            } else if(game.gameBoard()[i] == "o"){
                button.setBackgroundColor(Color.parseColor("blue"));
            } else {
                button.setBackgroundColor(Color.parseColor("grey"));
            }
        }
    }
}
