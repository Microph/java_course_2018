package ox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        //setup
        OXGame game = new OXGame();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
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
                        System.out.print(game.tableIndex(i, j) + " ");
                    }
                    System.out.print("|");
                }
                System.out.println();
            }
            System.out.println();
            
            //player play
            int row, column;
            if(game.getTurnOwner() == game.getPlayer1()) {
                System.out.print("Enter row: ");
                row = reader.nextInt();
                System.out.print("Enter column: ");
                column = reader.nextInt();
                game.playWith(game.getTurnOwner(), row, column);
            }
            else {
                MoveIndexNode move = MinMaxOX.getNextBestMove(game);
                game.playWith(game.getTurnOwner(), move.getRowIdx(), move.getColumnIdx());
                System.out.println("I play at " + move.getRowIdx() + ", " + move.getColumnIdx());
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
                    System.out.print(game.tableIndex(i, j) + " ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
    
    
}
