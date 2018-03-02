// Maggie Zhao
// APCS2 pd01
// HW07-- A Man, A Plan, A Canal: Panama!
// 2018-02-13


public class Resrever {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // helper function to create strings
    public static String makeString (int length) {
	String str = "";
	for (int i = 0; i < length; i++ ) {
	    int randLetter = (int) (Math.random() * 26) ;
	    str = str + ALPHABET.substring(randLetter, randLetter + 1);
	}
	return str;
    }

    // runs in linear time [ O(n) ]
    // traverses through the array, starting from the back end. it takes the last character and adds it to a string, to be returned
    
    public static String reverseA (String input) {
	String str  = "";
	for (int x = input.length(); x > 0; x --)
	    str = str + input.substring(x- 1,x);
	return str;
    }

    // *DOES NOT* run in logarithmic time
    // the first portion of the method, the splitting, runs in O(log(n)) time because the string is divided into two each time. however, the merging portion runs in O(n) time. You perform concatenation, and because strings are immutable, a new string is created an all elements copied over. Since rebuilding a string from one-letter-strings always takes O(n) time, there is no possible way to make a method that runs in O(log n) time. 

    public static String reverseB (String input) {
	// base case: if the string has been split until it reaches length 1, return the one letter string
	if (input.length() == 1)
	    return input;

	// if the length of the string is greater than 1, split the 2 halves of the string, and swap them
	else
	    return reverseB(input.substring(input.length() / 2)) + reverseB (input.substring(0, input.length()/2 ) ) ;
    }

    public static void main (String[] args){
	for (int y = 1; y < 35; y ++ ) {
	    String inp = makeString(y);
	    System.out.println("Original String : " + inp);
	    System.out.println("String length : " + inp.length() );
	    System.out.println("Reversed StringA : " + reverseA(inp) );
	    System.out.println("Reversed StringB : " + reverseB(inp) );
	    System.out.println("======~======~======~======~======~======~");

	}
    }
}
