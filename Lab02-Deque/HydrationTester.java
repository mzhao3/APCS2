//Hydration (Maggie Zhao, Sophia Xia, Zane Wang)
//APCS2 pd1
//QQKachoo Driver

public class DequeTester{
  public static void main(String[] args) {
    QQKachoo<String> liquids = new QQKachoo<String>();

    System.out.println("Is the the Deque empty? " + liquids.isEmpty() ); //true
    System.out.println("-----Adding to front------");
    liquids.addFirst("HotChocolate");
    System.out.println(liquids.peekFirst()); //HotChocolate
    liquids.addFirst("Vanilla");
    System.out.println(liquids.peekFirst()); //Vanilla
    liquids.addFirst("Milk");
    System.out.println(liquids.peekFirst()); //Milk
    liquids.addFirst("OJ");
    System.out.println(liquids.peekFirst()); //OJ

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(liquids); //OJ Milk Vanilla HotChocolate
    System.out.println("Is the the Deque empty ?" + liquids.isEmpty() ); //false

    System.out.println("");

    System.out.println("-----Adding to end------");
    liquids.addLast("Water");
    System.out.println(liquids.peekLast()); //Water
    liquids.addLast("Coffee");
    System.out.println(liquids.peekLast()); //Coffee
    liquids.addLast("Rain");
    System.out.println(liquids.peekLast()); //Rain

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(liquids); //OJ Milk Juice HotChocolate Water Coffee Rain

    System.out.println("");

    System.out.println("-----Removing from front-----");
    liquids.pollFirst(); //OJ dies
    System.out.println(liquids.peekFirst()); //Milk

    System.out.println("");

    System.out.println("-----Removing from end-----");
    liquids.pollLast(); //Rain dies
    System.out.println(liquids.peekLast()); //Coffee

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(liquids); //OJ Milk Juice HotChocolate Water Coffee Rain

    System.out.println("");

    System.out.println("------REMOVING EVERYTHING------");
    System.out.println(liquids);
    liquids.pollFirst();
    System.out.println(liquids);
    liquids.pollLast();
    System.out.println(liquids);
    liquids.pollFirst();
    System.out.println(liquids);
    liquids.pollLast();
    System.out.println(liquids);
    liquids.pollFirst();
    System.out.println(liquids);

    System.out.println("Is it empty yet?: "+ liquids.isEmpty()); //true

    System.out.println("Trying to alter empty deque...");
    System.out.println("Trying to peekFirst: " + liquids.peekFirst());
    System.out.println("Trying to peekLast: " + liquids.peekLast());
    System.out.println("Trying to pollFirst: "+ liquids.pollFirst());
    System.out.println("Trying to pollLast: " + liquids.pollLast());
  }
}
