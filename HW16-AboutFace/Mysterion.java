// Maggie Zhao
// APCS1 pd2
// HW16-- About Face
// 2018-03-07

public class Mysterion {
  /** I honestly could not find out what Mysterion did. All of the theories we developed today did not work.
    * The idea that Mysterion reversed an array that was sorted in descending order is disproved in my third test case.
    * It also does not sort the sections on either side of c.
    I have no clue what any of it could possibly mean.
  **/
  public static int mysterion(int[] arr, int a, int b, int c) {
    int v = arr[c];
    swap(arr, b, c);

    int s = a;
    for (int i = a; i < (b - 1); i++) {
      if (arr[i] < v) {
        swap (arr, s, i);
        s++;
      }
    }
    swap(arr,b,s);
    //System.out.println(toString(arr));
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
    System.out.println(mysterion(arr1, 0,4,2)); // [1,3,5,12,7] & 2
    System.out.println(mysterion(arr1, 4,0,2)); // [7,3,1,12,5] & 2
    System.out.println(mysterion(arr1, 2,0,4)); // [1,3,5,12,7] & 2

    System.out.println("Testing arr2: [8,11,10,4,12]");
    System.out.println(mysterion(arr2, 0,4,2)); // [8,10,12,4,11] & 1
    System.out.println(mysterion(arr2, 1,3,2)); // [8,10,12,4,11] & 2
    System.out.println(mysterion(arr2, 0,3,1)); // [8,4,10,12,11] & 2

    System.out.println("Testing arr3: [9,8,7,6,5,4,3,2]");
    System.out.println(mysterion(arr3,0,4,2)); // [5,7,9,6,8,4,3,2] & 1
    System.out.println(mysterion(arr3,0,7,2)); // [5,7,2,6,8,4,9,3] & 6
    System.out.println(mysterion(arr3,0,7,3)); // [5,2,3,4,6,7,9,8] & 4
    System.out.println(mysterion(arr3,2,0,4)); // [3,2,6,4,5,7,9,8]& 2

  }

}
