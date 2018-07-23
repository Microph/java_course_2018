package ox;

public class ComputerPlayer extends Player {

	public ComputerPlayer(String playingSymbol) {
		super(playingSymbol);
		super.setName("COMPUTER");
	}

	@Override
	public void play(OXGame game) {
		MoveIndexNode move = MinMaxOX.getNextBestMove(game, getPlayingSymbol());
        if(move != null){
        	game.playWith(game.getTurnOwner(), move.getRowIdx(), move.getColumnIdx());
            System.out.println(getName() + ": I play at [" + move.getRowIdx() + ", " + move.getColumnIdx() + "]");
        }
        else {
        	System.out.println("NO MORE MOVES TO MAKE");
        }
	}

}
