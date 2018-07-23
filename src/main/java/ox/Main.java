package ox;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        //setup
        OXGame game = new OXGame();
        
        //loop
        while(game.hasMovesLeft() && game.determineBoardState() == 0) {
            //print table
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
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
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
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
        
        if(game.determineBoardState() == 1)
        {
        	System.out.println(game.getPlayer2().getName() + " WINS");
        }
        else if(game.determineBoardState() == -1)
        {
        	System.out.println(game.getPlayer1().getName() + " WINS");
        }
        else {
        	System.out.println("DRAW");
        }
    }
    
}
