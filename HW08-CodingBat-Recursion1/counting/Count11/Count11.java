public class Count11 {
    // Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.

    public static int count11(String str) {
	if (str.length() < 2)
	    return 0;
	if ( str.substring(0,2).equals("11") )
	    return count11(str.substring(2)) + 1;
	else
	    return count11(str.substring(1));
    }

    public static void main (String[] args) {
	System.out.println(count11("11abc11"));
        System.out.println(count11("abc11x11x11") );
        System.out.println(count11("111"));


    }

}
