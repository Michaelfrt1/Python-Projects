import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Enter 0 for Debug mode, Enter anything else for regular mode");
        Scanner input = new Scanner(System.in);
        int gameMode = input.nextInt();
        if (gameMode == 0) {  // checks if the user wants to see the boats or not


            System.out.println("Welcome to the game, please choose the game mode, 3: Beginner, 6: Intermediate, 9: Expert");
            Scanner scan = new Scanner(System.in);
            int user = scan.nextInt();
            Board board = new Board(user);
            int totalTurns = 1;
            board.placeBoats();
            while (board.getHitCount() < board.getMinTurns()) {
                if (user == 3 || user == 6 || user == 9) {
                    // checks if user entered the right board length
                    board.print();
                    System.out.println();
                    board.display();

                    System.out.println("turn " + totalTurns + " , pick an X and Y coordinate of where you think the boat is. Columns and rows start from 0");
                    Scanner scan1 = new Scanner(System.in);
                    int user1 = scan1.nextInt();
                    Scanner scan2 = new Scanner(System.in);
                    int user2 = scan2.nextInt();
                    int result = board.fire(user1, user2);
                    if (result == -1) {

                        totalTurns++;
                        System.out.println("Skip " + "turn " + totalTurns);
                        // counts turns
                    }
                }
                totalTurns++;



            }
            System.out.println("You have played " + totalTurns + " turns. All boats are sunk. Game is over. You won");
            board.print();
            System.out.println();
            board.display();
        } else {
            System.out.println("Welcome to the game, please choose the game mode, 3: Beginner, 6: Intermediate, 9: Expert");
            Scanner scan = new Scanner(System.in);
            int user = scan.nextInt();
            Board board = new Board(user);
            int totalTurns = 1;
            board.placeBoats();

            while (board.getHitCount() < board.getMinTurns()) {
                if (user == 3 || user == 6 || user == 9) {
                    board.print();


                    System.out.println("turn " + totalTurns + " , pick an X and Y coordinate of where you think the boat is. Columns and rows start from 0");
                    Scanner scan1 = new Scanner(System.in);
                    int user1 = scan1.nextInt();
                    Scanner scan2 = new Scanner(System.in);
                    int user2 = scan2.nextInt();
                    int result = board.fire(user1, user2);
                    if (result == -1) {

                        totalTurns++;
                        System.out.println("Skip " + "turn " + totalTurns);
                    }
                }
                totalTurns++;


            }
            System.out.println("You have played " + totalTurns + " turns. All boats are sunk. Game is over. You won");
            board.print();
            System.out.println();
            board.display();

        }
    }

}
