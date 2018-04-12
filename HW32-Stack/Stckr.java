// Maggie Zhao
// APCS2 pd01
// HW32-- Leon Leonwood Stack
// 2018-04-11r

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{
    public static void main( String[] args )
    {
	Stack<String> cakes = new ALStack<String>();
	//Stack<String> cakes = new LLStack<String>();

	//...
  System.out.println(cakes);
  System.out.println("Is stack cakes empty? " + cakes.isEmpty()); //true

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println("Pushing ice cream scoops...");
  cakes.push("ice cream scoops");
  System.out.println("Pushing flapjacks...");
  cakes.push("flapjacks");
  System.out.println("Pushing grilled chese sandwiches...");
  cakes.push("grilled cheese sandwiches");
  System.out.println("Pushing crepe cake...");
  cakes.push("crepe cake");
  System.out.println("Pushing pancakes...");
  cakes.push("pancakes");
  System.out.println("Pushing crackers...");
  cakes.push("crackers");

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println(cakes);
  System.out.println("Peeking at the top of the stack...");
  System.out.println("I spy some " + cakes.peek() + "."); //crackers

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println("Popping...");
  System.out.println(cakes.pop() + " has been popped."); //crackers

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println(cakes);
  System.out.println("Is stack cakes empty? " + cakes.isEmpty()); //false

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println("Popping...");
  System.out.println(cakes.pop() + " has been popped."); //pancakes
  System.out.println("Popping...");
  System.out.println(cakes.pop() + " has been popped."); //crepe cake
  System.out.println("Popping...");
  System.out.println(cakes.pop() + " has been popped."); //grilled cheese sandwiches

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println(cakes);
  System.out.println("Is stack cakes empty? " + cakes.isEmpty()); // false

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");

  System.out.println("Popping...");
  System.out.println(cakes.pop() + " has been popped."); //flapjacks
  System.out.println("Popping...");
  System.out.println(cakes.pop() + " has been popped."); //ice cream scoops

  System.out.println("ooooOooooOooooOooooOooooOooooOooooO\n");
  System.out.println(cakes);
  System.out.println("Is stack cakes empty? " + cakes.isEmpty()); // true
    }//end main

}//end class
