import java.util.Scanner;

public class NumberGuesserTester {
    public static void main(String[] args) {
        System.out.println("Test 1");

        FakeRandom fr = new FakeRandom(49); // should mean a random number of 50.
        NumberGuesser ng = new NumberGuesser(fr, 72, 5);

        String input = "apple\n51\n50\n49\n";
        ng.play(new Scanner(input));

        System.out.println("TEST 1 PHASE 2");
        input = "apple\n1\n2\ndog\n4\npear\n3\n5\n";
        ng.play(new Scanner(input));

        System.out.println("Test 2");

        fr = new FakeRandom(76); // should mean a random number of 77.
        ng = new NumberGuesser(fr, 100, 8);

        input = "49\n51\n50\n-1\n0\n100\n101\n77\n78\n";
        ng.play(new Scanner(input));

        System.out.println("Test 3");

        fr = new FakeRandom(9); // should mean a random number of 10.
        ng = new NumberGuesser(fr, 10, 5);

        input = "1\n4\n5\n9\n10\n";
        ng.play(new Scanner(input));
    }
}

/*

Test 1
nextInt: 72
I've picked a number 1 to 72. You get 5 guesses to guess it
Enter Your Move or 'quit' to quit> Invalid Move! try again> Too High
Enter Your Move or 'quit' to quit> That's it!
The number was: 50
TEST 1 PHASE 2
nextInt: 72
I've picked a number 1 to 72. You get 5 guesses to guess it
Enter Your Move or 'quit' to quit> Invalid Move! try again> Too Low
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Invalid Move! try again> Too Low
Enter Your Move or 'quit' to quit> Invalid Move! try again> Too Low
Enter Your Move or 'quit' to quit> Too Low
The number was: 50
Test 2
nextInt: 100
I've picked a number 1 to 100. You get 8 guesses to guess it
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Invalid Move! try again> Too Low
Enter Your Move or 'quit' to quit> Too High
Enter Your Move or 'quit' to quit> Too High
Enter Your Move or 'quit' to quit> That's it!
The number was: 77
Test 3
nextInt: 10
I've picked a number 1 to 10. You get 5 guesses to guess it
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> Too Low
Enter Your Move or 'quit' to quit> That's it!
The number was: 10


 */
