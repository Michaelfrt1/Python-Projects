import java.util.Scanner;

public class HangmanTester {
    public static void main(String[] args) {

        FakeWordList fwl = new FakeWordList("aardvark");
        Hangman hw = new Hangman(fwl, 4, 9, 10);

        System.out.println("TEST 1");
        String input = "r\nd\na\nq\nk\na\naardvark\nv\n";
        hw.play(new Scanner(input));

        System.out.println("TEST 1 part 2");
        input = "";
        for (int i = 0; i < 10; i++) {
            input += "a\n";
        }
        hw.play(new Scanner(input));



        System.out.println("TEST 2");
        fwl = new FakeWordList("bbb");
        hw = new Hangman(fwl, 3, 6, 5);

        input = "a\nb\n";
        hw.play(new Scanner(input));


        System.out.println("TEST 3");
        fwl = new FakeWordList("whatsup");
        hw = new Hangman(fwl, 3, 7, 7);

        input = "a\nh\np\nu\nw\nwhatsup\nt\ns\n";

        hw.play(new Scanner(input));
    }
}
/*


TEST 1
getWord 4 to 9
I've picked a 8 letter word. Guess letters you think are in the word. You get 10 guesses.
Enter Your Move or 'quit' to quit> __r___r_
Enter Your Move or 'quit' to quit> __rd__r_
Enter Your Move or 'quit' to quit> aard_ar_
Enter Your Move or 'quit' to quit> aard_ar_
Enter Your Move or 'quit' to quit> aard_ark
Enter Your Move or 'quit' to quit> aard_ark
Enter Your Move or 'quit' to quit> Invalid Move! try again> aardvark
The word was: aardvark
TEST 1 part 2
getWord 4 to 9
I've picked a 8 letter word. Guess letters you think are in the word. You get 10 guesses.
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
Enter Your Move or 'quit' to quit> aa___a__
The word was: aardvark
TEST 2
getWord 3 to 6
I've picked a 3 letter word. Guess letters you think are in the word. You get 5 guesses.
Enter Your Move or 'quit' to quit> ___
Enter Your Move or 'quit' to quit> bbb
The word was: bbb
TEST 3
getWord 3 to 7
I've picked a 7 letter word. Guess letters you think are in the word. You get 7 guesses.
Enter Your Move or 'quit' to quit> __a____
Enter Your Move or 'quit' to quit> _ha____
Enter Your Move or 'quit' to quit> _ha___p
Enter Your Move or 'quit' to quit> _ha__up
Enter Your Move or 'quit' to quit> wha__up
Enter Your Move or 'quit' to quit> Invalid Move! try again> what_up
Enter Your Move or 'quit' to quit> whatsup
The word was: whatsup


 */