package com.example.demo;

public class TennisGame2 {
	private int player1Point = 0;
	private int player2Point = 0;
	private String player1Result = "";
	private String player2Result = "";

    public TennisGame2(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getScore(){
        String score = "";
        if (player1Point == player2Point && player1Point < 4)
        {
            if (player1Point==0)
                score = "Love";
            if (player1Point==1)
                score = "Fifteen";
            if (player1Point==2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Point==player2Point && player1Point>=3)
            score = "Deuce";
        
        if (player1Point > 0 && player2Point==0)
        {
            if (player1Point==1)
                player1Result = "Fifteen";
            if (player1Point==2)
                player1Result = "Thirty";
            if (player1Point==3)
                player1Result = "Forty";
            
            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        if (player2Point > 0 && player1Point==0)
        {
            if (player2Point==1)
                player2Result = "Fifteen";
            if (player2Point==2)
                player2Result = "Thirty";
            if (player2Point==3)
                player2Result = "Forty";
            
            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        
        if (player1Point>player2Point && player1Point < 4)
        {
            if (player1Point==2)
                player1Result="Thirty";
            if (player1Point==3)
                player1Result="Forty";
            if (player2Point==1)
                player2Result="Fifteen";
            if (player2Point==2)
                player2Result="Thirty";
            score = player1Result + "-" + player2Result;
        }
        if (player2Point>player1Point && player2Point < 4)
        {
            if (player2Point==2)
                player2Result="Thirty";
            if (player2Point==3)
                player2Result="Forty";
            if (player1Point==1)
                player1Result="Fifteen";
            if (player1Point==2)
                player1Result="Thirty";
            score = player1Result + "-" + player2Result;
        }
        
        if (player1Point > player2Point && player2Point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Point > player1Point && player1Point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Point>=4 && player2Point>=0 && (player1Point-player2Point)>=2)
        {
            score = "Win for player1";
        }
        if (player2Point>=4 && player1Point>=0 && (player2Point-player1Point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Point++;
    }
    
    public void P2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
