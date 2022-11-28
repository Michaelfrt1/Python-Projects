

import java.util.Scanner;

public class Board {
    private int numBoats;
    private BattleBoats[] boats;
    private Cell[][] board;
    private int[] boatSizes;
    private int minTurns = 0;
    private int hitCount = 0;

    private char[][] check;


    public void placeBoatsHelper(int i) {

        int size = boats[i].getSize();
        int row = (int) (Math.floor(Math.random() * board.length));
        int columns = (int) (Math.floor(Math.random() * board.length));
// generate random position for the first cell of the boat
        int ran = (int) (Math.random() * 2);
// to generate a num whether 0/1, to decide the orientation
        if (ran == 0) {

            //go vertical
            //boats[i].setOrientation(true);
            if ((row - (size - 1)) <= 0) {
                placeBoatsHelper(i);
                //1. check whether there is enough space for the rest of the cells in the boat  ; if it isn't, call teh recrusion and generate a new 'first cell'
            } else {

                for (int n = 1; n < size - 1; n++) {
                    if (check[row - n][columns] == 'B') {
                        //2. check whether the rest of cells in the boat have been a part of another boat or not
                        placeBoatsHelper(i);
                    }
                }
                check[row][columns] = 'B';
                int count = 1;
                while (count < size) {
                    check[row - count][columns] = 'B';

                    count++;
                }
            }
        }

        if (ran == 1) {

            if ((columns - (size - 1)) <= 0) {
                placeBoatsHelper(i);
            } else {

                for (int n = 1; n < size - 1; n++) {
                    if (check[row][columns - n] == 'B') {

                        placeBoatsHelper(i);


                    }
                }
                check[row][columns] = 'B';
                int count = 1;
                while (count < size) {
                    check[row][columns - count] = 'B';
                    count++;
                }
            }

        }
    }

    public void placeBoats() {
        //forloop for boats
        for (int i = 0; i < boats.length; i++) {
            //boats[i] = get
            placeBoatsHelper(i);
            //place all teh boats in teh boats array
        }
    }


    public int fire(int x, int y) {


        if ((board.length == 3 && (x > 2 || y > 2)) || (board.length == 6 && (x > 5 || y > 5)) || (board.length == 9 && (x > 8 || y > 8))) {
            System.out.println("Penalty, Out of Bounds");
            return -1;
        }
        if (board[x][y].getStatus() == 'H' || board[x][y].getStatus() == 'M') {
            System.out.println("Penalty, Don't choose the same position twicee");
            return -1;
        }
        if (x < board.length && y < board.length && check[x][y] == '-') {
            board[x][y].setStatus('M');
            return 0;
        }
        if (x < board.length && y < board.length && check[x][y] == 'B') {
            board[x][y].setStatus('H');
            hitCount += 1;
            return 1;
        }
        return 100;


    }
    //hit should return if it hit or not so 0 or 1


    public void display() {
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                System.out.print(check[i][j]);

            }
            System.out.println();
        }
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getStatus());
            }
            System.out.println();
        }
    }

    public Board(int mode) {


        board = new Cell[mode][mode];
        check = new char[mode][mode];
        for (int i = 0; i < mode; i++) {
            for (int j = 0; j < mode; j++) {
                board[i][j] = new Cell(i, j, '-');
                check[i][j] = '-';
            }
        }


        if (mode == 3 || mode == 6 || mode == 9) {
            int numBoats = mode / 3 * 2 - 1;
            boats = new BattleBoats[numBoats];
            boatSizes = new int[numBoats];
            if (numBoats == 1) {
                System.out.println("you have " + numBoats + " boat.");


                boatSizes[0] = 2;


            } else {

                System.out.println("you have " + numBoats + " boats.");

            }


            if (numBoats == 3) {

                boatSizes[0] = 2;
                boatSizes[1] = 3;
                boatSizes[2] = 4;

            }


            if (numBoats == 5) {

                boatSizes[0] = 2;
                boatSizes[1] = 3;
                boatSizes[2] = 3;
                boatSizes[3] = 4;
                boatSizes[4] = 5;

            }
            for (int m = 0; m < boatSizes.length; m++) {
                boats[m] = new BattleBoats(boatSizes[m]);
                minTurns += boatSizes[m];

            }

        } else {
            System.out.println("Wrong number!");
        }
    }

    public int getMinTurns() {
        return minTurns;
    }

    public int getHitCount() {
        return hitCount;
    }

}