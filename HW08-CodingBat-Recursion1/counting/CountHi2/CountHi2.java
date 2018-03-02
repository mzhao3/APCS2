public class CountHi2 {
    // Given a string, compute recursively the number of times
    // lowercase "hi" appears in the string, however do not count
    // "hi" that have an 'x' immediately before them.

public static int countHi2(String str) {
	if (str.length() < 2)
	    return 0;
  if (str.substring(0,1).equals("x") && str.length() >= 3)
   {
      if (str.substring(1,3).equals("hi") )
          return countHi2(str.substring(3));
      return countHi2(str.substring(1) );
  }
  else if (str.substring(0,2).equals("hi") )
	    return countHi2(str.substring(2) ) + 1;
	else
	    return countHi2(str.substring(1));
    }

    public static void main (String[] args) {
	      System.out.println(countHi2("ahixhi"));
        System.out.println(countHi2("ahibhi"));
        System.out.println(countHi2("xhixhi"));
	      System.out.println(countHi2("xxhi"));
	      System.out.println(countHi2("hixxhi") );

    }


}
