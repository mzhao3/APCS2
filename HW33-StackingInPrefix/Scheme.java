// Maggie Zhao
// APCS2 pd01
// HW33- What a Racket
// 2018-04-13f

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Add all operators, integer operands, and open parens until you reach the first close parens (do not add this.)
 *   2. Create a separate stack that adds all Strings up to the matching opening parens (only the integer operands and operator, which is on the top of the stack). Pop out the opening parens.
 *   3. Compute the sum/difference/product of the numbers inside these parentheses.
 *   4. Push the final result into the outer stack.
 *   5. Repeat steps 1-4.
 * STACK OF CHOICE: ALStack by Mr.Brown
 * b/c I prefer to use ArrayLists over LinkedLists.
 ******************************************************/

public class Scheme
{
  /******************************************************
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr )
  {
    String[] exprArr = expr.split("\\s+");
    Stack<String> exprStack =  new ALStack<String>();
    for (int i = 0; i < exprArr.length; i ++ )
      if (!exprArr[i].equals(")"))
        exprStack.push(exprArr[i]);
      else {
        Stack<String> inParens = new ALStack<String>();
        while (! exprStack.peek().equals("(") )
          inParens.push(exprStack.pop());
        String operation = inParens.pop();
        if (operation.equals("+")) {
          exprStack.pop();
          exprStack.push(unload(1, inParens));
        }
        if (operation.equals("-")) {
          exprStack.pop();
          exprStack.push(unload(2, inParens));
        }
        if (operation.equals("*")) {
          exprStack.pop();
          exprStack.push(unload(3, inParens));
        }
      }
    return exprStack.pop();
  }//end evaluate()


  /******************************************************
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
    //System.out.println(numbers.toString());

      int ret = Integer.parseInt(numbers.pop());
      while (!numbers.isEmpty()){
      if (op == 1)
        ret += Integer.parseInt(numbers.pop());

      if (op == 2)
        ret -= Integer.parseInt(numbers.pop());

      if (op == 3)
        ret *= Integer.parseInt(numbers.pop());

    }
    return "" + ret;
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
        /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
