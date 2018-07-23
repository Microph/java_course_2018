package ox;

public class Player {
    private int score = 0;
    private String playingSymbol;
    
    public Player(String playingSymbol) {
        this.playingSymbol = playingSymbol;
    }

    public int getScore() {
        return score;
    }

    public String getPlayingSymbol() {
        return playingSymbol;
    }
}
