public class CountX {
    // Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
    
    public static int countX(String str) {
	if (str.length() == 0)
	    return 0;
	
	if (str.substring(str.length() - 1 ).equals("x"))
	    return countX(str.substring(0, str.length() - 1) ) + 1;
       
	return countX(str.substring(0, str.length() - 1) );

    }
    
    public static void main(String[] args) {
	System.out.println(countX("xxhixx"));
	System.out.println(countX("xhixhix"));
	System.out.println(countX("hi") );
	
	
    }
    
    
}
