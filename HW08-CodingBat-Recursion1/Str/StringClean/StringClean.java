public class StringClean {
    // Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".


    public static String stringClean(String str) {
	if (str.length() == 0)
	    return "";
	if (str.length() == 1)
	    return str;
	if (str.substring(0,1).equals(str.substring(1,2)) )
	    return stringClean(str.substring(1));
	else
	    return str.substring(0,1) + stringClean(str.substring(1));

    }

    public static void main (String[] args) {
	System.out.println(stringClean("yyzzza") );
        System.out.println(stringClean("abbbcdd"));
        System.out.println(stringClean("Hello"));


    }


}
