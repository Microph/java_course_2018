package ox;

public abstract class Player{
    private int score = 0;
    private String playingSymbol;
    private String name;
    
    public Player(String playingSymbol) {
        this.playingSymbol = playingSymbol;
    }

    public int getScore() {
        return score;
    }

    public String getPlayingSymbol() {
        return playingSymbol;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public abstract void play(OXGame game);
}
