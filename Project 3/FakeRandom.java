import java.util.Random;

/**
 * This class is provided to help with testing.
 * It allows us to prespecify a random number.
 *
 * NOTE -- this only works with the nextInt(int) method -- which you are required to use for random integer generation.
 */
public class FakeRandom extends Random {
    private int random;

    public FakeRandom(int random) {
        this.random = random;
    }

    @Override
    public int nextInt(int bound) {
        System.out.println("nextInt: "+bound);
        return random;
    }
}
