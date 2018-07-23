package ox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinMaxOX {
    public MoveIndexNode getNextBestMove(OXGame game) {
        //get all next possible moves
        List<MoveIndexNode> allNextPossibleMoves = getAllNextPossibleMoves(game);
        
        //perform Minmax for each of them and also assign score to the node
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            moveIndexNode.setScore(performMinMax(game));
            
            //revert the table back
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            game.getTables()[moveIndexNode.getRowIdx()][moveIndexNode.getColumnIdx()] = "";
        }
        
        //keep only the moves thats has 1 score, but if there are no 1 -> keep 0
        List<MoveIndexNode> bestMoves = new ArrayList<MoveIndexNode>();
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            if(moveIndexNode.getScore() == 1) {
                bestMoves.add(moveIndexNode);
            }
        }
        if(bestMoves.size() == 0) {
            for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
                if(moveIndexNode.getScore() == 0) {
                    bestMoves.add(moveIndexNode);
                }
            }
        }
        
        //randomly return one of those
        Random randInt = new Random();
        return bestMoves.get(randInt.nextInt(bestMoves.size() - 1));
    }
    
    private List<MoveIndexNode> getAllNextPossibleMoves(OXGame game) {
        List<MoveIndexNode> nextPossibleMoves = new ArrayList<MoveIndexNode>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(game.tableIndex(i, j).equals("")) {
                    MoveIndexNode newNode = new MoveIndexNode(i, j, Integer.MIN_VALUE);
                    nextPossibleMoves.add(newNode);
                }
            }
        }
        return nextPossibleMoves;
    }

    public int performMinMax(OXGame game) {
        if(!game.hasMovesLeft()) {
            return evaluateTableScore(game);
        }
        
        //get all next possible moves
        List<MoveIndexNode> allNextPossibleMoves = getAllNextPossibleMoves(game);
        
        //perform Minmax for each of them and also assign score to the node
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            moveIndexNode.setScore(performMinMax(game));
            
            //revert the table back
            game.playWith(game.getTurnOwner(), moveIndexNode.getRowIdx(), moveIndexNode.getColumnIdx());
            game.getTables()[moveIndexNode.getRowIdx()][moveIndexNode.getColumnIdx()] = "";
        }
        
        int maxScore = Integer.MIN_VALUE;
        for (MoveIndexNode moveIndexNode : allNextPossibleMoves) {
            maxScore = (moveIndexNode.getScore() > maxScore)? moveIndexNode.getScore() : maxScore;
        }
        
        return maxScore;
    }
    
    public int evaluateTableScore(OXGame game) {
        int boardState = game.determineBoardState();
        if(game.getTurnOwner().getPlayingSymbol() == "X") {
            return boardState;
        }
        else
        {
            return -boardState;
        }
    }
}
