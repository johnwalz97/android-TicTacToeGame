package com.johnwwalz.tictactoe;

/**
 * Created by john on 1/15/2016.
 */
public class TicTacToeGame {
    private String[] gameBoard2 = {"1","2","3","4","5","6","7","8","9"};
    private String currentTurn;

    public TicTacToeGame() {
        currentTurn = "Red";
    }

    public String[] gameBoard(){
        return gameBoard2;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void updateGameBoardAt(int index) {
        if(getCurrentTurn() == "Red") {
            if(gameBoard2[index -1] != "x" || gameBoard2[index -1] != "o") {
                gameBoard2[index - 1] = "x";
                currentTurn = "Blue";
            }
        } else {
            if(gameBoard2[index -1] != "x" || gameBoard2[index -1] != "o") {
                gameBoard2[index - 1] = "o";
                currentTurn = "Red";
            }
        }
    }

    public boolean checkGame() {
        for(int i = 0; i < 7; i += 3){
            if(gameBoard2[i] == "x" && gameBoard2[i + 1] == "x" && gameBoard2[i + 2] == "x"){
                currentTurn = "Red";
                return true;
            } else if(gameBoard2[i] == "o" && gameBoard2[i + 1] == "o" && gameBoard2[i + 2] == "o"){
                currentTurn = "Blue";
                return true;
            }
        }
        for(int i = 0; i < 3; i ++){
            if(gameBoard2[i] == "x" && gameBoard2[i + 3] == "x" && gameBoard2[i + 6] == "x"){
                currentTurn = "Red";
                return true;
            } else if(gameBoard2[i] == "o" && gameBoard2[i + 3] == "o" && gameBoard2[i + 6] == "o"){
                currentTurn = "Blue";
                return true;
            }
        }
        if(gameBoard2[0] == "x" && gameBoard2[4] == "x" && gameBoard2[8] == "x" || gameBoard2[2] == "x" && gameBoard2[4] == "x" && gameBoard2[6] == "x"){
            currentTurn = "Red";
            return true;
        } else if(gameBoard2[0] == "o" && gameBoard2[4] == "o" && gameBoard2[8] == "o" || gameBoard2[2] == "o" && gameBoard2[4] == "o" && gameBoard2[6] == "o"){
            currentTurn = "Blue";
            return true;
        }
        return false;
    }
}