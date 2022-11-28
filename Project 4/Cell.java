public class Cell {
    private int row;
    private int col;
    private char status = '-';


    public Cell(int row, int col, char status) {
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char setS) {
        status = setS;
    }

    public String toString() {
        return "row: " + row + " column: " + col + " status: " + status;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
