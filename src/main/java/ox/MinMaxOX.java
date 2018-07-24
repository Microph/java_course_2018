package ox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MinMaxOX {
    private static Map<String, Integer> memoized = new HashMap<String, Integer>();    
    private static Random randInt = new Random();
    
	private static List<MoveIndexNode> getAllNextPossibleMoves(OXGame game) {
        List<MoveIndexNode> nextPossibleMoves = new ArrayList<MoveIndexNode>();
        for(int i=0; i<game.getTableSize(); i++) {
            for(int j=0; j<game.getTableSize(); j++) {
                if(game.tableIndex(i, j).equals("")) {
                    MoveIndexNode newNode = new MoveIndexNode(i, j, -99);
                    nextPossibleMoves.add(newNode);
                }
            }
        }
        return nextPossibleMoves;
    }
	
    public static MoveIndexNode getNextBestMove(OXGame game, String playerSymbol) {
        //get all next possible moves
        List<MoveIndexNode> allNextPossibleMoves = getAllNextPossibleMoves(game);
        if(allNextPossibleMoves.size() == 0) {
        	return null;
        }
        
        //perform MinMax for each of them and also assign score to the node
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            moveIndexNode.setScore(performMinMax(game, moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx()));
            
            //revert the table back
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            game.getTable()[moveIndexNode.getRowIdx()][moveIndexNode.getColumnIdx()] = "";
            
            //optimize
            if(game.getTurnOwner().getPlayingSymbol() == "O" && moveIndexNode.getScore() == 1) {
                return moveIndexNode;
            }
            else if(game.getTurnOwner().getPlayingSymbol() == "X" && moveIndexNode.getScore() == -1) {
                return moveIndexNode;
            }
        }

        //if there are no 1s/-1s, then keep 0s
        List<MoveIndexNode> bestMoves = new ArrayList<MoveIndexNode>();
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            if(moveIndexNode.getScore() == 0) {
                bestMoves.add(moveIndexNode);
            }
        }
        
        //keep playing to lose
        if(bestMoves.size() == 0) {
        	bestMoves.add(getAllNextPossibleMoves(game).get(0));
        }
        
        return bestMoves.get(randInt.nextInt(bestMoves.size()));
    }

    public static int performMinMax(OXGame game, int lastMoveRow, int lastMoveCol) {
        String tableString = game.getTableString();
        if(memoized.get(tableString) != null) {
            return memoized.get(tableString);
        }
        
        int moveScore = evaluateMoveScore(game, lastMoveRow, lastMoveCol);
        if(!game.hasMovesLeft() || moveScore != 0) {
            memoized.put(tableString, moveScore);
            return moveScore;
        }
        
        List<MoveIndexNode> allNextPossibleMoves = getAllNextPossibleMoves(game);
        
        //perform MinMax for each of them and also assign score to the node
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            moveIndexNode.setScore(performMinMax(game, moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx()));
            
            //revert the table back
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            game.getTable()[moveIndexNode.getRowIdx()][moveIndexNode.getColumnIdx()] = "";
            
            //optimize
            if(game.getTurnOwner().getPlayingSymbol() == "O" && moveIndexNode.getScore() == 1) {
                memoized.put(tableString, moveIndexNode.getScore());
                return moveIndexNode.getScore();
            }
            else if(game.getTurnOwner().getPlayingSymbol() == "X" && moveIndexNode.getScore() == -1) {
                memoized.put(tableString, moveIndexNode.getScore());
                return moveIndexNode.getScore();
            }
        }
        
        //This is currently in looking ahead 1 turn, so if it's "O"'s turn then it's "X" that's thinking
        if(game.getTurnOwner().getPlayingSymbol() == "O") {
            int asBestAsYouCanGet = Integer.MIN_VALUE;
        	for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
        	    if(moveIndexNode.getScore() == 1) {
        	        memoized.put(tableString, moveIndexNode.getScore());
                    return moveIndexNode.getScore();
        	    }
        	    asBestAsYouCanGet = Math.max(asBestAsYouCanGet, moveIndexNode.getScore());
            }
        	
        	memoized.put(tableString, asBestAsYouCanGet);
        	return asBestAsYouCanGet;
        }
        else
        {
            int asBestAsYouCanGet = Integer.MAX_VALUE;
            for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
                if(moveIndexNode.getScore() == -1) {
                    memoized.put(tableString, moveIndexNode.getScore());
                    return moveIndexNode.getScore();
                }
                asBestAsYouCanGet = Math.min(asBestAsYouCanGet, moveIndexNode.getScore());
            }
            
            memoized.put(tableString, asBestAsYouCanGet);
            return asBestAsYouCanGet;
        }
    }
    
    public static int evaluateMoveScore(OXGame game, int row, int col) {
        return game.checkStateAtPoint(row, col);
    }
}
