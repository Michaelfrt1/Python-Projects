

//The Hangman class  is designed for people and computers to be able to play the hangman game
//extends from the Game class

//This class contains the variables words(which allows access to the word bank)
//minWordLen which is the minimum letter word that this class will pick from the word bank
//maxWordlen which is the max letter word that this class will pick from the word bank
//and maxGuesses which is the amount of guesses the class gives to the comp or player
public class Hangman extends Game {

    WordsList words;
    int minWordLen;
    int maxWordLen;
    int maxGuesses;

    //variables that are not contained in the constructor but are used later in the program
    //variables used each round
    String secretWord;
    int numGuesses;
    char[] clueString;

    //constructor class containing previous mentioned variables
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses) {
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    /* prepToPlay function initializes the game by getting a random word from thew WordList class
    as well as setting the blank word to the same size as the random word from the list.
    It also fills the blank word with '_'.
    Returns a message to the player stating how long the word is and how many guesses they have.
     */
    @Override
    protected String prepToPlay() {
        secretWord = words.getWord(minWordLen, maxWordLen);
        int len = secretWord.length();
        numGuesses = 0;
        clueString = new char[len];
        for (int i = 0; i < len; i++) {
            clueString[i] = '_';
        }
        return "I've picked a " + len + " letter word. Guess letters you think are in the word. You get " + maxGuesses + " guesses.";
    }

    //isOVer checks if the game is over either by the player running out of guesses or by the player guessing all the words.
    @Override
    protected boolean isOver() {
        if (numGuesses == maxGuesses) {
            return true;
        }
        for (int i = 0; i < clueString.length; i++) {
            if (clueString[i] == '_') {
                return false;
            }
        }
        return true;
    }

    //checks if the move by the player or the computer is valid making sure they entered only one character
    //returns true if move is valid and false otherwise
    @Override
    protected boolean isValid(String move) {
        return move.length() == 1;
    }

    /*processMove function increases the number of guesses as well as lets the player guess what
    letter is in place the place of a blank space by changing the blank space to the move.
    returns the revealed letters in a String format*/
    @Override
    protected String processMove(String move) {
        numGuesses += 1;
        char[] secretW = new char[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            secretW[i] = secretWord.charAt(i);
        }
        for (int i = 0; i < secretW.length; i++) {
            if (move.charAt(0) == secretW[i]) {
                clueString[i] = move.charAt(0);
            }
        }
        return String.valueOf(clueString);


    }
    //returns a string that states the word the player was trying to guess was
    @Override
    protected String finalMessage() {
        return "The word was: " + secretWord;
    }
    // returns the name of the game
    @Override
    public String getName() {
        return "Hangman";
    }
}
