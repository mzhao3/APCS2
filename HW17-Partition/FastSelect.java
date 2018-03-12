// Maggie Zhao
// APCS2 pd01
// HW17 -- So So Fast
// 2018-03-11

public class FastSelect {
//--------------v  HELPER METHODS  v--------------
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
    swap( d, i, swapPos );
  }
}

//return int array of size s, with each element fr range [0,maxVal)
public static int[] buildArray( int s, int maxVal ) {
  int[] retArr = new int[s];
  for( int i = 0; i < retArr.length; i++ )
    retArr[i] = (int)( maxVal * Math.random() );
  return retArr;
}
  //swap values at indices a, b in array arr
  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
//--------------^  HELPER METHODS  ^--------------

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
    swap(arr, right, pvtPos);

    int storPos = left;
    for (int i = left; i < right; i++) {
      if (arr[i] <= pvtVal) {
        swap (arr, storPos, i);
        storPos++;
      }
    }
    swap(arr,right,storPos);
    //printArr(arr);
    return storPos;
  }

// wrapper method- takes an input of the array, and the yth smallest number you want to find
  public static int fastSelect(int[] arr, int y) {
return fastSelect(arr, 0, arr.length-1, y);
  }

/**
When partition() is called, the index of the pivot point is returned in its final resting position, and we know that
  - everything to the left is less than the number at the pivot point
  - everything to the right is greater than the number at the pivot point

If the final resting place is equal to the y position you are looking for, return the value
(e.g. if an array is partitioned, and a number falls at position 3, and you're looking for the 4th smallest number (which has an index of 3) you can exit)

Otherwise:
* If the y value you are looking for is less than the pivot point, search to the left of the pivot point using fastSelect() again
* If the y value you are looking for is greater than the pivot point, search to the right of the pivot point using fastSelect() again

Big O runtime: O(n^2)
Best case: The yth smallest value IS the partition point -- O(n)
Worst case: You have to traverse through the entire array to find the yth smallest number (usually because the array is already sorted) -- O(n^2)
**/
  public static int fastSelect(int[] arr, int left, int right, int y) {
int pivot = partition(arr,left,right,y-1);
// the *index* of the pivot is y - 1
if (pivot == (y - 1))
    return arr[pivot];
else if (pivot > y - 1)
    return fastSelect(arr,left,pivot-1,y);
else
    return fastSelect(arr,pivot+1,right,y);
  }

public static void main(String[] args) {
  int[] arr1 = {7,1,5,12,3};
  int[] arr2 = {8,11,10,4,12};
  int[] arr3 = {9,8,7,6,5,4,3,2};

printArr(arr1);
for( int testC = 1; testC < 5; testC++ )
  System.out.println("The " + testC + "th smallest number: " + fastSelect(arr1,testC));

printArr(arr2);
for( int testC = 1; testC < 5; testC++ )
  System.out.println("The " + testC + "th smallest number: " + fastSelect(arr2,testC));

printArr(arr3);
for( int testC = 1; testC < 5; testC++ )
  System.out.println("The " + testC + "th smallest number: " + fastSelect(arr3,testC));


  System.out.print("Best case: ");
  int[] arrb= new int[]{1, 8, 14, 22, 56};
  System.out.println(fastSelect(arrb, 1));
  System.out.print("Worst case: ");
  int[] arrw = new int[]{56, 22, 14, 8, 1};
  System.out.println(fastSelect(arrw,1));
}
}
