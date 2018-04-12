// Maggie Zhao
// APCS2 pd01
// HW31-- Stack: What Is It Good For?
// 2018-04-11t

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/
public class LatKtS
{
  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
      String retStr = "";
      Latkes reverse = new Latkes(s.length());
      for (int i = 0; i < s.length() ; i ++) {
        reverse.push(s.substring(i, i + 1));
      }
      for (int j = s.length() - 1; j >= 0; j-- ) {
        retStr += reverse.pop();
      }
      return retStr;
  }//end flip()
  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
    if (s.length() % 2 == 1)
      return false;
    Latkes matches = new Latkes(s.length());
    for (int i = 0; i < s.length() ; i ++) {
      // if there is an opening bracket
      if ( ( s.substring(i, i + 1).equals("(") ) ||
           ( s.substring(i, i + 1).equals("{") ) ||
           ( s.substring(i, i + 1).equals("[") ) ) {

         // if there is an opening bracket as the last character, there is no closing bracket to match it
        if (i == s.length() - 1)
          return false;
        matches.push(s.substring(i, i + 1));
      }
      else {
        if (matches.isEmpty())
          return false;
      String opener = matches.peek();
      String closer = s.substring(i, i + 1);
      if (opener.equals("(") & closer.equals(")") ||
          opener.equals("{") & closer.equals("}") ||
          opener.equals("[") & closer.equals("]") )
        matches.pop();
      else
        return false;
      }
    }
    return true;
  }//end allMatched()

  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(flip("hand sanitizer"));
    System.out.println(flip("nurses run"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //trueSystem.out.println(allMatched( "()}" ) );
    System.out.println(allMatched( "(){" ) );
    System.out.println(allMatched( "()}" ) );
    System.out.println(allMatched( ""));
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }
}//end class LatKtS
