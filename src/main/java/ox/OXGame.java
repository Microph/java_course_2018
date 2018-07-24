package ox;

import java.util.Random;

public class OXGame {
    private String[][] tables;
    private Player player1, player2;
    private Player turnOwner;
    private int tableSize;
    private MoveIndexNode lastMove;

    public OXGame(int tableSize) {
        this.tableSize = tableSize;
        tables = new String[tableSize][tableSize];
        for(int i=0; i<tableSize; i++) {
            for(int j=0; j<tableSize; j++) {
                tables[i][j] = "";
            }
        }

        int computerPlayerOrder = new Random().nextInt(2);
        if(computerPlayerOrder == 1){
            player1 = new HumanPlayer("X");
            player2 = new ComputerPlayer("O");
        }
        else {
        	player1 = new ComputerPlayer("X");
            player2 = new HumanPlayer("O");
        }
        
        turnOwner = player1;
        lastMove = new MoveIndexNode(0, 0, 0);
    }

    public String[][] getTable() {
        return tables;
    }
    
    public String tableIndex(int i, int j) {
        return tables[i][j];
    }
    
    public int getTableSize() {
        return tableSize;
    }
    
    public String getTableString() {
        String out = "";
        for(int i=0; i<tableSize; i++) {
            for(int j=0; j<tableSize; j++) {
                out += tableIndex(i, j) == ""? "-" : tableIndex(i, j);
            }
        }
        
        return out;
    }

    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
    
    public Player getTurnOwner() {
        return turnOwner;
    }
    
    public MoveIndexNode getLastMove() {
        return lastMove;
    }

    public void playWith(Player player, int i, int j) {
        tables[i][j] = player.getPlayingSymbol();
        lastMove = new MoveIndexNode(i, j, 0);
        if(player == player1) {
            turnOwner = player2;
        }
        else {
            turnOwner = player1;
        }
    }
    
    public boolean hasMovesLeft() {
        for(int i=0; i<tableSize; i++) {
            for(int j=0; j<tableSize; j++) {
                if(tableIndex(i, j).equals("")) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public int determineBoardState() {
        for(int i=0; i<tableSize; i++) {
            for(int j=0;j<tableSize; j++) {
                int outcome = checkStateAtPoint(i, j);
                if(outcome != 0) {
                    return outcome;
                }
            }
        }
        
        return 0;
    }
    
    //1:    O WIN
    //0:    DRAW
    //-1:   O LOSE
    public int checkStateAtPoint(int row, int col) {
        if(checkVertically(row, col) == tableSize) {
            return tableIndex(row, col).equals("O")? 1 : -1;
        }
        if(checkHorizontally(row, col) == tableSize) {
            return tableIndex(row, col).equals("O")? 1 : -1;
        }
        if(checkDiagonally_BackSlash(row, col) == tableSize) {
            return tableIndex(row, col).equals("O")? 1 : -1;
        }
        if(checkDiagonally_Slash(row, col) == tableSize) {
            return tableIndex(row, col).equals("O")? 1 : -1;
        }
                
        return 0;
    }

    public int checkVertically(int row, int col) {
        String symbolToCheck = tableIndex(row, col);
        if(symbolToCheck.equals("")) {
            return 0;
        }
        
        int sameSymbols = 1;
        //loop go up
        for(int i=row-1; i>=0; i--) {
            if(tableIndex(i, col) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }
        
        //loop go down
        for(int i=row+1; i<getTableSize(); i++) {
            if(tableIndex(i, col) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }

        return sameSymbols;
    }
    
    public int checkHorizontally(int row, int col) {
        String symbolToCheck = tableIndex(row, col);
        if(symbolToCheck.equals("")) {
            return 0;
        }
        
        int sameSymbols = 1;
        //loop go left
        for(int i=col-1; i>=0; i--) {
            if(tableIndex(row, i) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }
        
        //loop go right
        for(int i=col+1; i<getTableSize(); i++) {
            if(tableIndex(row, i) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }

        return sameSymbols;
    }
    
    // "\"
    public int checkDiagonally_BackSlash(int row, int col) {
        String symbolToCheck = tableIndex(row, col);
        if(symbolToCheck.equals("")) {
            return 0;
        }
        
        int sameSymbols = 1;
        //loop go up-left
        for(int i=1; Math.min(row-i, col-i)>=0; i++) {
            if(tableIndex(row-i, col-i) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }
        
        //loop go down-right
        for(int i=1; Math.max(row+i, col+i)<tableSize; i++) {
            if(tableIndex(row+i, col+i) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }

        return sameSymbols;
    }

    // "/"
    public int checkDiagonally_Slash(int row, int col) {
        String symbolToCheck = tableIndex(row, col);
        if(symbolToCheck.equals("")) {
            return 0;
        }
        
        int sameSymbols = 1;
        //loop go up-right
        for(int i=1; row-i>=0 && col+i<tableSize; i++) {
            if(tableIndex(row-i, col+i) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }
        
        //loop go down-left
        for(int i=1; row+i<tableSize && col-i>=0; i++) {
            if(tableIndex(row+i, col-i) == symbolToCheck) {
                sameSymbols++;
            }
            else {
                break;
            }
        }

        return sameSymbols;
    }

}
