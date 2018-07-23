package ox;

public class MoveIndexNode {
    private int rowIdx;
    private int columnIdx;
    private int score;

    public int getRowIdx() {
        return rowIdx;
    }
    public void setRowIdx(int rowIdx) {
        this.rowIdx = rowIdx;
    }
    public int getColumnIdx() {
        return columnIdx;
    }
    public void setColumnIdx(int columnIdx) {
        this.columnIdx = columnIdx;
    }
    
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    protected MoveIndexNode(int rowIdx, int columnIdx, int score) {
        super();
        this.rowIdx = rowIdx;
        this.columnIdx = columnIdx;
        this.score = score;
    }
}
