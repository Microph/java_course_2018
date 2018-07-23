package ox;

import static org.junit.Assert.*;

import org.junit.Test;

public class OXGameTest {

    @Test
    public void newGame_has_empty_board() {
        String[][]expectedTables = generateEmptyTable();
        OXGame game = new OXGame();
        String[][] tables = game.getTables();
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
        OXGame newGame = new OXGame();
        Player player1 = newGame.getPlayer1();
        Player player2 = newGame.getPlayer2();
        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }
    
    @Test
    public void player1_starts_game_and_play_with_X_in_0_0() {
        OXGame game = new OXGame();
        game.getTables();
        Player player1 = new HumanPlayer("X");
        game.playWith(player1, 0, 0);
        assertEquals("X", game.tableIndex(0,0));
    }
    
    @Test
    public void player1_play_X_in_0_0_then_player2_play_O_in_1_0() {
        OXGame game = new OXGame();
        game.getTables();
        Player player1 = new HumanPlayer("X");
        game.playWith(player1, 0, 0);
        assertEquals("X", game.tableIndex(0,0));
        
        Player player2 = new HumanPlayer("O");
        game.playWith(player2, 1, 0);
        assertEquals("O", game.tableIndex(1,0));
    }
    
    @Test
    public void hasMovesLeftTest() {
        OXGame game = new OXGame();
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
        OXGame game = new OXGame();
        Player player1 = game.getPlayer1();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                game.playWith(player1, i, j);
            }
        }
        
        assertEquals(false, game.hasMovesLeft());
    }
}
