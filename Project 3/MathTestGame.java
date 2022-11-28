import java.util.Random;
import java.util.Scanner;
import java.util.function.DoublePredicate;

/**
 * This game asks people to solve math problems!
 */
public class MathTestGame extends Game {

    // game difficulty variables (and other play-to-play reused variables)
    private Random rng;
    private int minVal;
    private int maxVal;
    private char operator;

    // variables used each round. -- each round uses a value a and b
    private int a;
    private int b;
    // did the last guess win?
    private boolean won;

    /**
     * Create a new Math test game
     * @param rng the random number generator to use
     * @param minVal the minimum number to use for left/right values (inclusive)
     * @param maxVal the maximum number to use for left/right values (inclusive)
     * @param operator the operator to test should be '+', '*', '-', or '/'
     *                 invalid values will be treated as '+'
     */
    public MathTestGame(Random rng, int minVal, int maxVal, char operator) {
        this.rng = rng;
        this.minVal = minVal;
        this.maxVal = maxVal;

        if ("+*-/".indexOf(operator) == -1) {
            operator = '+';
        }
        this.operator = operator;
    }

    /**
     * Apply the configured operator
     */
    private int applyOperator(int a, int b) {
        if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else if (operator == '/') {
            return a / b;
        } else {
            return a + b;
        }
    }

    /**
     * Setup for a new game by creating a new a and b value.
     * Also reset the "won" variable
     * @return a message indicating the question.
     */
    @Override
    protected String prepToPlay() {
        a = rng.nextInt(maxVal-minVal+1)+minVal;
        b = rng.nextInt(maxVal-minVal+1)+minVal;
        // new game -- reset won!
        won = false;
        return "what is "+a+" "+operator+" "+b+"? (Answer as integer)";
    }

    /**
     * The name (for in the menu system)
     */
    @Override
    public String getName() {
        return "Math Test "+operator;
    }

    /**
     * Check if the current execution of the game is won!
     */
    @Override
    protected boolean isOver() {
        return won;
    }

    /**
     * Check if move encodes is a positive/negative integer
     */
    @Override
    protected boolean isValid(String move) {

        if (move.length() > 0 && move.charAt(0) == '-') {
            // remove a single negative sign
            move = move.substring(1);
        }
        if (move.length() == 0) {
            return false;
        }
        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the move encodes the answer or not.
     */
    @Override
    protected String processMove(String move) {
        // This function is only supposed to be called when isValid is true
        // we can assume this is true without checking it, which means the
        // following won't crash.
        int guess = Integer.parseInt(move);
        won = (guess == applyOperator(a, b));
        // return null to say "no message needed"
        return null;
    }

    /**
     * Print this message when the game is over.
     */
    @Override
    protected String finalMessage() {
        // since this game only ends on a correct answer...
        return "That's it!";
    }

    // we don't strictly need this
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner s = new Scanner(System.in);
        MathTestGame mt = new MathTestGame(rng, 1, 10, '+');
        mt.play(s);
    }
}