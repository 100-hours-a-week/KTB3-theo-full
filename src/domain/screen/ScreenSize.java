package domain.screen;

public enum ScreenSize {
    IMAX(5, 5), TWOD(3, 3);

    private int row;
    private int col;

    ScreenSize(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
