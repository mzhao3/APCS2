//Maggie Zhao
//APCS2 pd01
//HW #51: Heaping Piles of Sordidness
//2018-05-21m

public class HeapSort {
  private static ALHeap _min = new ALHeap();

  public static void printArr(int[] a)
  {
    String s = "";
    for(int x: a){
        s += x + " ";
    }
    System.out.println(s);
  }//O(n)


  // Sort array from smallest to largest using heapsort.
  // Precondition: a is an array
  public static int[] heapify( int[] a) {
    // Add all elements of the array to a heap, which will sort it
    for ( int i : a)
      _min.add(i);

    // Move elements from the heap to an array by popping off the root, which is the smallest number.
    int[] retArr = new int[a.length];
    for (Integer j = 0; j < a.length; j++)
      retArr[j] = _min.removeMin();

    return retArr;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 3, 2, 4, 8, 5, 0};
    System.out.print("Before heapifying: "); // 1, 3, 2, 4, 8, 5, 0
    printArr(arr1);
    System.out.print("After heapifying: "); // 0, 1, 2, 3, 4, 5, 8
    printArr(heapify(arr1));
  }
}
