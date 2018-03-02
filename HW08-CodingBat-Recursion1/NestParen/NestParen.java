public class NestParen {
// Given a string, return true if it is a nesting of zero or more
// pairs of parenthesis, like "(())" or "((()))".
// Suggestion: check the first and last chars, and then recur on
// what's inside them.

  public static boolean nestParen(String str) {
    if (str.length() == 0)
      return true;
    return ( str.substring(0,1).equals("(") &&
             str.substring(str.length()-1).equals(")") &&
             nestParen(str.substring(1, str.length()-1) ) );
  }

  public static void main (String[] args) {
	      System.out.println(nestParen("(())"));
        System.out.println(nestParen("((()))"));
        System.out.println(nestParen("(((x))"));


    }


}
