public class BattleBoats {
    private int size;
    private boolean orientation;
    private Cell[] spaces;

    public void setOrientation(boolean orien) {
        orientation = orien;
    }

    public boolean getOrientation() {
        return orientation;
    }

    public Cell[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Cell[] cells) {
        spaces = cells;
    }

    public int getSize() {
        return size;
    }

    public BattleBoats(int length) {
        size = length;
        spaces = new Cell[length];
    }

}
