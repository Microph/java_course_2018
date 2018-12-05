package ox;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
    	System.out.print("Enter Game mode [1:PLAYER VS COM], [2:PLAYER VS PLAYER], [3:COM VS COM]: ");
    	int mode = reader.nextInt();
        OXGame game = new OXGame(3);
        game.setGameMode(mode);
        try {
			startGame(game);
		} catch (IOException e) {
			e.printStackTrace();
		}
        reader.close();
    }

    private static void startGame(OXGame game) throws IOException {
        //loop
        while(game.hasMovesLeft() && game.checkStateAtPoint(game.getLastMove().getRowIdx(), game.getLastMove().getColumnIdx()) == 0) {
            printTable(game);
            if(game.getTurnOwner() == game.getPlayer1()) {
            	game.getPlayer1().play(game);
            }
            else {
            	game.getPlayer2().play(game);
            }
            
        }
        
        printTable(game);
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
        
        System.in.read();
    }

	private static void printTable(OXGame game) {
		System.out.print("  0  1  2\n");
		for(int i=0; i<game.getTableSize(); i++) {
		    for(int j=0; j<game.getTableSize(); j++) {
		    	if(j==0) {
		    		System.out.print(i);
		    	}
		        System.out.print("[");
		        if(game.tableIndex(i, j) == "") {
		            System.out.print(" ");
		        }
		        else {
		            System.out.print(game.tableIndex(i, j));
		        }
		        System.out.print("]");
		    }
		    System.out.println();
		}
		System.out.println();
	}
    
}
