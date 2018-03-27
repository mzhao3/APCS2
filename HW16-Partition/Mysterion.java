// Maggie Zhao
// APCS1 pd2
// HW16-- About Face
// 2018-03-07

/***
 * class Mysterion
 * pseudocode expression of algo:
 * ------------------------------
 * fxn mysterion(arr,a,b,c) {
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 *     return s
 **/

public class Mysterion {
  /** WHAT DOES IT DO?????
  **/
  public static int mysterion(int[] arr, int a, int b, int c) {
    int v = arr[c];
    swap(arr, b, c);

    int s = a;
    for (int i = a; i < b; i++) {
      if (arr[i] <= v) {
        swap (arr, s, i);
        s++;
      }
    }
    swap(arr,b,s);
    System.out.println(toString(arr));
    return s;
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static String toString(int[] arr)
   {
       String s = "["; //start with opening bracket of the array
       for (int y :  arr) { //add each element of the array to the string
 	  s += (y + ",");
       }
       s += "]"; //end with a closing bracket
       return s;

   }

  public static void main( String[] args) {
    int[] arr1 = {7,1,5,12,3};
    int[] arr2 = {8,11,10,4,12};
    int[] arr3 = {9,8,7,6,5,4,3,2,};

    System.out.println("Testing arr1: [7,1,5,12,3]");
    /**
    for( int testC = 0; testC < 5; testC++ ) {
	    System.out.println("arr1: ");
	    System.out.println(toString(arr1));
	    mysterion(arr1,0,4,testC);
	    System.out.println("after mysterion w/ a=0,b=4,c="
                         + testC +"...");
	    System.out.println(toString(arr1));
	    System.out.println("-----------------------");
    }
    **/
    System.out.println(mysterion(arr1, 0,4,4));
    System.out.println(mysterion(arr1, 4,0,2)); // [7,3,1,12,5] & 2
    System.out.println(mysterion(arr1, 2,0,4)); // [1,3,5,12,7] & 2

// ======================================================
    System.out.println("Testing arr2: [8,11,10,4,12]");
    for( int testC = 0; testC < 5; testC++ ) {
	    System.out.println("arr2: ");
	    System.out.println(toString(arr2));
	    mysterion(arr2,0,4,testC);
	    System.out.println("after mysterion w/ a=0,b=4,c="
                         + testC +"...");
	    System.out.println(toString(arr2));
	    System.out.println("-----------------------");
    }

    System.out.println(mysterion(arr2, 1,3,0));
    System.out.println(mysterion(arr2, 1,3,1));
    System.out.println(mysterion(arr2, 1,3,2)); // [8,10,12,4,11] & 2
    System.out.println(mysterion(arr2, 1,3,3));
    System.out.println(mysterion(arr2, 0,3,1)); // [8,4,10,12,11] & 2

    System.out.println("Testing arr3: [9,8,7,6,5,4,3,2]");
    System.out.println(mysterion(arr3,0,4,2)); // [5,7,9,6,8,4,3,2] & 1
    System.out.println(mysterion(arr3,0,7,2)); // [5,7,2,6,8,4,9,3] & 6
    System.out.println(mysterion(arr3,0,7,3)); // [5,2,3,4,6,7,9,8] & 4
    System.out.println(mysterion(arr3,2,0,4)); // [3,2,6,4,5,7,9,8]& 2

  }

}
