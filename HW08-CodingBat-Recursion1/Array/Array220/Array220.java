public class Array220 {

    // Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

    public static boolean array220 (int[] nums, int index) {
	if (nums.length - index < 2)
            return false;
        if (nums[index] * 10 == (nums[index + 1] ) )
            return true;
        else
            return array220(nums, index + 1);
	
    }

    public static void main (String[] args) {
	int[] arr1 = {1, 2, 20} ;
	int[] arr2 = {3, 30} ;
	int[] arr3 = {3} ;
	
	System.out.println(array220(arr1, 0));
        System.out.println(array220(arr2, 0));
        System.out.println(array220(arr3, 0));


    }




}
