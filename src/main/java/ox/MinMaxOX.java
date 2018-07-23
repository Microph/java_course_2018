package ox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinMaxOX {
	private static List<MoveIndexNode> getAllNextPossibleMoves(OXGame game) {
        List<MoveIndexNode> nextPossibleMoves = new ArrayList<MoveIndexNode>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
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
            moveIndexNode.setScore(performMinMax(game));
            
            //revert the table back
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            game.getTables()[moveIndexNode.getRowIdx()][moveIndexNode.getColumnIdx()] = "";
        }
        
        //keep only the moves thats has 1/-1 score...
        List<MoveIndexNode> bestMoves = new ArrayList<MoveIndexNode>();
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            if(moveIndexNode.getScore() == (playerSymbol == "O"? 1 : -1)) {
                bestMoves.add(moveIndexNode);
            }
        }
        
        //if there are no 1s/-1s, then keep 0s
        if(bestMoves.size() == 0) {
            for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
                if(moveIndexNode.getScore() == 0) {
                    bestMoves.add(moveIndexNode);
                }
            }
        }
        
        //keep playing to lose
        if(bestMoves.size() == 0) {
        	bestMoves.add(getAllNextPossibleMoves(game).get(0));
        }
        
        //randomly return one of those moves~
        Random randInt = new Random();
        return bestMoves.get(randInt.nextInt(bestMoves.size()));
    }

    public static int performMinMax(OXGame game) {
        if(!game.hasMovesLeft() || evaluateTableScore(game) != 0) {
        	return evaluateTableScore(game);
        }
        
        //get all next possible moves
        List<MoveIndexNode> allNextPossibleMoves = getAllNextPossibleMoves(game);
        
        //perform MinMax for each of them and also assign score to the node
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            moveIndexNode.setScore(performMinMax(game));
            
            //revert the table back
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            game.getTables()[moveIndexNode.getRowIdx()][moveIndexNode.getColumnIdx()] = "";
        }

        int desireScore;
        //This is currently in looking ahead 1 turn, so if it's "O"'s turn then it's "X" that's thinking
    	if(game.getTurnOwner().getPlayingSymbol() == "O") {
    		desireScore = Integer.MIN_VALUE;
        	for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
        		desireScore = Math.max(desireScore, moveIndexNode.getScore());
            }
        	return desireScore;
        }
        else
        {
        	desireScore = Integer.MAX_VALUE;
        	for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
        		desireScore = Math.min(desireScore, moveIndexNode.getScore());
            }
            return desireScore;
        }
    }
    
    public static int evaluateTableScore(OXGame game) {
        return game.determineBoardState();
    }
}
