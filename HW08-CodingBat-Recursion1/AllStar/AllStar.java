public class AllStar {

    // Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

    public static String allStar(String str) {
	if (str.length() == 0)
	    return "";
	if (str.length() == 1)
	    return str;
	return str.substring(0,1) + "*" + allStar(str.substring(1));
    }

    public static void main (String[] args) {
	System.out.println(allStar("hello") );
        System.out.println(allStar("abc") );
        System.out.println(allStar("ab") );


    }
}
