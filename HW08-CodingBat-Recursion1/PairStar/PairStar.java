public class PairStar {

    // Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".


    public static String pairStar (String str) {
	if (str.length() < 2)
	    return str;
	if (str.substring(0,1).equals(str.substring(1,2)))
	    return str.substring(0,1) + "*" + pairStar (str.substring(1)) ;
	else
	    return str.substring(0,1) + pairStar(str.substring(1));
    }


    public static void main (String[] args) {
	System.out.println(pairStar("hello"));
        System.out.println(pairStar("xxyy"));
        System.out.println(pairStar("aaaa"));


    }

}
