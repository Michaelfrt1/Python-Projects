import java.util.Scanner;

/**
 * A single game object represents a single game. It is designed to be playable more than once.
 */
public abstract class Game {
    protected abstract String prepToPlay();
    protected abstract boolean isOver();
    protected abstract boolean isValid(String move);
    protected abstract String processMove(String move);
    protected abstract String finalMessage();
    public abstract String getName();

    /**
     * This class represents a general outline of playing a game
     * It might be a bit intimidating, but I recommed looking over it
     *
     * @param user -- the scanner connected ot the user
     *             typically this would be connected to system.in,
     *             but not always
     */
    public void play(Scanner user) {
        System.out.println(prepToPlay());
        while(!isOver()) {
            // loop until valid move. quit always quits
            // (you don't need to handle this in your code!)
            System.out.print("Enter Your Move or 'quit' to quit> ");
            String move = user.next();
            while(! isValid(move) && ! "quit".equals(move)) {
                System.out.print("Invalid Move! try again> ");
                move = user.next();
            }

            // check for special "quit" value
            if ("quit".equals(move)) {
                break;
            }

            // process the move
            String message = processMove(move);

            // if a message was returned -- print it!
            if (message != null) {
                System.out.println(message);
            }
        }
        // print the final message after the game!
        System.out.println(finalMessage());
    }
}
