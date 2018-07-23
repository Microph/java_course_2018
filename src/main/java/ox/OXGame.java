package ox;

public class OXGame {
    private String[][] tables;
    private Player player1, player2;
    private Player turnOwner;

    public OXGame() {
        tables = new String[3][3];
        for(int i=0; i<tables.length; i++) {
            for(int j=0; j<tables.length; j++) {
                tables[i][j] = "";
            }
        }
        
        player1 = new Player("X");
        player2 = new Player("O");
        turnOwner = player1;
    }

    public String[][] getTables() {
        return tables;
    }
    
    public String tableIndex(int i, int j) {
        return tables[i][j];
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

    public void playWith(Player player1, int i, int j) {
        tables[i][j] = player1.getPlayingSymbol();
        turnOwner = (turnOwner == player1) ? player2: player1;
    }
    
    public boolean hasMovesLeft() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(tableIndex(i, j).equals("")) {
                    return true;
                }
            }
        }
        
        return false;
    }

    //-1:   O LOSE
    //0:    DRAW
    //1:    O WIN
    public int determineBoardState() {
        //Cross Check
        if((tableIndex(0, 0).equals("X") && tableIndex(1, 1).equals("X") && tableIndex(2, 2).equals("X")) ||
           (tableIndex(0, 2).equals("X") && tableIndex(1, 1).equals("X") && tableIndex(2, 0).equals("X"))) {
            return 1;
        }
        else if((tableIndex(0, 0).equals("O") && tableIndex(1, 1).equals("O") && tableIndex(2, 2).equals("O")) ||
           (tableIndex(0, 2).equals("O") && tableIndex(1, 1).equals("O") && tableIndex(2, 0).equals("O"))) {
            return -1;
        }
        
        int _XCounter = 0, _OCounter = 0;
        
        //Horizontal Check
        for(int i=0; i<3; i++) {
            _OCounter = 0;
            _XCounter = 0;
            for(int j=0; j<3; j++) {
                if(tableIndex(i, j).equals("X")) {
                    _XCounter++; 
                }
                else {
                    _OCounter++;
                }
            }
            
            if(_OCounter == 3) {
                return -1;
            }
            else if(_XCounter == 3) {
                return 1;
            }
        }
        
        //Vertical Check
        for(int i=0; i<3; i++) {
            _OCounter = 0;
            _XCounter = 0;
            for(int j=0; j<3; j++) {
                if(tableIndex(j, i).equals("X")) {
                    _XCounter++; 
                }
                else {
                    _OCounter++;
                }
            }
            
            if(_OCounter == 3) {
                return -1;
            }
            else if(_XCounter == 3) {
                return 1;
            }
        }
        
        return 0;
    }
    
}
