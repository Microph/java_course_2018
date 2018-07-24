package ox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
    	System.out.print("Table dimension: ");
    	int dim = reader.nextInt();
    	System.out.print("Enter Game mode [1:PLAYER VS COM], [2:PLAYER VS PLAYER], [3:COM VS COM]: ");
    	int mode = reader.nextInt();
    	reader.close();
        OXGame game = new OXGame(dim);
        game.setGameMode(mode);
        startGame(game);
    }

    private static void startGame(OXGame game) {
        //loop
        while(game.hasMovesLeft() && game.checkStateAtPoint(game.getLastMove().getRowIdx(), game.getLastMove().getColumnIdx()) == 0) {
            //print table
            for(int i=0; i<game.getTableSize(); i++) {
                for(int j=0; j<game.getTableSize(); j++) {
                    System.out.print("|");
                    if(game.tableIndex(i, j) == "") {
                        System.out.print(" ");
                    }
                    else {
                        System.out.print(game.tableIndex(i, j));
                    }
                    System.out.print("|");
                }
                System.out.println();
            }
            System.out.println();
            
            //playing
            if(game.getTurnOwner() == game.getPlayer1()) {
            	game.getPlayer1().play(game);
            }
            else {
            	game.getPlayer2().play(game);
            }
            
        }
        
        //end
        for(int i=0; i<game.getTableSize(); i++) {
            for(int j=0; j<game.getTableSize(); j++) {
                System.out.print("|");
                if(game.tableIndex(i, j) == "") {
                    System.out.print(" ");
                }
                else {
                    System.out.print(game.tableIndex(i, j));
                }
                System.out.print("|");
            }
            System.out.println();
        }
        
        System.out.println();
        if(game.determineBoardState() == 1)
        {
        	System.out.println(game.getPlayer2().getName() + " WINS!");
        }
        else if(game.determineBoardState() == -1)
        {
        	System.out.println(game.getPlayer1().getName() + " WINS!");
        }
        else {
        	System.out.println("DRAW!");
        }
    }
    
}
