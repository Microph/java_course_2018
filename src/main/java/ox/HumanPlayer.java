package ox;

import java.util.Scanner;

public class HumanPlayer extends Player {
	private Scanner reader;

	public HumanPlayer(String playingSymbol) {
		super(playingSymbol);
		super.setName("HUMAN");
	}

	@Override
	public void play(OXGame game) {
		reader = new Scanner(System.in);
		System.out.print("It's " + getName() + " turn!\nEnter row: ");
        int row = reader.nextInt();
        System.out.print("Enter column: ");
        int column = reader.nextInt();
        game.playWith(game.getTurnOwner(), row, column);
	}

}
