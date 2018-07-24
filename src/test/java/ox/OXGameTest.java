package ox;

import static org.junit.Assert.*;

import org.junit.Test;

public class OXGameTest {

    @Test
    public void newGame_has_empty_board() {
        String[][]expectedTables = generateEmptyTable();
        OXGame game = new OXGame(3);
        String[][] tables = game.getTable();
        assertArrayEquals(expectedTables, tables);
    }
    
    private String[][] generateEmptyTable(){
        String[][] tables = new String[3][3];
        for(int i=0; i<tables.length; i++) {
            for(int j=0; j<tables.length; j++) {
                tables[i][j] = "";
            }
        }
        
        return tables;
    }
    
    @Test
    public void newGame_has_two_players_and_zero_score() {
        OXGame newGame = new OXGame(3);
        Player player1 = newGame.getPlayer1();
        Player player2 = newGame.getPlayer2();
        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }
    
    @Test
    public void player1_starts_game_and_play_with_X_in_0_0() {
        OXGame game = new OXGame(3);
        game.getTable();
        Player player1 = new HumanPlayer("X");
        game.playWith(player1, 0, 0);
        assertEquals("X", game.tableIndex(0,0));
    }
    
    @Test
    public void player1_play_X_in_0_0_then_player2_play_O_in_1_0() {
        OXGame game = new OXGame(3);
        game.getTable();
        Player player1 = new HumanPlayer("X");
        game.playWith(player1, 0, 0);
        assertEquals("X", game.tableIndex(0,0));
        
        Player player2 = new HumanPlayer("O");
        game.playWith(player2, 1, 0);
        assertEquals("O", game.tableIndex(1,0));
    }
    
    @Test
    public void hasMovesLeftTest() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                game.playWith(player1, i, j);
            }
        }
        
        assertEquals(true, game.hasMovesLeft());
    }
    
    @Test
    public void hasNoMovesLeftTest() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                game.playWith(player1, i, j);
            }
        }
        
        assertEquals(false, game.hasMovesLeft());
    }
    
    @Test
    public void checkHorizontallyTest() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        /*
        check at [0,0]
        |X|| || |
        | || || |
        | || || |
        
        |X||X|| |
        | || || |
        | || || |
        
        |X||X||X|
        | || || |
        | || || |
        
        |X||O||X|
        | || || |
        | || || |
        */
        game.playWith(player1, 0, 0);
        assertEquals(1, game.checkHorizontally(0, 0));
        
        game.playWith(player1, 0, 1);
        assertEquals(2, game.checkHorizontally(0, 0));
        
        game.playWith(player1, 0, 2);
        assertEquals(3, game.checkHorizontally(0, 0));
        
        game.playWith(player2, 0, 1);
        assertEquals(1, game.checkHorizontally(0, 0));
        
        //randomly check
        assertEquals(0, game.checkHorizontally(1, 1));
    }
    
    @Test
    public void checkVerticallyTest() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        /*
        check at [0,0]
        |X|| || |
        | || || |
        | || || |
        
        |X|| || |
        |X|| || |
        | || || |
        
        |X|| || |
        |X|| || |
        |X|| || |
        
        |X|| || |
        |O|| || |
        |X|| || |
        */
        game.playWith(player1, 0, 0);
        assertEquals(1, game.checkVertically(0, 0));
        
        game.playWith(player1, 1, 0);
        assertEquals(2, game.checkVertically(0, 0));
        
        game.playWith(player1, 2, 0);
        assertEquals(3, game.checkVertically(0, 0));
        
        game.playWith(player2, 1, 0);
        assertEquals(1, game.checkVertically(0, 0));
        
        //randomly check
        assertEquals(0, game.checkVertically(1, 1));
    }
    
    @Test
    public void checkDiagonally_BackSlashTest() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        /*
        check at [0,0]
        |X|| || |
        | || || |
        | || || |
        
        |X|| || |
        | ||X|| |
        | || || |
        
        |X|| || |
        | ||X|| |
        | || ||X|
        
        |X|| || |
        | ||O|| |
        | || ||X|
        */
        game.playWith(player1, 0, 0);
        assertEquals(1, game.checkDiagonally_BackSlash(0, 0));
        
        game.playWith(player1, 1, 1);
        assertEquals(2, game.checkDiagonally_BackSlash(0, 0));
        
        game.playWith(player1, 2, 2);
        assertEquals(3, game.checkDiagonally_BackSlash(0, 0));
        
        game.playWith(player2, 1, 1);
        assertEquals(1, game.checkDiagonally_BackSlash(0, 0));
        
        //randomly check
        assertEquals(0, game.checkDiagonally_BackSlash(1, 0));
    }
    
    @Test
    public void checkDiagonally_SlashTest() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        /*
        check at [0,2]
        | || ||X|
        | || || |
        | || || |
        
        | || ||X|
        | ||X|| |
        | || || |
        
        | || ||X|
        | ||X|| |
        |X|| || |
        
        | || ||X|
        | ||O|| |
        |X|| || |
        */
        game.playWith(player1, 0, 2);
        assertEquals(1, game.checkDiagonally_Slash(0, 2));
        
        game.playWith(player1, 1, 1);
        assertEquals(2, game.checkDiagonally_Slash(0, 2));
        
        game.playWith(player1, 2, 0);
        assertEquals(3, game.checkDiagonally_Slash(0, 2));
        
        game.playWith(player2, 1, 1);
        assertEquals(1, game.checkDiagonally_Slash(0, 2));
        
        //randomly check
        assertEquals(0, game.checkDiagonally_Slash(1, 0));
    }
    
    @Test
    public void checkDebug() {
        OXGame game = new OXGame(3);
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        /*
            |O||O||X|
            | ||X|| |
            | || ||X|
        */
        
        game.playWith(player1, 0, 2);
        game.playWith(player1, 1, 1);
        game.playWith(player1, 2, 2);
        
        game.playWith(player2, 0, 0);
        game.playWith(player2, 0, 1);
        
        assertEquals(2, game.checkDiagonally_BackSlash(1, 1));
        assertEquals(2, game.checkDiagonally_Slash(1, 1));
        assertEquals(0, game.checkVertically(1, 2));
        
        assertEquals(0, game.checkStateAtPoint(0, 0));
        assertEquals(0, game.checkStateAtPoint(0, 1));
        
        assertEquals(2, game.checkDiagonally_Slash(0, 2));
        assertEquals(0, game.checkStateAtPoint(0, 2));
        
        assertEquals(0, game.checkStateAtPoint(1, 0));
        assertEquals(0, game.checkStateAtPoint(1, 1));
        assertEquals(0, game.checkStateAtPoint(1, 2));
        assertEquals(0, game.checkStateAtPoint(2, 0));
        assertEquals(0, game.checkStateAtPoint(2, 1));
        assertEquals(0, game.checkStateAtPoint(2, 2));
        
        assertEquals(0, game.determineBoardState());
    }
}
