//Maggie Zhao
//APCS2 pd01
//HW18 -- So So Quick
//2018-03-13t

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 *  i. Partition the array such that the pivot point is the number in the middle of the unsorted array
        - all values to the left of the pivot point are less than it (unsorted)
        - all values to the right of the pivot point are more than it (unsorted)
    ii. Repeat steps on the left half and right half of the array
        - if the array has a length of 1 (when left and right are equal), exit the sort
          (any array of length 1 is already sorted)
 * 2a. Worst pivot choice and associated runtime:
 *     Worst choice: end of the array (either first or last value in the array)
 *     Run time: O(n^2)
 * 2b. Best pivot choice and associated runtime:
 *     Best choice: middle of the array
 *     Run time: O(nlogn)
 * 3. Approach to handling duplicate values in array:
 *     I didn't have to make any special considerations for duplicates
        (maybe because partition took care of it?)
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------
  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
    qsortHelper (d, 0, d.length - 1);
  }

  //you may need a helper method...
public static void qsortHelper( int[] d, int left, int right){
  if (left == right)
    return;

  if (left < right) {
    int pvtPos = partition(d, left, right, (left + right) / 2);
    qsortHelper(d, left, pvtPos - 1);
    qsortHelper(d, pvtPos + 1, right);
  }

}

  /*
  Partition() divides the array such that
    * all elements on the left are smaller (but not necessarily sorted) than the
    pivot point input
    * all elements on the right are larger (but not necessarily sorted) than the
    pivot point input
    * the pivot point is at its final resting position
  It returns the final resting position of the number at the pivot point specified.
  ex:
  arr1 = { 7 , 1, 5, 12, 3}
  partition(arr1, 0 , 4, 3) ==> 4
  The number at the pivot point, 12, has a final resting point of 4.
  Big O runtime: O(n)
  */
    public static int partition(int[] arr, int left, int right, int pvtPos) {
      //printArr(arr);
      int pvtVal = arr[pvtPos];
      swap(right, pvtPos, arr);

      int storPos = left;
      for (int i = left; i < right; i++) {
        if (arr[i] <= pvtVal) {
          swap (storPos, i, arr);
          storPos++;
        }
      }
      swap(right, storPos, arr);
      //printArr(arr);
      return storPos;
    }

  //main method for testing
  public static void main( String[] args )
  {


    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
