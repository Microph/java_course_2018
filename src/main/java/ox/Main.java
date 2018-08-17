package ox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String memoizedPath = "/OXresource/";
        String memoizedFileName = "MiniMaxMemoized"; // +[dim].ser
        
    	Scanner reader = new Scanner(System.in);
    	System.out.print("Table dimension: ");
    	int dim = reader.nextInt();
    	System.out.print("Enter Game mode [1:PLAYER VS COM], [2:PLAYER VS PLAYER], [3:COM VS COM]: ");
    	int mode = reader.nextInt();
        OXGame game = new OXGame(dim);
        game.setGameMode(mode);
        //If the game mode has AI -> try load memoized cache
        if(mode != 2) {
            String specifiedPath = memoizedPath + memoizedFileName + String.valueOf(dim) + ".ser";
            System.out.println("Loading resource from " + specifiedPath);
            try {
                FileInputStream fileIn = new FileInputStream(specifiedPath);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                MinMaxOX.memoized = (Map<String, Integer>) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Load Complete!");
             } catch(FileNotFoundException e) {
             } catch (IOException i) {
             } catch (ClassNotFoundException c) {
             } 
            
            if(MinMaxOX.memoized == null || MinMaxOX.memoized.isEmpty()) {
                System.out.println("No resource found. Generating new one at " + specifiedPath);
                MinMaxOX.memoized = new HashMap<String, Integer>();
                try {
                    File tmpNewFile = new File(specifiedPath);
                    tmpNewFile.getParentFile().mkdirs();
                    tmpNewFile.createNewFile();
                    FileOutputStream fileOut = new FileOutputStream(tmpNewFile, false);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    for(int i=0; i<dim; i++)
                    {
                        for(int j=0; j<dim; j++) {
                            MinMaxOX.performMinMax(game, i, j);
                        }
                    }
                        
                    out.writeObject(MinMaxOX.memoized);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in " + specifiedPath);
                 } catch (IOException i) {
                 }
            }
        }
        
        startGame(game);
        reader.close();
    }

    private static void startGame(OXGame game) {
        //loop
        while(game.hasMovesLeft() && game.checkStateAtPoint(game.getLastMove().getRowIdx(), game.getLastMove().getColumnIdx()) == 0) {
            //print table
            for(int i=0; i<game.getTableSize(); i++) {
                for(int j=0; j<game.getTableSize(); j++) {
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
